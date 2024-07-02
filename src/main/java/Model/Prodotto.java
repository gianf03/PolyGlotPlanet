package Model;

public class Prodotto {

    private int ID;
    private double prezzoBase;
    private double scontoPercentuale;
    private Categoria categoria;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(double prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public double getScontoPercentuale() {
        return scontoPercentuale;
    }

    public void setScontoPercentuale(double scontoPercentuale) {
        this.scontoPercentuale = scontoPercentuale;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
