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

public class MenuClientController {

    @FXML
    private Button btnMenuCommander;

    @FXML
    private Button btnMenuCreerCocktail;

    @FXML
    private Button btnMenuQuitter;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void goToLeBar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LeBar.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToGestionBarCocktail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBarCocktail.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void QuitterLeBar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
