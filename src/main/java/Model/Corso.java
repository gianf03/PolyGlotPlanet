package Model;

public class Corso{

    private Prodotto prodotto;
    private String descrizione;
    private int numeroUnita;
    private String livello;
    private Lingua lingua;


    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumeroUnita() {
        return numeroUnita;
    }

    public void setNumeroUnita(int numeroUnita) {
        this.numeroUnita = numeroUnita;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public Lingua getLingua() {
        return lingua;
    }

    public void setLingua(Lingua lingua) {
        this.lingua = lingua;
    }
}