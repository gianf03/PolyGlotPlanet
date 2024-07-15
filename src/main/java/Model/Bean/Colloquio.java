package Model.Bean;

import java.time.LocalDateTime;

public class Colloquio extends Prodotto {
    private LocalDateTime dataOra;
    private boolean prenotato;
    private Esperto esperto;

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

    public Esperto getEsperto() {
        return esperto;
    }

    public void setEsperto(Esperto esperto) {
        this.esperto = esperto;
    }
}
