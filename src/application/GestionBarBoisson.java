package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.html.Option;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class GestionBarBoisson implements Initializable {

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprix;

    @FXML
    private TextField tfquantite;
    @FXML
    private TableView<Boisson> tableview;

    @FXML
    private TableColumn<Boisson, String> colnom;

    @FXML
    private TableColumn<Boisson, Double> colprix;

    @FXML
    private TableColumn<Boisson, Integer> colquantite;

    @FXML
    private Button btajouter;

    @FXML
    private Button btsupprimer;

    @FXML
    private Button btquitter;

    @FXML
    private Label lberrornom;

    @FXML
    private Label lberrorprix;

    @FXML
    private Label lberrorquantite;

    ObservableList<Boisson> list= FXCollections.observableArrayList(new Boisson("Eau",1,20));

    @FXML
    void ajout(ActionEvent event) {

        boolean b1= emptyTextField (tfnom, lberrornom, " attention champ vide");
        boolean b2= emptyTextField (tfprix, lberrorprix, " attention champ vide");
        boolean b3= emptyTextField (tfquantite, lberrorquantite, " attention champ vide");
        boolean b4= notNumberTextField (tfprix, lberrorprix, " Not a number !");
        boolean b5= notNumberTextField  (tfquantite, lberrorquantite, " Not a number !");
        if(!b1&&!b2&&!b3&&!b4&&!b5)
        {
            Boisson p= new Boisson (tfnom.getText(), Double.parseDouble(tfprix.getText()), Integer.parseInt(tfquantite.getText()));
            tableview.getItems().add(p);
            tfnom.setText("");
            tfprix.setText("");
            tfquantite.setText("");
            lberrorquantite.setText("");
            lberrorprix.setText("");
            lberrornom.setText("");

        }

    }

    @FXML
    void quitter(ActionEvent event) {
        Stage stage= (Stage)btquitter.getScene().getWindow();
        stage.close();

    }

    @FXML
    void supression(ActionEvent event) {
        ObservableList<Boisson> allProduct;
        allProduct=tableview.getItems();
        if(tableview.getSelectionModel().getSelectedItem()==null)
        {
            Alert a= new Alert(AlertType.WARNING);
            a.setContentText("Please select a Product");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else
        {
            Boisson singleProduct=tableview.getSelectionModel().getSelectedItem();
            Alert alert= new Alert(AlertType.CONFIRMATION);
            alert.setContentText("Are you sure to delete? \n"+singleProduct.toString());
            alert.setHeaderText(null);
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get()==ButtonType.OK)
                tableview.getItems().remove(singleProduct);
        }

    }
    @FXML
    void onEditChanged(TableColumn.CellEditEvent<Boisson, String> productStringCellEditEvent) {
        Boisson product=tableview.getSelectionModel().getSelectedItem();
        String s=product.getNom();
        if(!productStringCellEditEvent.getNewValue().isEmpty())
        {
            product.setNom(productStringCellEditEvent.getNewValue());
        }
        else
        {
            product.setNom(productStringCellEditEvent.getOldValue());
        }
        tableview.refresh();
    }
    @FXML
    void onEditChangedprice(TableColumn.CellEditEvent<Boisson, String> productDoubleCellEditEvent) {
        Boisson product=tableview.getSelectionModel().getSelectedItem();
        try
        {
            Double b= Double.parseDouble(productDoubleCellEditEvent.getNewValue());
            product.setPrix(b);
        }
        catch(NumberFormatException e)
        {
            product.setPrix(Double.parseDouble(productDoubleCellEditEvent.getOldValue()));
        }
        finally {
            tableview.refresh();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        tableview.setItems(list);
        tableview.setEditable(true);
        colnom.setCellFactory(TextFieldTableCell.forTableColumn());
        colprix.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    /////////////////////////////

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

        else
            return false;

    }

}

