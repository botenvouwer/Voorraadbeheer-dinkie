package VoorraadBeheer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MuteerForm extends Stage{
    
    private Artikel artikel;
    
    public MuteerForm(Stage applicatie, Artikel artikel) {
        
        //todo: nigel -> maak muteer formulier en muteer functie
        
        super(StageStyle.UTILITY);
        this.artikel = artikel;
        
        initOwner(applicatie);
        initModality(Modality.WINDOW_MODAL);
        //setResizable(false);
        setTitle("Voorraad muteren");
        
        Scene scene = new Scene(new Label("test"));
        setScene(scene);
        
    }
    
}
