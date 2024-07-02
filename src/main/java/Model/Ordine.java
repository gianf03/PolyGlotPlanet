package Model;

import java.util.List;

public class Ordine {

    private int ID;
    private double prezzoTotale;
    private int IDUtente;
    private List<Prodotto> prodotti;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public int getIDUtente() {
        return IDUtente;
    }

    public void setIDUtente(int IDUtente) {
        this.IDUtente = IDUtente;
    }
}
