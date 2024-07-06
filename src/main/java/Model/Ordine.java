package Model;

public class Ordine {

    private int ID;
    private double prezzoTotale;
    private Utente utente;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrezzoTotale() { return prezzoTotale; }

    public void setPrezzoTotale(double prezzoTotale) { this.prezzoTotale = prezzoTotale; }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
