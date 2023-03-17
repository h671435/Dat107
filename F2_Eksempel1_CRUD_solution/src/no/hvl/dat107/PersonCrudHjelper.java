package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PersonCrudHjelper implements PersonCrudInterface {

	private EntityManagerFactory emf;
	
	public PersonCrudHjelper() {
		emf = Persistence.createEntityManagerFactory("personPersistenceUnit", 
				Map.of("jakarta.persistence.jdbc.password", "pass"));
	}
	
	@Override
	public void lagrePerson(Person p) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(p); //Oppretter en ny rad i databasen
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	@Override
	public Person hentPerson(int id) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Person.class, id); //Henter ut på primærnøkkel
		} finally {
			em.close();
		}
	}
	
	@Override
	public List<Person> hentAllePersoner() {

		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT p FROM Person as p order by p.id";

		try {
			TypedQuery<Person> query = em.createQuery(jpqlQuery, Person.class);
			return query.getResultList(); //Henter ut basert på spørring
		} finally {
			em.close();
		}
	}
	
	@Override
	public List<Person> hentAllePersonerNQ() {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Person> query = em.createNamedQuery("hentAllePersoner", Person.class);
			return query.getResultList(); //Henter ut basert på spørring
		} finally {
			em.close();
		}
	}
	
	@Override
	public void oppdaterPerson(int id, String navn) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			//enten
			em.merge(new Person(id, navn));
			//eller
			Person p = em.find(Person.class, id); //Finne rad som skal oppdateres
			p.setNavn(navn); //Oppdatere managed oject p => sync med database
		
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void slettPerson(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			Person p = em.find(Person.class, id); //Finne rad som skal slettes
			em.remove(p); //Slette rad som tilsvarer managed oject p
			
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
}
