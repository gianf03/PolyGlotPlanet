package Model.Bean;

public class Lingua {

    private String codISOLingua;
    private String nome;
    private int parlanti;
    private String fotoStatoOrigine;

    public String getCodISOLingua() {
        return codISOLingua;
    }

    public void setCodISOLingua(String codISOLingua) {
        this.codISOLingua = codISOLingua;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getParlanti() {
        return parlanti;
    }

    public void setParlanti(int parlanti) {
        this.parlanti = parlanti;
    }

    public String getFotoStatoOrigine() {
        return fotoStatoOrigine;
    }

    public void setFotoStatoOrigine(String fotoStatoOrigine) {
        this.fotoStatoOrigine = fotoStatoOrigine;
    }
}
