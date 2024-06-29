package Model;

public class Corso extends Prodotto{

    private int IDProdotto;
    private String descrizione;
    private int numeroUnita;
    private String livello;
    private String codISOLingua;

    public int getIDProdotto() {
        return IDProdotto;
    }

    public void setIDProdotto(int IDProdotto) {
        this.IDProdotto = IDProdotto;
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

    public String getCodISOLingua() {
        return codISOLingua;
    }

    public void setCodISOLingua(String codISOLingua) {
        this.codISOLingua = codISOLingua;
    }
    public double getPrezzoScontato(){
        return Math.round((getPrezzoBase()-(getPrezzoBase()/100 * getScontoPercentuale())) * 100.0) / 100.0;
    }
}
