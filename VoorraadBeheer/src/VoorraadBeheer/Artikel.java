package VoorraadBeheer;

public class Artikel {
    private final int nummer;
    private final String naam;
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
}
