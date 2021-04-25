package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cocktail {

    private SimpleStringProperty nom;
    private SimpleDoubleProperty prix;
    private SimpleIntegerProperty quantite;

    public Cocktail(String nom, double prix, int quantite) {
        super();
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleDoubleProperty(prix);
        this.quantite = new SimpleIntegerProperty(quantite);
    }


    public String getNom() {
        return nom.get();
    }
    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom) ;
    }
    public double getPrix() {
        return prix.get();
    }
    public void setPrix(double prix) {
        this.prix = new SimpleDoubleProperty(prix);
    }
    public int getQuantite() {
        return quantite.get();
    }
    public void setQuantite(int quantite) {
        this.quantite = new SimpleIntegerProperty(quantite);
    }


    @Override
    public String toString() {
        return "Cocktail [nom=" + nom.get() + ", prix=" + prix.get() + ", quantite=" + quantite.get() + "]";
    }

}