package Model.Bean;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Ordine {

    private int ID;
    private double prezzoTotale;
    private int numeroProdotti;
    private LocalDateTime dataOra;

    private Utente utente;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrezzoTotale() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(prezzoTotale);
    }

    public void setPrezzoTotale(double prezzoTotale) { this.prezzoTotale = prezzoTotale; }

    public int getNumeroProdotti() {
        return numeroProdotti;
    }

    public void setNumeroProdotti(int numeroProdotti) {
        this.numeroProdotti = numeroProdotti;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
