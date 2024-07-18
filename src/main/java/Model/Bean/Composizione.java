package Model.Bean;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Composizione {

    private Ordine ordine;
    private Prodotto prodotto;
    private double prezzoAcquisto;

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public String getPrezzoAcquisto() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(prezzoAcquisto);
    }

    public double getPrezzoAcquistoDouble(){
        return this.prezzoAcquisto;
    }

    public void setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }
}
