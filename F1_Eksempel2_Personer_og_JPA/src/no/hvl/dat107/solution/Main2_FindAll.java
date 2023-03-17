package no.hvl.dat107.solution;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main2_FindAll {

	public static void main(String[] args) {

		String jpql = "SELECT p FROM Person p"; //NB! Dette er ikke SQL, men JPQL
		List<Person> personer = null;
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("personPersistenceUnit", 
				Map.of("jakarta.persistence.jdbc.password", "pass"));

		System.out.println("Kobler til database...");
		EntityManager em = emf.createEntityManager();
		try {
	        TypedQuery<Person> query = em.createQuery(jpql, Person.class);
	        personer = query.getResultList();
		} finally {
	        em.close();
		}
		
		System.out.println("Resultat:");
		for (Person p : personer) {
			System.out.println(p);
		}
		System.out.println("Ferdig!");
	}
}
