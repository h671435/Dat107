package no.hvl.dat107;

import java.util.Scanner;

import java.util.List;

public class Main {

	//-------------------------------------------------------------------------
	
	/*
	 *  Hjelpeklasse for å snakke med databasen.
	 *  DAO er en forkortelse for Data Access Object,
	 *  og er et vanlig navn på slike.
	 */
	private static TodoDAO todoDAO = new TodoDAO();
	
	public static void main(String[] args) {

		/* 
		 * Databasen i utgangspunktet:
		 * 	1, 'Handle mat'
		 * 	2, 'Vaske opp'
		 *  3, 'Ta ut bosset'
		 */

		// a) Hente ut alle todos
		List<Todo> todos = todoDAO.finnAlleTodos();
		System.out.println(todos);
//		pauseOgSjekkPgAdmin(todos, "");
		
		// b) Hente ut todo med pk=2
		
		Todo finnTodoMedPk = todoDAO.finnTodoMedPk(2);
		System.out.println(finnTodoMedPk);
		
		// c.i)   Hente ut SINGLE todo med tekst="Handle mat" 

		Todo finnTodoMedTekst = todoDAO.finnTodoMedTekst("Handle mat");
		System.out.println(finnTodoMedTekst);
		
		// c.ii)  Hente ut SINGLE todo med tekst="Vaske bilen" (som ikke finnes)
		
		todoDAO.finnTodoMedTekst("Vaske bil");
		
		// c.iii) Hente ut LISTE av todos med tekst="Handle mat" 
		
		List<Todo> todos2 = todoDAO.finnTodosMedTekst("Handle mat");
		System.out.println(todos2);
		
		// c.iv)  Hente ut LISTE av todos med tekst="Vaske bilen" (som ikke finnes)
		
		List<Todo> finnTodosMedTekst2 = todoDAO.finnTodosMedTekst("Vaske bilen");
		System.out.println(finnTodosMedTekst2);
		
		// d) Legge til en ny todo med pk=4
		
		Todo lagreNyTodo = todoDAO.lagreNyTodo(new Todo(4, "Vaske bilen"));
		System.out.println(lagreNyTodo);
		
		// e) Slette todo med pk=4
		
		todoDAO.slettTodoMedPk(4);
		System.out.println("Slettet en Todo ting med pk 4");
		
		
		// f) Endre tekst på todo med pk=2
		todoDAO.oppdaterTodo(2, "Morra di vasker bil mi");
		List<Todo> tod = todoDAO.finnAlleTodos();
		System.out.println(tod);		
		
		// g) Endre tekst på todo med pk=3, alternativ måte
		todoDAO.oppdaterTodo(2, "Moren din e broren din og faren din e besteomren din");
		List<Todo> todd = todoDAO.finnAlleTodos();
		System.out.println(todd);
		
	}
	
	//-------------------------------------------------------------------------
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void pauseOgSjekkPgAdmin(List<Todo> todos, String sisteAction) {
		System.out.println("\n" + sisteAction);
		System.out.println("\nTodo-objekter i persistence context nå:");
		todos.forEach(System.out::println);
		System.out.println("\nSjekk om det ser likt ut i PgAdmin.");
		System.out.println("\nTrykk \"ENTER\" for å fortsette programmet ...");
		scanner.nextLine();
	}
	

}
