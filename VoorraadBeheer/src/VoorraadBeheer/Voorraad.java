package VoorraadBeheer;

import java.util.ArrayList;

public class Voorraad {
    private ArrayList<Artikel> lijstArtikelen;
    
    public Voorraad() {
        lijstArtikelen = new ArrayList<>();
    }
    
    public boolean bestaadAl(Artikel check) {
        boolean b = false;
        for(Artikel refArtikel: lijstArtikelen) {
            b = check.equalss(refArtikel);
            }
        return b;
    }
    
    public boolean voegArtikelToe(Artikel newArtikel) {
        if(!bestaadAl(newArtikel)) {
            lijstArtikelen.add(newArtikel);
            return true;
        } else {
            return false;
        }
    }
    
}
