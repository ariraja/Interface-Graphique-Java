package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionBarController {
    @FXML
    private Button btnretour;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void goToGestionBarBoisson(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBarBoisson.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToGestionBarCocktail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBarCocktail.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BtnRetour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
