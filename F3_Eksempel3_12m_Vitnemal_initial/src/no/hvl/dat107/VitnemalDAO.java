package no.hvl.dat107;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class VitnemalDAO {

    private EntityManagerFactory emf;

    public VitnemalDAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU",
		Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
    }
    
    /* --------------------------------------------------------------------- */

    public /*TODO*/void hentVitnemalForStudent(/*TODO*/) {
        
        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
        	
        } finally {
            em.close();
        }
    }

    /* --------------------------------------------------------------------- */

    public /*TODO*/void hentKarakterForStudentIEmne(/*TODO*/) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	
        	/*TODO*/
        	
        } finally {
            em.close();
        }
    }
    
    /* --------------------------------------------------------------------- */

    public /*TODO*/void registrerKarakterForStudent(/*TODO*/) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
        	tx.begin();
        	
        	/*TODO*/
        	
        	tx.commit();
        	
        } finally {
            em.close();
        }
    }
}

