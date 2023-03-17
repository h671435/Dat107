package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TodoDAO {
	
	private EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("todoPersistenceUnit", 
			Map.of("jakarta.persistence.jdbc.password", "pass"));
	
	/* --------------------------------------------------------------------- */

	public List<Todo> finnAlleTodos() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			String ql = "select t from Todo t";
			TypedQuery<Todo> query = em.createQuery(ql, Todo.class);
			
			return query.getResultList();

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ finnTodoMedPk(/*???*/) {
		
		EntityManager em = emf.createEntityManager();

		try {
			/*???*/
			return null /*???*/; 

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ finnTodoMedTekst(/*???*/) {
		EntityManager em = emf.createEntityManager();
		
		try {
			/*???*/
			return null /*???*/; 
			
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public Object/*???*/  finnTodosMedTekst(/*???*/) {
		EntityManager em = emf.createEntityManager();
		
		try {
			/*???*/
			return null /*???*/; 
		
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ lagreNyTodo(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ slettTodoMedPk(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ oppdaterTodo(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}

	/* --------------------------------------------------------------------- */

	public Object/*???*/ oppdaterTekst(/*???*/) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			/*???*/
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
		return null /*???*/; 
	}
}
