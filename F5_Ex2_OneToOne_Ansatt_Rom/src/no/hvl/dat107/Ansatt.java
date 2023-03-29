package no.hvl.dat107;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f4eks2")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattnr;
    private String fornavn;
    private String etternavn;
    
    @OneToOne
    @JoinColumn(name = "kontor")
    private Rom kontor;

    @Override
    public String toString() {
        String romString = kontor != null ? ", kontor=" + kontor.getRomnr() : "";
        return "Ansatt [ansattnr=" + ansattnr + ", fornavn=" + fornavn 
                + ", etternavn=" + etternavn + romString + "]";
    }

    public int getAnsattnr() {
        return ansattnr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }
}


