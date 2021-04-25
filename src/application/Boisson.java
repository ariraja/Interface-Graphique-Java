package application;

        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.beans.property.SimpleIntegerProperty;
        import javafx.beans.property.SimpleStringProperty;

public class Boisson{

    private SimpleStringProperty nom;
    private SimpleDoubleProperty prix;
    private SimpleIntegerProperty qte;
    private SimpleStringProperty alcool;

    public Boisson(String nom, double prix, int qte, String alcool) {
        super();
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleDoubleProperty(prix);
        this.qte = new SimpleIntegerProperty(qte);
        this.alcool = new SimpleStringProperty(alcool);
    }

    public String getNom() { return nom.get(); }
    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public double getPrix() { return prix.get(); }
    public void setPrix(double prix) {
        this.prix = new SimpleDoubleProperty(prix);
    }

    public int getQte() { return qte.get(); }
    public void setQte(int qte) {
        this.qte = new SimpleIntegerProperty(qte);
    }

    public String getAlcool() { return alcool.get(); }
    public void setAlcool(String alcool) {
        this.alcool= new SimpleStringProperty(alcool);
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "nom=" + nom.get() +
                ", prix=" + prix.get() +
                ", qte=" + qte.get() +
                ", alcool=" + alcool.get() +
                '}';
    }
}

