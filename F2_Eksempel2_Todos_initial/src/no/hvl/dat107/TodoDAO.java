package no.hvl.dat107;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TodoDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("todoPersistenceUnit",
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

	public Todo finnTodoMedPk(int pk) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Todo.class, pk);

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Todo finnTodoMedTekst(String tekst) {
		EntityManager em = emf.createEntityManager();

		try {
			String ql = "select t from Todo t where t.tekst like '" + tekst + "'";
			TypedQuery<Todo> query = em.createQuery(ql, Todo.class);
			return query.getResultList().get(0);
// GET.SINGLERESULT ELLER NOE SÅNT FUNKER OGSÅ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fant ingen elementer med tekst: " + tekst);
			return null;
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public List<Todo> finnTodosMedTekst(String tekst) {
		EntityManager em = emf.createEntityManager();

		try {
			String ql = "select t from Todo t where t.tekst like '" + tekst + "'";
			TypedQuery<Todo> query = em.createQuery(ql, Todo.class);
			return query.getResultList();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fant ingen elementer med tekst: " + tekst);
			return null;
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Todo lagreNyTodo(Todo t) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();
			em.persist(t);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		return t;

	}

	/* --------------------------------------------------------------------- */

	public void slettTodoMedPk(int pk) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Todo t = em.find(Todo.class, pk);
			em.remove(t);

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public void oppdaterTodo(int pk, String tekst) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Todo t = em.find(Todo.class, pk);
			t.setTekst(tekst);

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public void oppdaterTekst(int pk, String tekst) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			em.merge(new Todo(pk, tekst));

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
}
