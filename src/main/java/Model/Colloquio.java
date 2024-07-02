package Model;

import java.time.LocalDateTime;

public class Colloquio extends Prodotto{

    private int IDProdotto;
    private LocalDateTime dataOra;
    private boolean prenotato;
    private Esperto esperto;
    private boolean avvenuto;
    private int votoUtente;

    public int getIDProdotto() {
        return IDProdotto;
    }

    public void setIDProdotto(int IDProdotto) {
        this.IDProdotto = IDProdotto;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    public Esperto getIDEsperto() {
        return esperto;
    }

    public void setIDEsperto(Esperto esperto) {
        this.esperto = esperto;
    }

    public boolean isAvvenuto() {
        return avvenuto;
    }

    public void setAvvenuto(boolean avvenuto) {
        this.avvenuto = avvenuto;
    }

    public int getVotoUtente() {
        return votoUtente;
    }

    public void setVotoUtente(int votoUtente) {
        this.votoUtente = votoUtente;
    }
}
