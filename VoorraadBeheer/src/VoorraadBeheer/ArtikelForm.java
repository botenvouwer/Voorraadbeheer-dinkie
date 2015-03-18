package VoorraadBeheer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ArtikelForm extends Stage{
    
    private Voorraad voorraad;
    private TextField naam, art;
    private Label naamE = new Label(), artE = new Label();

    public ArtikelForm(Stage applicatie, Voorraad voorraad) {
        
        super(StageStyle.UTILITY);
        this.voorraad = voorraad;
        
        artE.getStyleClass().add("error");
        naamE.getStyleClass().add("error");
        initOwner(applicatie);
        initModality(Modality.WINDOW_MODAL);
        setResizable(false);
        setTitle("Artikel toevoegen");
        
        VBox con = new VBox();
        con.getStyleClass().addAll("defPadding", "right", "defSpacing");
        
        HBox artnmcon = new HBox();
        artnmcon.getStyleClass().addAll("right", "defSpacing");
        
        Label artL = new Label("Artikel nummer:");
        art = new TextField();
        
        artnmcon.getChildren().addAll(artL, art);
        
        HBox naamcon = new HBox();
        naamcon.getStyleClass().addAll("right", "defSpacing");
        
        Label naamL = new Label("Artikel naam:");
        naam = new TextField();
        
        naamcon.getChildren().addAll(naamL, naam);
        
        Button btn = new Button("Opslaan");
        btn.setOnAction(e -> opslaan());
        
        con.getChildren().addAll(artnmcon, artE, naamcon, naamE, btn);
        
        Scene scene = new Scene(con);
        scene.getStylesheets().add("VoorraadBeheer/style.css");
        setScene(scene);
        sizeToScene();
        
    }
    
    public void opslaan(){
        
        boolean good = true;
        int artnr = 0;
        
        
        try{
            artnr = Integer.parseInt(art.getText());
        }
        catch(Exception e){
            
        }
        
        if(art.getText().isEmpty()){
            artE.setText("Vul artikel nummer in!");
            good = false;
        }
        else if(artnr == 0){
            artE.setText("Artikel nummer moet nummer zijn!");
            good = false;
        }
        else{
            artE.setText("");
        }
        
        if(naam.getText().isEmpty()){
            naamE.setText("Vul artikel naam in!");
            good = false;
        }
        else{
            naamE.setText("");
        }
        
        if(good){
            
            Artikel a = new Artikel(artnr, naam.getText());
            boolean test = voorraad.voegArtikelToe(a);
            
            if(test){
                hide();
            }
            else{
                naamE.setText("Artikel bestaad al");
            }
            
        }
        
    }
    
}
