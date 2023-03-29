package no.hvl.dat107;

import java.util.List;

public class Main {

//	private static Scanner scanner = new Scanner(System.in);
//	private static void pauseOgSjekkDatabasen(String prompt) {
//		System.out.println(prompt);
//		System.out.println("Trykk \"ENTER\" for å fortsette ...");
//		scanner.nextLine();
//	}
	
	public static void main(String[] args) {
		
		VitnemalDAO vitnemalDAO = new VitnemalDAO();
		
		//a) Søke opp vitnemålet til en gitt student.
//		Vitnemal vm = vitnemalDAO.hentVitnemalForStudent(123456);
//		System.out.println(vm);
				
		//b.i) Registrere en ny karakter for en gitt student 
		//		når karakter ikke finnes fra før.
		
		
		//b.ii) Registrere en ny karakter for en gitt student
		//		når karakter finnes fra før.
		
		
		//c) Søke opp karakteren til en gitt student i et gitt kurs.

		
		//TEST
		List<Karakter> hmmm = vitnemalDAO.hentKarakterlisteForFerdige("DAT107");
		hmmm.forEach(System.out::println);
		
	}
}





