package Model.Bean;

import java.time.LocalDateTime;

public class Incontro extends Prodotto {
    private LocalDateTime dataOra;
    private String CAP;
    private String via;
    private String civico;
    private boolean prenotato;
    private Esperto esperto;

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    public Esperto getEsperto() {
        return esperto;
    }

    public void setEsperto(Esperto esperto) {
        this.esperto = esperto;
    }
}
