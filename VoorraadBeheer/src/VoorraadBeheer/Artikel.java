package VoorraadBeheer;

import java.io.Serializable;

public class Artikel implements Serializable{
    private int nummer;
    private String naam;
    private int voorraad;
    
    public Artikel(int nummer, String naam) {
        this.nummer = nummer;
        this.naam = naam;
        voorraad = 0;
    }
    
    public int getNummer() {
        return nummer;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public void setVoorraad(int geteldAantal) {
        voorraad = geteldAantal;
    }
    
    public int getVoorraad() {
        return voorraad;
    }
    
    public void inboeken(int extraVoorraad) {
        voorraad += extraVoorraad;
    }
    
    public boolean uitboeken(int voorraadVermindering) {
        if((voorraad - voorraadVermindering) >= 0) {
        voorraad -= voorraadVermindering;
        return true;
        } else { 
            return false;
        }
    }
    
    public boolean equalss(Artikel ref) {
        return ref.getNummer() == nummer;
    }
    
    public String toString() {
        return naam + " heeft een voorraad van " + voorraad + " en het artikelnummer is" + nummer;
    }
}
