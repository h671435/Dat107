package no.hvl.dat107;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class TodolisteDAO {

    private EntityManagerFactory emf;

    public TodolisteDAO() {
        emf = Persistence.createEntityManagerFactory("todosPU");
    }

    public Todoliste hentListe(int id) {
        EntityManager em = emf.createEntityManager();
        try {
        	return em.find(Todoliste.class, id);
        	
        } finally {
            em.close();
        }
    }

    public void lagreNyListe(Todoliste nyListe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nyListe);
            tx.commit();
            
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void slettListe(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            /*TODO*/
            tx.commit();
            
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void oppdaterListe(Todoliste oppdatertListe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            /*TODO*/
            tx.commit();
            
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public /*TODO*/void hentListeMedNavn(/*TODO*/) {

        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
            
        } catch (NoResultException e) {
            // catcher denne og returnerer null :)
        } finally {
            em.close();
        }
    }

    public /*TODO*/void hentTodosIListe(/*TODO*/) {

        EntityManager em = emf.createEntityManager();
        try {
        	
        	/*TODO*/
        	
        } finally {
            em.close();
        }
    }

}
