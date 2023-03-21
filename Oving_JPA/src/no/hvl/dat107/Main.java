package no.hvl.dat107;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistanceUnit");

	public static void main(String[] args) {

		Main main = new Main();
		System.out.println("Skriv inn brukernavn");
		Scanner sc = new Scanner(System.in);
		String brukernavn = sc.nextLine();
		Ansatt funnet = main.finnAnsattMedBrukernavn(brukernavn);
		System.out.println(funnet);
		sc.close();
	}

	public Ansatt finnAnsattMedBrukernavn(String a) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Ansatt.class, a);
		} finally {
			em.close();
		}
	}
}
