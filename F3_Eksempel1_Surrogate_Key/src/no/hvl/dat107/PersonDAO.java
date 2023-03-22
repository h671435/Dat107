package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PersonDAO {

    private EntityManagerFactory emf;
    
    public PersonDAO() {
    	emf	= Persistence.createEntityManagerFactory("personPersistenceUnit", 
		Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
    }
    
    public int savePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(p);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return p.getId();
    }
    
    public Person retrievePerson(int id) {

        EntityManager em = emf.createEntityManager();

        Person p = null;
        try {
            p = em.find(Person.class, id);
        } finally {
            em.close();
        }
        
        return p;
    }
    
    public List<Person> retrieveAllePersoner() {

        EntityManager em = emf.createEntityManager();

        List<Person> personer = null;
        try {
            String queryString = "SELECT p FROM Person p ORDER BY p.id";
            TypedQuery<Person> query = em.createQuery(queryString, Person.class);
            personer = query.getResultList();
        } finally {
            em.close();
        }
        return personer;
    }
    
    public void updatePerson(Person p) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Person q = em.merge(p);
            
            boolean x = p.getNavn().equals("X");
            if (x) p.setNavn("Tull");   //Virker ikke siden p er detached
            if (x) q.setNavn("Tull");   //Virker siden q er managed
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void deletePerson(Person p) {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.find(Person.class, p.getId()));
//            em.remove(em.merge(p)); Vel ..?
            em.getTransaction().commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
