package no.hvl.dat107;

import java.util.List;

public class _Main_CrudExample {
	
	private static PersonCrudInterface crudHelper = new PersonCrudHjelper();
	
	public static void main(String[] args) {

		/* Eksempeldatabasen vår ser slik ut:
		 *  
		 * id		navn
		 * ----------------------
		 * 1001	'Per Viskeler'
		 * 1002	'Atle Patle'
		 * 1003	'Donald Duck'
		 */
		skrivUt("Utgangspunkt");
		
		crudHelper.lagrePerson(new Person(1004, "Mikke"));
		skrivUt("Har lagt til Mikke");
		
		crudHelper.oppdaterPerson(1004, "Mikke Mus");
		skrivUt("Har endret navn til Mikke Mus");
		
		crudHelper.slettPerson(1001);
		skrivUt("Har slettet person med id 1001");
		
		crudHelper.lagrePerson(new Person(1001, "Per Viskeler"));
		crudHelper.slettPerson(1004);
		skrivUt("Har tilbakestilt db");
	}

	private static void skrivUt(String tekst) {
		List<Person> personer = crudHelper.hentAllePersoner();
		System.out.println("\n--- "+ tekst +" ---");
		personer.forEach(System.out::println);		
	}

}
