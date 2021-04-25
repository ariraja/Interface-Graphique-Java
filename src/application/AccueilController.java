package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    @FXML
    private Button btnAccueilEntrerBar;

    @FXML
    private Button btnAccueilGestionBar;

    @FXML
    private Button btnAccueilQuitter;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void goToGestionBar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBar.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToMenuClient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void quitterAppli(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Etes vous sûre de vouloir quitter ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) btnAccueilQuitter.getScene().getWindow();
            System.out.println("Aurevoir !");
            stage.close();
        }

    }

}
