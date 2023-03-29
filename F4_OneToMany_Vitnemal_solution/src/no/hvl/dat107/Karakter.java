package no.hvl.dat107;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "forelesning3")
public class Karakter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int karNr;
	private String emnekode;
	private LocalDate eksDato;
	private String bokstav;
	
	@ManyToOne
	@JoinColumn(name = "StudNr", referencedColumnName = "StudNr")
	private Vitnemal vitnemal;
	
	public Karakter() {}
	
	public Karakter(String emnekode, LocalDate eksDato, String bokstav) {
		this.emnekode = emnekode;
		this.eksDato = eksDato;
		this.bokstav = bokstav;
	}

	public void setVitnemal(Vitnemal vitnemal) {
		this.vitnemal = vitnemal;
	}

	@Override
	public String toString() {
		return "Karakter [" + emnekode + ", " + eksDato + ", Resultat: " + bokstav + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(karNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Karakter other = (Karakter) obj;
		return karNr == other.karNr;
	}
	
	
	
}
