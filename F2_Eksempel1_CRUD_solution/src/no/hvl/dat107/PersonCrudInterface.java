package no.hvl.dat107;

import java.util.List;

public interface PersonCrudInterface {
	
	/** Create - Opprette ny person-rad i databasen */
	void lagrePerson(Person p);	
	
	/** Read1 - Hente ut data fra databasen. En enkelt. */
	Person hentPerson(int id);
	
	/** Read2 - Hente ut data fra databasen. Alle. */
	List<Person> hentAllePersoner();
	
	/** Read3 - Hente ut data fra databasen. Named Query. */
	List<Person> hentAllePersonerNQ();
	
	/** Update - Oppdatere en person-rad i databasen */
	void oppdaterPerson(int id, String nyttNavn);
	
	/** Delete - Slette en person-rad fra databasen */
	void slettPerson(int id);
}
