package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComposizioneDAO {

    public void doSave(Composizione composizione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Composizione (IDOrdine, IDProdotto, prezzoAcquisto) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, composizione.getOrdine().getID());
            ps.setInt(2, composizione.getProdotto().getID());
            ps.setDouble(3, composizione.getPrezzoAcquistoDouble());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Composizione> doRetrieveAllByOrdine(int IDOrdine) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM " +
                    "(((((Utente u JOIN Ordine o ON o.IDUtente=u.ID) " +
                    "JOIN Composizione c ON c.IDOrdine=o.ID) " +
                    "JOIN Prodotto p ON c.IDProdotto=p.ID) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "LEFT JOIN Corso ON p.ID=corso.IDProdotto " +
                    "LEFT JOIN Colloquio ON p.ID=colloquio.IDProdotto " +
                    "LEFT JOIN Incontro ON p.ID=incontro.IDProdotto " +
                    "LEFT JOIN Esperto e ON (e.ID=colloquio.IDEsperto or e.ID=incontro.IDEsperto) " +
                    "WHERE o.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDOrdine);

            ResultSet rs = ps.executeQuery();

            List<Composizione> composizioni = new ArrayList<>();

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

                Ordine o = new Ordine();
                o.setID(rs.getInt("IDOrdine"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setNumeroProdotti(rs.getInt("numeroProdotti"));

                Timestamp timestamp = rs.getTimestamp("dataOra");
                o.setDataOra(timestamp.toLocalDateTime());

                o.setUtente(u);

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

                Composizione c = new Composizione();
                c.setOrdine(o);
                c.setPrezzoAcquisto(rs.getDouble("prezzoAcquisto"));

                if(corso != null)
                    c.setProdotto(corso);
                else if(incontro != null)
                    c.setProdotto(incontro);
                else
                    c.setProdotto(colloquio);


                composizioni.add(c);
            }

            return composizioni;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Composizione doRetrieveByIdProdottoAndIdUtente(int idProdotto, int idUtente) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM " +
                    "(((((Utente u JOIN Ordine o ON o.IDUtente=u.ID) " +
                    "JOIN Composizione c ON c.IDOrdine=o.ID) " +
                    "JOIN Prodotto p ON c.IDProdotto=p.ID) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "LEFT JOIN Corso ON p.ID=corso.IDProdotto " +
                    "LEFT JOIN Colloquio ON p.ID=colloquio.IDProdotto " +
                    "LEFT JOIN Incontro ON p.ID=incontro.IDProdotto " +
                    "LEFT JOIN Esperto e ON (e.ID=colloquio.IDEsperto or e.ID=incontro.IDEsperto) " +
                    "WHERE p.ID=? AND u.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProdotto);
            ps.setInt(2, idUtente);

            ResultSet rs = ps.executeQuery();

            Composizione c = null;

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

                Ordine o = new Ordine();
                o.setID(rs.getInt("IDOrdine"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setNumeroProdotti(rs.getInt("numeroProdotti"));

                Timestamp timestamp = rs.getTimestamp("dataOra");
                o.setDataOra(timestamp.toLocalDateTime());

                o.setUtente(u);

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

                c = new Composizione();
                c.setOrdine(o);
                c.setPrezzoAcquisto(rs.getDouble("prezzoAcquisto"));

                if(corso != null)
                    c.setProdotto(corso);
                else if(incontro != null)
                    c.setProdotto(incontro);
                else
                    c.setProdotto(colloquio);
            }

            return c;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
