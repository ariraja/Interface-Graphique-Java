package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    double xOffset, yOffset;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = new Scene(root, 1000, 600);

        stage.setTitle("Bar à cocktails");

        stage.setOnCloseRequest(event ->{
            event.consume();
            quitterAppli(stage);
        });
        // CSS
       // String css = this.getClass().getResource("css/style.css").toExternalForm();
        //scene.getStylesheets().add(css);

        // Icon
        //String icon = this.getClass().getResource("icon.png").toExternalForm();
        //System.out.println(icon);
        //stage.getIcons().add(new Image(icon));

        stage.setScene(scene);
        stage.show();
    }

    private void quitterAppli(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Etes vous sûre de vouloir quitter ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Aurevoir !");
            stage.close();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
