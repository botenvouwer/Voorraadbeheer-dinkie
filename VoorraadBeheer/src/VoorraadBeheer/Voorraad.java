package VoorraadBeheer;

import java.util.ArrayList;

public class Voorraad {
    //extenden!
    private ArrayList<Artikel> lijstArtikelen;
    
    public Voorraad() {
        lijstArtikelen = new ArrayList<>();
    }
    
    //todo get(Artikel)
    
    public boolean bestaadAl(Artikel check) {
        boolean b = false;
        for (Artikel refArtikel : lijstArtikelen) {
            b = check.equalss(refArtikel);
        }
        return b;
    }

    public boolean voegArtikelToe(Artikel newArtikel) {
        if (!bestaadAl(newArtikel)) {
            lijstArtikelen.add(newArtikel);
            return true;
        } else {
            return false;
        }
    }

    public boolean verwijderArtikel(Artikel wegArtikel) {
        if (!bestaadAl(wegArtikel)) {
            lijstArtikelen.remove(wegArtikel);
            return true;
        } else {
            return false;
        }
    }
}
