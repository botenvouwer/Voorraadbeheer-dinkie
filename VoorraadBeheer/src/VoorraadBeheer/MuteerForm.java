package VoorraadBeheer;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MuteerForm extends Stage {

    private Artikel artikel;
    private TextField aantal;
    private Label aantalE;

    public MuteerForm(Stage applicatie, Artikel artikel) {

        super(StageStyle.UTILITY);
        this.artikel = artikel;
        initOwner(applicatie);
        initModality(Modality.WINDOW_MODAL);
        setTitle("Voorraad muteren");

        BorderPane wrapper = new BorderPane();

        // Bovenkant scherm.
        VBox toplane = new VBox();
        Label artikelNummer = new Label("Geselecteerd Artikel: " + artikel.getNummer() + ", " + artikel.getNaam());
        Label voorraadArtikel = new Label("Huidige voorraad: " + artikel.getVoorraad());
        toplane.getChildren().addAll(artikelNummer, voorraadArtikel);
        toplane.getStyleClass().add("toplaneMuteer");
        wrapper.setTop(toplane);

        // Input
        VBox centerPane = new VBox();
        TextField aantal = new TextField();
        Label aantalE = new Label();
        aantalE.getStyleClass().add("error");
        centerPane.getChildren().addAll(aantal, aantalE);
        centerPane.getStyleClass().add("inputMuteer");
        wrapper.setCenter(centerPane);
        this.aantal = aantal;
        this.aantalE = aantalE;

        // Buttons
        HBox buttonWrapper = new HBox();
        Button afboeking = new Button("Uitboeken");
        afboeking.setOnAction(e -> uitboeken());
        Button telling = new Button("Geteld");
        telling.setOnAction(e -> geteld());
        Button inboeking = new Button("Inboeken");
        inboeking.setOnAction(e -> inboeken());
        buttonWrapper.getChildren().addAll(afboeking, telling, inboeking);
        buttonWrapper.getStyleClass().add("buttonsMuteer");
        wrapper.setBottom(buttonWrapper);

        Scene scene = new Scene(wrapper);
        setScene(scene);
        scene.getStylesheets().add("VoorraadBeheer/style.css");

    }

    public boolean geldigGetal() {
        try {
            Integer.parseInt(aantal.getText());
            aantalE.setText("");
            return true;
        } catch (NumberFormatException e) {
            aantalE.setText("Voer een geldig getal in!");
            return false;
        }
    }

    public void geteld() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat de voorraad van " + artikel.getNummer() + ", " + artikel.getNaam() + " " + aantal.getText() + " is?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                artikel.setVoorraad(Integer.parseInt(aantal.getText()));
                hide();
            }
        }

    }

    public void inboeken() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat u de voorraad van " + artikel.getNummer() + ", " + artikel.getNaam() + " met " + aantal.getText() + " wil verhogen?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                artikel.setVoorraad(artikel.getVoorraad() + Integer.parseInt(aantal.getText()));
                hide();
            }
        }
    }
    
    public void uitboeken() {
        if (geldigGetal()) {
            ConfirmBox cf = new ConfirmBox(this, "telling", "Klopt het dat u de voorraad van " + artikel.getNummer() + ", " + artikel.getNaam() + " met " + aantal.getText() + " wil verminderen?");
            cf.showAndWait();
            if (cf.getGonogo()) {
                artikel.setVoorraad(artikel.getVoorraad() - Integer.parseInt(aantal.getText()));
                hide();
            }
        }
    }
    
}
