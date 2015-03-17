package VoorraadBeheer;

public class Artikel {
    private final int artNummer;
    private final String naam;
    private int aantalAanwezig;
    
    public Artikel(int artNummer, String naam) {
        this.artNummer = artNummer;
        this.naam = naam;
        aantalAanwezig = 0;
    }
    
    public int getArtNummer() {
        return artNummer;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public void setAantalAaanwezig(int geteldAantal) {
        aantalAanwezig = geteldAantal;
    }
    
    public int getAantalAanwezig() {
        return aantalAanwezig;
    }
    
    
}
