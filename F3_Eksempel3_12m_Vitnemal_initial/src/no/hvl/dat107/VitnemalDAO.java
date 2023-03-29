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
		emf = Persistence.createEntityManagerFactory("vitnemalPU", Map.of("jakarta.persistence.jdbc.password", "pass"));
	}

	/* --------------------------------------------------------------------- */

	public Vitnemal hentVitnemalForStudent(int snr) {

		EntityManager em = emf.createEntityManager();
		try {

			return em.find(Vitnemal.class, snr);

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Karakter hentKarakterForStudentIEmne(int studNr, String emnekode) {

		EntityManager em = emf.createEntityManager();

		try {

			String q = "SELECT k FROM Karakter AS k WHERE k.vtinemal.studNr = :snr AND k.emnekode = :ekode";
			TypedQuery<Karakter> query = em.createQuery(q, Karakter.class);
			query.setParameter("snr", query);
			query.setParameter("ekode", emnekode);

			return query.getSingleResult(); // Ønsker å returnere null hvis ikke funnet

		} catch (NoResultException e) {
			return null;

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Karakter registrerKarakterForStudent(int studNr, String emnekode, LocalDate dato, String bokstav) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			// (1) Hente gammel karakter
//			NB! gml er detatched
			Karakter gml = hentKarakterForStudentIEmne(studNr, emnekode);

//			(2) Hent vitnemål
//			NB! vm er detatched. Kanskje dert går bra?
			Vitnemal vm = hentVitnemalForStudent(studNr);
//			For sikkerhets skyld. Gjør vm managed.
			vm = em.merge(vm);

//			(3) Opprette nytt objekt 
//			NB! Ny er new
			Karakter ny = new Karakter(emnekode, dato, bokstav);

//			(4) 
			ny.setVitnemal(vm);

//			(5)
			vm.leggTilkarakter(ny);

//			(6) NB! Nå er ny "managed" + den har fått primærnøkkel
			em.persist(ny);

			if (gml != null) {
//				(7) 
				vm.fjernKarakter(gml);
//				(8)
				em.remove(em.merge(gml));
			}

			tx.commit();

			return ny;

		} finally {
			em.close();
		}
	}
}
