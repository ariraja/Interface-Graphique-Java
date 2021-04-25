package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionBarCocktail {

    @FXML
    private Button ajtBoisson;

    @FXML
    private Button retirerboisson;

    @FXML
    private TextField tfnewcocktail;

    @FXML
    private Button composercocktail;

    @FXML
    private Button btnretour;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void AjouteBoisson(ActionEvent event) {

    }

    @FXML
    void BtnRetour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBar.fxml"));
        scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ComposerCocktail(ActionEvent event) {

    }

    @FXML
    void RetirerBoisson(ActionEvent event) {

    }

}
