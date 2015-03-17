package VoorraadBeheer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Voorraad {

    private ArrayList<Artikel> lijstArtikelen;

    public Voorraad() {
        lijstArtikelen = new ArrayList<>();
        try {
            openen();
        } catch (IOException ex) {
            Logger.getLogger(Voorraad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Voorraad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void slaOp() throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream("Database");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(lijstArtikelen);
        fout.close();
    }
    
    public void openen() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("Database");
        if(f.exists()) {
        FileInputStream fis = new FileInputStream("Database");
        ObjectInputStream ois = new ObjectInputStream(fis);
        lijstArtikelen = (ArrayList<Artikel>) ois.readObject();
        }
    }
}
