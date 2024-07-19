package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ColloquioDAO {

    public void doSave(Colloquio colloquio) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Colloquio (IDProdotto, dataOra, IDEsperto) VALUES(?,?,?)");

            ps.setInt(1, colloquio.getID());
            ps.setTimestamp(2, Timestamp.valueOf(colloquio.getDataOra()));
            ps.setInt(3, colloquio.getEsperto().getID());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Colloquio> doRetrieveByCodISOLingua(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Colloquio c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON c.IDEsperto=e.ID WHERE l.codISOLingua=?");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Colloquio> colloqui = new ArrayList<>();

            while(rs.next()) {
                Colloquio c = new Colloquio();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Esperto e = new Esperto();

                e.setID(rs.getInt("e.ID"));
                e.setNome(rs.getString("e.nome"));
                e.setCognome(rs.getString("e.cognome"));
                e.setEmail(rs.getString("e.email"));
                e.setPassword(rs.getString("e.passwordHash"));
                e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                e.setGenere(rs.getString("e.genere"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setLingua(l);
                c.setEsperto(e);
                c.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                c.setPrenotato(rs.getBoolean("prenotato"));

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Colloquio> doRetrieveByEsperto(int IDEsperto) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Colloquio c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON c.IDEsperto=e.ID WHERE e.ID=?");
            ps.setInt(1, IDEsperto);


            ResultSet rs = ps.executeQuery();

            List<Colloquio> colloqui = new ArrayList<>();

            while(rs.next()) {
                Colloquio c = new Colloquio();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Esperto e = new Esperto();

                e.setID(rs.getInt("ID"));
                e.setNome(rs.getString("nome"));
                e.setCognome(rs.getString("cognome"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("passwordHash"));
                e.setDataNascita(rs.getDate("dataNascita").toLocalDate());
                e.setGenere(rs.getString("genere"));
                e.setFotoRiconoscitiva(rs.getString("fotoRiconoscitiva"));


                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setLingua(l);
                c.setEsperto(e);
                c.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                c.setPrenotato(rs.getBoolean("prenotato"));

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Colloquio> doRetrieveByCodISOLinguaPrezzoMinMaxAndDataOra (String codISOLingua, int prezzoMin, int prezzoMax, LocalDateTime dataOra){
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Colloquio c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON c.IDEsperto=e.ID WHERE l.codISOLingua=? AND p.prezzoAttuale>=? " +
                    "AND p.prezzoAttuale<? AND c.dataOra>=? AND c.prenotato = false");
            ps.setString(1, codISOLingua);
            ps.setInt(2, prezzoMin);
            ps.setInt(3, prezzoMax);
            ps.setTimestamp(4, Timestamp.valueOf(dataOra));

            ResultSet rs = ps.executeQuery();

            List<Colloquio> colloqui = new ArrayList<>();

            while(rs.next()) {
                Colloquio c = new Colloquio();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Esperto e = new Esperto();

                e.setID(rs.getInt("e.ID"));
                e.setNome(rs.getString("e.nome"));
                e.setCognome(rs.getString("e.cognome"));
                e.setEmail(rs.getString("e.email"));
                e.setPassword(rs.getString("e.passwordHash"));
                e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                e.setGenere(rs.getString("e.genere"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setLingua(l);
                c.setEsperto(e);
                c.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                c.setPrenotato(rs.getBoolean("prenotato"));

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Colloquio> doRetrieveByCodISOLinguaNonPrenotati(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Colloquio c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON c.IDEsperto=e.ID WHERE l.codISOLingua=? AND prenotato=false");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Colloquio> colloqui = new ArrayList<>();

            while(rs.next()) {
                Colloquio c = new Colloquio();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Esperto e = new Esperto();

                e.setID(rs.getInt("e.ID"));
                e.setNome(rs.getString("e.nome"));
                e.setCognome(rs.getString("e.cognome"));
                e.setEmail(rs.getString("e.email"));
                e.setPassword(rs.getString("e.passwordHash"));
                e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                e.setGenere(rs.getString("e.genere"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setLingua(l);
                c.setEsperto(e);
                c.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                c.setPrenotato(rs.getBoolean("prenotato"));

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
