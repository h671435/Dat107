package no.hvl.dat107;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class VitnemalDAO {

    private EntityManagerFactory emf;

    public VitnemalDAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU",
		Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
    }
    
    /* --------------------------------------------------------------------- */

    public Vitnemal hentVitnemalForStudent(int studNr) {
        
        EntityManager em = emf.createEntityManager();
        try {
        	
        	return em.find(Vitnemal.class, studNr);
        	
        } finally {
            em.close();
        }
    }

    /* --------------------------------------------------------------------- */

    public Karakter hentKarakterForStudentIEmne(int studNr, String emnekode) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	
        	String q = "SELECT k FROM Karakter AS k "
        			+ "WHERE k.vitnemal.studNr = :snr AND k.emnekode = :ekode";
        	TypedQuery<Karakter> query = em.createQuery(q, Karakter.class);
        	query.setParameter("snr", studNr);
        	query.setParameter("ekode", emnekode);
        	
        	return query.getSingleResult(); //Ønsker å returnere null hvis ingen funnet
        	
        } catch(NoResultException e) {
        	return null;
        	
        } finally {
            em.close();
        }
    }
    
    /* --------------------------------------------------------------------- */

    public Karakter registrerKarakterForStudent(
    		int studNr, String emnekode, LocalDate dato, String bokstav) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
        	tx.begin();
        	
        	/* Nummerne i løsningen refererer til tegningen vi gjorde i timen (F4).
        	 * Da viste jeg en grafisk modell av de involverte objektene i prosessen
        	 * og satte nummer på skrittene som måtte gjøres.
        	 * Et skjermbilde av tegningen er vedlagt i prosjektet.
        	 */
        	
        	//(1) NB! gml kan også være null hvis ingen karakter ble funnet i søket.
        	//    NB! gml er "detatched". Må gjøres "managed" før den kan slettes.
        	Karakter gml = hentKarakterForStudentIEmne(studNr, emnekode);
        	
        	if (gml != null) {
        		gml = em.merge(gml);
        	}
        	
        	//(2) NB! vm er "detatched". Må gjøres "managed" pga. oppdateringer
        	Vitnemal vm = hentVitnemalForStudent(studNr);
        	vm = em.merge(vm);
        	
        	if (gml != null) {
            	//(7)
        		vm.fjernKarakter(gml);
        		//(8)
        		em.remove(em.merge(gml));
        		
        		/*
        		 * em.flush() oppdaterer databasen NÅ, FØR det gjøres en commit!
        		 * På den måten unngår vi PSQLException: Duplicate key value violates 
        		 * unique constraint "karunique" på 
        		 * key (emnekode, studnr) = (DAT100, 123456) already exists.
        		 */
        		em.flush();
        	}
        	
        	//(3) NB! ny er i "new"-tilstand.
        	Karakter ny = new Karakter(emnekode, dato, bokstav);
        	
        	//(4)
        	ny.setVitnemal(vm);
        	
        	//(5)
        	vm.leggTilKarakter(ny);
        	
        	
         	//(6) NB! Nå er ny "managed" + den har fått primærnøkkel av databasen
        	em.persist(ny);
       	
        	tx.commit();
        	
        	return ny;

        } finally {
            em.close();
        }
    }
}



























