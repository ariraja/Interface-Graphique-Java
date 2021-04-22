package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccueilController {

    @FXML
    private Button btnAccueilEntrerBar;

    @FXML
    private Button btnAccueilGestionBar;

    @FXML
    private Button btnAccueilQuitter;

    Stage stage;

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
