package no.hvl.dat107.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f5eks3a")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    
    // Vi velger Prosjekt som owning-side. Vi kunne også valgt Ansatt. Hipp-som-happ.
    @ManyToMany
    @JoinTable(
            name = "f5eks3a.prosjektdeltagelse", // NB! Må ha med schema !!!
            joinColumns = @JoinColumn(name="prosjektid"),
            inverseJoinColumns = @JoinColumn(name="ansattid"))
    private List<Ansatt> ansatte;
    
    public int getId() {
		return id;
	}

    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s", innrykk, id, navn);
    }
    
    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        ansatte.forEach(a -> a.skrivUt("\n   "));
    }

    public void leggTilAnsatt(Ansatt a) {
        ansatte.add(a);
    }

    public void fjernAnsatt(Ansatt a) {
        ansatte.remove(a);
    }
    
}






