package no.hvl.dat107;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f2person")
@NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person as p order by p.id")
public class Person {
	
	@Id	private Integer id;
	private String navn;
	
	public Person() {}
	
	public Person(Integer id, String navn) {
		this.id = id;
		this.navn = navn;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return String.format("Person: id=%d, navn=%s", id, navn);
	}
}
