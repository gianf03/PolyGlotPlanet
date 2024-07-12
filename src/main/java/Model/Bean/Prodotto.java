package Model.Bean;

import Model.Bean.Categoria;
import Model.Bean.Lingua;

import java.text.DecimalFormat;

public class Prodotto {

    private int ID;
    private double prezzoBase;
    private double scontoPercentuale;
    private Categoria categoria;
    private double prezzoAttuale;
    private Lingua lingua;
    private boolean disponibile;

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

    public void setPrezzoAttuale(double prezzoAttuale){ this.prezzoAttuale = prezzoAttuale; }
    public String getPrezzoAttuale(){   //la funzione deve restituire per forza una stringa perché se prezzo 10.5 non viene convertito in 10.50 ne con Math.round ne con DecimalFormat
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(prezzoAttuale);
    }

    public Lingua getLingua() {
        return lingua;
    }

    public void setLingua(Lingua lingua) {
        this.lingua = lingua;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}