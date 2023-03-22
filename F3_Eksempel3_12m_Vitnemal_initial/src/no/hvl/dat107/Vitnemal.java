package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vitnemal", schema = "forelesning3")
public class Vitnemal {
	
	@Id private int studNr;
	private LocalDate studiestart;
	private LocalDate studieslutt;
	
	@OneToMany(mappedBy = "vitnemal")
	private List<Karakter> karakterer;
	
	@Override
	public String toString() {
		return "Vitnemal [studNr=" + studNr + ", studiestart=" + studiestart + ", studieslutt=" + studieslutt + "]";
	}
}
