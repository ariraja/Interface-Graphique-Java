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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LeBarController implements Initializable {

    @FXML
    private TableView<Boisson> tableview1;

    @FXML
    private TableColumn<Boisson,String> colnom1;

    @FXML
    private TableColumn<Boisson, Double> colprix1;

    @FXML
    private TableColumn<Boisson, Integer> colqte;

    @FXML
    private TableView<Boisson> tableview2;

    @FXML
    private TableColumn<Boisson, String> colnom2;

    @FXML
    private TableColumn<Boisson, Double> colprix2;

    @FXML
    private Button ajtBoisson;

    @FXML
    private Button retirerboisson;

    @FXML
    private TextField tfnewcocktail;

    @FXML
    private Button btncommander;

    @FXML
    private Button btnretour;

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<Boisson> list= FXCollections.observableArrayList(new Boisson("Eau",1,50),
            new Boisson("Jus de citron",1,15), new Boisson("Rhum Cubain",1.50,10),
            new Boisson("Eau gazeuse",1.20,20),new Boisson("Sirop de sucre de canne",1.25,15),new Boisson("Rhum Blanc",1.50,8),new Boisson("Sirop de Melon",1.15,18));

    ObservableList<Boisson> list2= FXCollections.observableArrayList();

    @FXML
    void AjouteBoisson(ActionEvent event) {
        ObservableList<Boisson> allProduct;
        allProduct=tableview1.getItems();
        if(tableview1.getSelectionModel().getSelectedItem()==null)
        {
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setContentText("Choisissez un produit à ajouter");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            Boisson singleProduct=tableview1.getSelectionModel().getSelectedItem();
            Boisson p=new Boisson(singleProduct.getNom(),singleProduct.getPrix(),singleProduct.getQuantite());
            tableview2.getItems().add(p);
            tableview2.refresh();
        }
    }

    @FXML
    void BtnRetour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));
        scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BtnCommander(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Valide.fxml"));
        scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RetirerBoisson(ActionEvent event) {
        ObservableList<Boisson> allProduct;
        allProduct=tableview2.getItems();
        if(tableview2.getSelectionModel().getSelectedItem()==null)
        {
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setContentText("Choisissez une boisson à supprimer");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else
        {
            Boisson singleProduct=tableview2.getSelectionModel().getSelectedItem();
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Voulez_vous vraiment supprimer cet article? \n"+singleProduct.toString());
            alert.setHeaderText(null);
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get()==ButtonType.OK)
                tableview2.getItems().remove(singleProduct);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colnom1.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colprix1.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        colqte.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        tableview1.setItems(list);
        tableview1.setEditable(true);
        colnom1.setCellFactory(TextFieldTableCell.forTableColumn());
        colprix1.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colnom2.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colprix2.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        tableview2.setItems(list2);
        tableview2.setEditable(true);
        colnom2.setCellFactory(TextFieldTableCell.forTableColumn());
        colprix2.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }
}
