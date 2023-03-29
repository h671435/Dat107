package no.hvl.dat107;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f5eks1")
public class Todoliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String navn;
	
	@OneToMany(mappedBy = "liste")
	List<Todo> todos = new ArrayList<>();
	
	public Todoliste() {}
	
	public Todoliste(String navn) {
		this.navn = navn;
	}
	
	public void leggTil(Todo todo) {
		todos.add(todo);
	}
	
	public int getId() {
		return id;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "Todoliste [id=" + id + ", navn=" + navn + ", todos=" + todos + "]";
	}
}


