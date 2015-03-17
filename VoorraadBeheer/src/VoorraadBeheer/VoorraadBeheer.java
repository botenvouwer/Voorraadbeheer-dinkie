package VoorraadBeheer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoorraadBeheer extends Application{

    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage applicatie) throws Exception {
        
        //Voorraad overzicht
        ScrollPane container = new ScrollPane();
        
        VBox records = new VBox();
        records.setMinHeight(300);
        records.setMaxHeight(500);
        
        HBox[] record = new HBox[30];
        for(HBox b : record){
            b = new HBox();
            
            Label artikelNummer = new Label("32132");
            artikelNummer.getStyleClass().add("artikelNummer");
            Label artikelNaam = new Label("Test prod");
            artikelNaam.getStyleClass().add("artikelNaam");
            Label artikelAantal = new Label("34");
            artikelAantal.getStyleClass().add("artikelAantal");
            
            Button muteer = new Button("Muteer");
            Button verwijderen = new Button("Verwijderen");
            
            b.getChildren().addAll(artikelNummer, artikelNaam, artikelAantal, muteer, verwijderen);
            b.getStyleClass().add("record");
            
            records.getChildren().add(b);
        }
        
        container.setContent(records);
        
        Button toevoegen = new Button("Artikel toevoegen");
        
        HBox controls = new HBox();
        controls.getChildren().addAll(toevoegen);
        controls.getStyleClass().add("control");
        
        BorderPane pane = new BorderPane();
        pane.setCenter(container);
        pane.setBottom(controls);
        
        Scene scherm = new Scene(pane);
        scherm.getStylesheets().add("VoorraadBeheer/style.css");
        
        applicatie.setScene(scherm);
        applicatie.sizeToScene();
        applicatie.show();
    }
    
}
