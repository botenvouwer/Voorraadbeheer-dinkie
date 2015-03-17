package VoorraadBeheer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VoorraadBeheer extends Application{

    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage applicatie) throws Exception {
        
        Button toevoegen = new Button("Artikel toevoegen");
        
        HBox controls = new HBox();
        controls.getChildren().addAll(toevoegen);
        
        BorderPane pane = new BorderPane();
        pane.setBottom(controls);
        
        Scene scherm = new Scene(pane);
        
        applicatie.setScene(scherm);
        applicatie.sizeToScene();
        applicatie.show();
    }
    
}
