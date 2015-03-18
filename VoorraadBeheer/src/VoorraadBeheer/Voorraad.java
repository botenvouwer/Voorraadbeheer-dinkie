package VoorraadBeheer;

import java.util.ArrayList;

public class Voorraad extends ArrayList<Artikel> {
    
    public Voorraad() {
    }
 
    public boolean bestaadAl(Artikel check) {
        boolean b = false;
        for (Artikel refArtikel : this) {
            b = check.equalss(refArtikel);
        }
        return b;
    }

    public boolean voegArtikelToe(Artikel newArtikel) {
        if (!bestaadAl(newArtikel)) {
            add(newArtikel);
            return true;
        } else {
            return false;
        }
    }

    public boolean verwijderArtikel(Artikel wegArtikel) {
        if (!bestaadAl(wegArtikel)) {
            remove(wegArtikel);
            return true;
        } else {
            return false;
        }
    }
    
    public Artikel zoekArtikel(int zoekNummer) {
        for(Artikel gezocht : this) {
            if(zoekNummer == gezocht.getNummer()) {
                return gezocht;
            }
        }
    }
}
