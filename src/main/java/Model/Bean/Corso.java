package Model.Bean;

public class Corso extends Prodotto {
    private String descrizione;
    private int numeroUnita;
    private String livello;
    private boolean disponibile;

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

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}