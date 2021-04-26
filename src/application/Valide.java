package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Valide {

    @FXML
    private Button btnquitter;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void BtnQuitter(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        stage = (Stage) btnquitter.getScene().getWindow();
        System.out.println("Aurevoir !");
        stage.close();
    }

}