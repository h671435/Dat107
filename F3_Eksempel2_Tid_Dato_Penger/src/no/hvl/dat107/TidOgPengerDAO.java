package no.hvl.dat107;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TidOgPengerDAO {

    private EntityManagerFactory emf;

    public TidOgPengerDAO() {
        emf = Persistence.createEntityManagerFactory("datatyperPersistenceUnit", 
        		Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
    }

    public TidOgPenger hentTidOgPengerMedId(int id) {
        
        EntityManager em = emf.createEntityManager();

        TidOgPenger dt = null;
        try {
            dt = em.find(TidOgPenger.class, id);
        } finally {
            em.close();
        }
        return dt;
    }

    public int lagreIDatabasen(TidOgPenger ny) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(ny);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return ny.getId();
    }

}
