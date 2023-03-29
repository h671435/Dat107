package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "forelesning3")
public class Vitnemal {
	
	@Id private int studNr;
	private LocalDate studiestart;
	private LocalDate studieslutt;
	
	@OneToMany(mappedBy = "vitnemal", fetch = FetchType.EAGER)
	List<Karakter> karakterer;

	@Override
	public String toString() {
		
		String karString = "";
		for (Karakter k : karakterer) {
			karString += "\n\t" + k;
		}
		return "Vitnemal for studNr=" + studNr + ", studiestart=" + studiestart 
				+ ", studieslutt=" + studieslutt + ":" + karString;
	}

	public void leggTilKarakter(Karakter k) {
		karakterer.add(k);
	}

	public void fjernKarakter(Karakter k) {
		karakterer.remove(k); //Burde fikse equals() i Karakter!
	}

//	public int getStudNr() {
//		return studNr;
//	}
//
//	public void setStudNr(int studNr) {
//		this.studNr = studNr;
//	}
//
//	public LocalDate getStudiestart() {
//		return studiestart;
//	}
//
//	public void setStudiestart(LocalDate studiestart) {
//		this.studiestart = studiestart;
//	}
//
//	public LocalDate getStudieslutt() {
//		return studieslutt;
//	}
//
//	public void setStudieslutt(LocalDate studieslutt) {
//		this.studieslutt = studieslutt;
//	}
//
//	public List<Karakter> getKarakterer() {
//		return karakterer;
//	}
//
//	public void setKarakterer(List<Karakter> karakterer) {
//		this.karakterer = karakterer;
//	}
//	
	
}
