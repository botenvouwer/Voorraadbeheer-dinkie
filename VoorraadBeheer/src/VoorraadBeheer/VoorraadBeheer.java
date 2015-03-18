package VoorraadBeheer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoorraadBeheer extends Application{
    
    Stage applicatie;
    private Voorraad voorraad = new Voorraad();
    File save = new File("voorraad.obj");
    VBox records;
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage app) throws Exception {
        
        applicatie = app;
        openen();//Open opgeslagen voorraad
        
        //temp
        System.out.println("size: " + voorraad.size());
        System.out.println(voorraad);
        
        //Voorraad overzicht
        ScrollPane container = new ScrollPane();
        container.setFitToWidth(true);
        container.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        
        records = new VBox();
        records.getStyleClass().add("recordContainer");
        
        setRecords();
        
        container.setContent(records);
        
        Button toevoegen = new Button("Artikel toevoegen");
        toevoegen.setOnAction(e -> toevoegen());
        
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
        applicatie.setMinHeight(300);
        applicatie.setMinWidth(750);
        applicatie.show();
        applicatie.setHeight(500);
        applicatie.setTitle("Voorraad beheer dinkie");
        applicatie.getIcons().add(new Image("VoorraadBeheer/icon.png"));
        applicatie.setOnCloseRequest(e -> opslaan());
    }
    
    public void setRecords(){
        
        records.getChildren().clear();
        BorderPane[] record = new BorderPane[voorraad.size()];
        int index = 0;
        for(BorderPane b : record){
            
            Artikel a = voorraad.get(index);
            
            b = new BorderPane();
            
            Label artikelNummer = new Label("A"+a.getNummer());
            artikelNummer.getStyleClass().add("artikelNummer");
            Label artikelNaam = new Label(a.getNaam());
            artikelNaam.getStyleClass().add("artikelNaam");
            Label artikelAantal = new Label(""+a.getVoorraad());
            artikelAantal.getStyleClass().add("artikelAantal");
            artikelAantal.setPrefWidth(100);
            
            Button muteer = new Button("Muteer");
            muteer.setOnAction(e -> muteren(a));
            
            Button verwijderen = new Button("Verwijderen");
            verwijderen.setOnAction(e -> verwijderen(a));
            
            HBox artikelInfo = new HBox();
            artikelInfo.getChildren().addAll(artikelNummer, artikelNaam);
            artikelInfo.getStyleClass().add("artikelInfo");
            
            artikelInfo.setMinWidth(500);
            
            HBox buttons = new HBox();
            buttons.getChildren().addAll(muteer, verwijderen);
            buttons.getStyleClass().add("defSpacing");
            
            b.setLeft(artikelInfo);
            b.setCenter(artikelAantal);
            b.setRight(buttons);
            b.getStyleClass().add("record");
            
            records.getChildren().add(b);
            index++;
        }
    }
    
    public void toevoegen(){
        ArtikelForm form = new ArtikelForm(applicatie, voorraad);
        form.showAndWait();
        setRecords();
    }
    
    public void verwijderen(Artikel a){
        ConfirmBox confirm = new ConfirmBox(applicatie, "Verwijderen", "Weet u zeker dat u A"+a.getNummer()+ " "+a.getNaam()+ " wild verwijderen?");
        confirm.showAndWait();
        
        if(confirm.getGonogo()){
            voorraad.remove(a);
            setRecords();
        }
    }
    
    public void muteren(Artikel a){
        MuteerForm form = new MuteerForm(applicatie, a);
        form.showAndWait();
        setRecords();
    }
    
    public void opslaan(){
        
        System.out.println("Saving to: "+ save.getAbsoluteFile());
        try{
            FileOutputStream fo = new FileOutputStream(save);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(voorraad);
            fo.close();
        }
        catch(IOException e){
            //todo: nigel -> error schermpje maken
            System.out.println("Fout opslaan: "+e.getMessage());
        }
    }
    
    public void openen(){
        System.out.println("Open: "+ save.getAbsoluteFile());
        if(save.exists()){
            try{
                FileInputStream fi = new FileInputStream(save);
                ObjectInputStream oi = new ObjectInputStream(fi);
                voorraad = (Voorraad)oi.readObject();
            }
            catch(IOException | ClassNotFoundException e){
                //todo: nigel -> error popup schermpje maken
                System.out.println("Fout openen: "+e.getMessage());
            }
        }
    }
    
}
