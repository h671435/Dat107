package no.hvl.dat107.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(schema = "f5eks3b")
@IdClass(ProsjektdeltagelsePK.class)
public class Prosjektdeltagelse {

    private int timer = 0;
    
    @Id
    @ManyToOne
    @JoinColumn(name="ansattid")
    private Ansatt ansatt;
    
    @Id
    @ManyToOne
    @JoinColumn(name="prosjektid")
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk, 
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer);
    }

    @Override
    public String toString() {
        return "IKKE I BRUK";
//        return "PD(" + ansatt.getId() + ", " + prosjekt.getId() + "): " + timer + " timer";
    }
    
    
}






