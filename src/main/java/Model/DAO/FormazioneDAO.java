package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormazioneDAO {
    public void doSave(Formazione formazione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Formazione (IDCarrello, IDProdotto) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, formazione.getCarrello().getId());
            ps.setInt(2, formazione.getProdotto().getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(Formazione formazione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Formazione WHERE IDCarrello=? AND IDProdotto=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, formazione.getCarrello().getId());
            ps.setInt(2, formazione.getProdotto().getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("REMOVE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemoveByIdCorso(int idCorso) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Formazione WHERE IDProdotto=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCorso);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("REMOVE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Formazione> doRetrieveByIdCarrello(int idCarrello){
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM " +
                    "(((((Carrello car JOIN Formazione f ON car.ID=f.IDCarrello) " +
                    "JOIN Utente u ON car.IDUtente=u.ID) " +
                    "JOIN Prodotto p ON f.IDProdotto=p.ID) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "LEFT JOIN Corso ON p.ID=corso.IDProdotto " +
                    "LEFT JOIN Colloquio ON p.ID=colloquio.IDProdotto " +
                    "LEFT JOIN Incontro ON p.ID=incontro.IDProdotto " +
                    "LEFT JOIN Esperto e ON (e.ID=colloquio.IDEsperto or e.ID=incontro.IDEsperto) " +
                    "WHERE car.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCarrello);

            ResultSet rs = ps.executeQuery();

            List<Formazione> formazioni = new ArrayList<>();

            while(rs.next()) {

                Utente u = new Utente();
                u.setID(rs.getInt("u.id"));
                u.setNome(rs.getString("u.nome"));
                u.setCognome(rs.getString("u.cognome"));
                u.setDataNascita(rs.getDate("u.dataNascita").toLocalDate());
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.passwordHash"));
                u.setGenere(rs.getString("u.genere"));
                u.setAdmin(rs.getBoolean("u.admin"));

                Carrello carrello = new Carrello();
                carrello.setUtente(u);
                carrello.setId(rs.getInt("car.ID"));

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("ca.foto"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("l.codISOLingua"));
                l.setNome(rs.getString("l.nome"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));


                Corso corso = null;
                Incontro incontro = null;
                Colloquio colloquio = null;
                if(cat.getID() == 1){
                    corso = new Corso();

                    corso.setID(rs.getInt("p.ID"));
                    corso.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                    corso.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                    corso.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                    corso.setCategoria(cat);
                    corso.setLingua(l);

                    corso.setDescrizione(rs.getString("corso.descrizione"));
                    corso.setNumeroUnita(rs.getInt("corso.numeroUnita"));
                    corso.setLivello(rs.getString("corso.livello"));
                    corso.setDisponibile(rs.getBoolean("corso.disponibile"));
                } else {
                    Esperto e = new Esperto();

                    e.setID(rs.getInt("e.ID"));
                    e.setNome(rs.getString("e.nome"));
                    e.setCognome(rs.getString("e.cognome"));
                    e.setEmail(rs.getString("e.email"));
                    e.setPassword(rs.getString("e.passwordHash"));
                    e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                    e.setGenere(rs.getString("e.genere"));
                    e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));

                    if (cat.getID() == 2) {
                        incontro = new Incontro();

                        incontro.setID(rs.getInt("p.ID"));
                        incontro.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        incontro.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        incontro.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        incontro.setCategoria(cat);
                        incontro.setLingua(l);

                        incontro.setEsperto(e);
                        incontro.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("incontro.dataOra")));
                        incontro.setPrenotato(rs.getBoolean("incontro.prenotato"));
                        incontro.setCAP(rs.getString("incontro.CAP"));
                        incontro.setVia(rs.getString("incontro.via"));
                        incontro.setCivico(rs.getString("incontro.civico"));
                    } else {
                        colloquio = new Colloquio();

                        colloquio.setID(rs.getInt("p.ID"));
                        colloquio.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        colloquio.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        colloquio.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        colloquio.setCategoria(cat);
                        colloquio.setLingua(l);

                        colloquio.setEsperto(e);
                        colloquio.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("colloquio.dataOra")));
                        colloquio.setPrenotato(rs.getBoolean("colloquio.prenotato"));
                    }
                }

                Formazione f = new Formazione();
                f.setCarrello(carrello);

                if(corso != null)
                    f.setProdotto(corso);
                else if(incontro != null)
                    f.setProdotto(incontro);
                else
                    f.setProdotto(colloquio);


                formazioni.add(f);
            }

            return formazioni;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Formazione doRetrieveByIdProdottoAndIdCarrello(int idProdotto, int idCarrello){
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM " +
                    "(((((Carrello car JOIN Formazione f ON car.ID=f.IDCarrello) " +
                    "JOIN Utente u ON car.IDUtente=u.ID) " +
                    "JOIN Prodotto p ON f.IDProdotto=p.ID) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "LEFT JOIN Corso ON p.ID=corso.IDProdotto " +
                    "LEFT JOIN Colloquio ON p.ID=colloquio.IDProdotto " +
                    "LEFT JOIN Incontro ON p.ID=incontro.IDProdotto " +
                    "LEFT JOIN Esperto e ON (e.ID=colloquio.IDEsperto or e.ID=incontro.IDEsperto) " +
                    "WHERE p.ID=? AND car.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProdotto);
            ps.setInt(2, idCarrello);

            ResultSet rs = ps.executeQuery();

            Formazione f = null;

            while(rs.next()) {

                Utente u = new Utente();
                u.setID(rs.getInt("u.id"));
                u.setNome(rs.getString("u.nome"));
                u.setCognome(rs.getString("u.cognome"));
                u.setDataNascita(rs.getDate("u.dataNascita").toLocalDate());
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.passwordHash"));
                u.setGenere(rs.getString("u.genere"));
                u.setAdmin(rs.getBoolean("u.admin"));

                Carrello carrello = new Carrello();
                carrello.setUtente(u);
                carrello.setId(rs.getInt("car.ID"));

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("foto"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setNome(rs.getString("l.nome"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));


                Corso corso = null;
                Incontro incontro = null;
                Colloquio colloquio = null;
                if(cat.getID() == 1){
                    corso = new Corso();

                    corso.setID(rs.getInt("p.ID"));
                    corso.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                    corso.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                    corso.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                    corso.setCategoria(cat);
                    corso.setLingua(l);

                    corso.setDescrizione(rs.getString("corso.descrizione"));
                    corso.setNumeroUnita(rs.getInt("corso.numeroUnita"));
                    corso.setLivello(rs.getString("corso.livello"));
                    corso.setDisponibile(rs.getBoolean("corso.disponibile"));
                } else {
                    Esperto e = new Esperto();

                    e.setID(rs.getInt("e.ID"));
                    e.setNome(rs.getString("e.nome"));
                    e.setCognome(rs.getString("e.cognome"));
                    e.setEmail(rs.getString("e.email"));
                    e.setPassword(rs.getString("e.passwordHash"));
                    e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                    e.setGenere(rs.getString("e.genere"));
                    e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));

                    if (cat.getID() == 2) {
                        incontro = new Incontro();

                        incontro.setID(rs.getInt("p.ID"));
                        incontro.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        incontro.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        incontro.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        incontro.setCategoria(cat);
                        incontro.setLingua(l);

                        incontro.setEsperto(e);
                        incontro.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("incontro.dataOra")));
                        incontro.setPrenotato(rs.getBoolean("incontro.prenotato"));
                        incontro.setCAP(rs.getString("incontro.CAP"));
                        incontro.setVia(rs.getString("incontro.via"));
                        incontro.setCivico(rs.getString("incontro.civico"));
                    } else {
                        colloquio = new Colloquio();

                        colloquio.setID(rs.getInt("p.ID"));
                        colloquio.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        colloquio.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        colloquio.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        colloquio.setCategoria(cat);
                        colloquio.setLingua(l);

                        colloquio.setEsperto(e);
                        colloquio.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("colloquio.dataOra")));
                        colloquio.setPrenotato(rs.getBoolean("colloquio.prenotato"));
                    }
                }

                f = new Formazione();
                f.setCarrello(carrello);

                if(corso != null)
                    f.setProdotto(corso);
                else if(incontro != null)
                    f.setProdotto(incontro);
                else
                    f.setProdotto(colloquio);
            }

            return f;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
