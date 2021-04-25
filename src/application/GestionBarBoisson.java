package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GestionBarBoisson implements Initializable {

    @FXML
    private Button btnretour;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprix;

    @FXML
    private TextField tfqte;

    @FXML
    private TextField tfalcool;

    @FXML
    private Button btnsupp;

    @FXML
    private Button ajtboisson;

    @FXML
    private Button btnvalide;

    @FXML
    private Label lberrornom;

    @FXML
    private Label lberrorprix;

    @FXML
    private Label lberrorqte;

    @FXML
    private Label lberroralcool;

    @FXML
    private TableView<Boisson> tableview;

    @FXML
    private TableColumn<Boisson, String> colnom;

    @FXML
    private TableColumn<Boisson, Double> colprix;

    @FXML
    private TableColumn<Boisson, Integer> colqte;

    @FXML
    private TableColumn<Boisson, String> colalcool;

    private Stage stage;
    private Scene scene;
    private Parent root;


    ObservableList<Boisson> list = FXCollections.observableArrayList(new Boisson("Eau",1,3,"Non"));



    @FXML
    void BtnRetour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionBar.fxml"));
        scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AjouterBoisson(ActionEvent event) {
        boolean b1 = emptyTextField(tfnom, lberrornom, "champ vide !");
        boolean b2 = emptyTextField(tfprix, lberrorprix, "champ vide !");
        boolean b3 = emptyTextField(tfqte, lberrorqte, "champ vide !");
        boolean b4 = notNumberTextField (tfprix, lberrorprix, "Not a number");
        boolean b5 = notNumberTextField (tfqte, lberrorqte, "Not a number");
        boolean b6 = emptyTextField(tfalcool, lberroralcool, "champ vide !");
        if (!b1 && !b2 && !b3 && !b4 && !b5 && !b6) {
            Boisson b = new Boisson(tfnom.getText(), Double.parseDouble(tfprix.getText()), Integer.parseInt(tfqte.getText()),tfalcool.getText());
            tableview.getItems().add(b);
            tfnom.setText("");
            tfprix.setText("");
            tfqte.setText("");
            tfalcool.setText("");
            lberrornom.setText("");
            lberrorprix.setText("");
            lberrorqte.setText("");
            lberroralcool.setText("");
        }
    }

    @FXML
    void SupprimerBoisson(ActionEvent event) {
        ObservableList<Boisson> allProduct;
        allProduct=tableview.getItems();
        if(tableview.getSelectionModel().getSelectedItem()==null)
        {
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please select a Product");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else
        {
            Boisson singleProduct=tableview.getSelectionModel().getSelectedItem();
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure to delete? \n"+singleProduct.toString());
            alert.setHeaderText(null);
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get()==ButtonType.OK)
                tableview.getItems().remove(singleProduct);
        }
    }

    @FXML
    void ValiderCommande(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        colqte.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        colalcool.setCellValueFactory(new PropertyValueFactory<>("Alcoolise"));
        tableview.setItems(list);
    }

    /////////////////////////////////////////////////////////////////////////
    public boolean emptyTextField (TextField tf)
    {
        if (tf.getText().isEmpty())
            return true;
        else
            return false;

    }
    public boolean emptyTextField (TextField tf, Label lb, String msgerror)
    {
        if (!emptyTextField(tf))
            return false;
        else
        {
            lb.setText(msgerror);
            return true;
        }
    }


    public boolean notNumberTextField (TextField tf)
    {
        if (tf.getText().matches("\\d*")||tf.getText().matches("\\d+\\.\\d+"))
        {
            return false;
        }
        else
            return true;
    }

    public boolean notNumberTextField (TextField tf, Label lb, String msgerror)
    {
        if (notNumberTextField (tf))
        {
            lb.setText(msgerror);
            return true;
        }
        else return false;
    }
}
