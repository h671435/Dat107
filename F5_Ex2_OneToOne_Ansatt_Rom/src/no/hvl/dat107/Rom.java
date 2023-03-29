package no.hvl.dat107;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f4eks2")
public class Rom {
    
    @Id
    private String romnr;
    private double kvm;
    
    @OneToOne(mappedBy = "kontor")
    private Ansatt ansatt;

    @Override
    public String toString() {
        String ansattString = ansatt != null ? ", kontoret til " 
                + ansatt.getFornavn() + " " + ansatt.getEtternavn() : "";
        return "Rom [romnr=" + romnr + ", kvm=" + kvm + ansattString + "]";
    }

    public String getRomnr() {
        return romnr;
    }
}

