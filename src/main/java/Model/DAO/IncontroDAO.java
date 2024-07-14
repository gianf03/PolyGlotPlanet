package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IncontroDAO {

    public List<Incontro> doRetrieveByCodISOLingua(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Incontro i ON p.ID=i.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON i.IDEsperto=e.ID WHERE l.codISOLingua=?");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Incontro> incontri = new ArrayList<>();

            while(rs.next()) {
                Incontro i = new Incontro();

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
                e.setValutazione(rs.getDouble("e.valutazione"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                i.setID(rs.getInt("IDProdotto"));
                i.setPrezzoBase(rs.getDouble("prezzoBase"));
                i.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                i.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                i.setCategoria(cat);
                i.setLingua(l);
                i.setEsperto(e);
                i.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                i.setPrenotato(rs.getBoolean("prenotato"));
                i.setAvvenuto(rs.getBoolean("avvenuto"));
                i.setVotoUtente(rs.getInt("votoUtente"));
                i.setCAP(rs.getString("CAP"));
                i.setVia(rs.getString("via"));
                i.setCivico(rs.getString("civico"));

                incontri.add(i);
            }

            return incontri;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Incontro> doRetrieveByEsperto(int IDEsperto) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Incontro i ON p.ID=i.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON i.IDEsperto=e.ID WHERE e.ID=?");
            ps.setInt(1, IDEsperto);


            ResultSet rs = ps.executeQuery();

            List<Incontro> incontri = new ArrayList<>();

            while(rs.next()) {
                Incontro i = new Incontro();

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
                e.setValutazione(rs.getDouble("e.valutazione"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                i.setID(rs.getInt("IDProdotto"));
                i.setPrezzoBase(rs.getDouble("prezzoBase"));
                i.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                i.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                i.setCategoria(cat);
                i.setLingua(l);
                i.setEsperto(e);
                i.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                i.setPrenotato(rs.getBoolean("prenotato"));
                i.setAvvenuto(rs.getBoolean("avvenuto"));
                i.setVotoUtente(rs.getInt("votoUtente"));
                i.setCAP(rs.getString("CAP"));
                i.setVia(rs.getString("via"));
                i.setCivico(rs.getString("civico"));

                incontri.add(i);
            }

            return incontri;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Incontro> doRetrieveByCodISOLinguaNonPrenotati(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Incontro i ON p.ID=i.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON i.IDEsperto=e.ID WHERE l.codISOLingua=? AND i.prenotato=false");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Incontro> incontri = new ArrayList<>();

            while(rs.next()) {
                Incontro i = new Incontro();

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
                e.setValutazione(rs.getDouble("e.valutazione"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                i.setID(rs.getInt("IDProdotto"));
                i.setPrezzoBase(rs.getDouble("prezzoBase"));
                i.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                i.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                i.setCategoria(cat);
                i.setLingua(l);
                i.setEsperto(e);
                i.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                i.setPrenotato(rs.getBoolean("prenotato"));
                i.setAvvenuto(rs.getBoolean("avvenuto"));
                i.setVotoUtente(rs.getInt("votoUtente"));
                i.setCAP(rs.getString("CAP"));
                i.setVia(rs.getString("via"));
                i.setCivico(rs.getString("civico"));

                incontri.add(i);
            }

            return incontri;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Incontro> doRetrieveByCodISOLinguaPrezzoMinMaxAndDataOra (String codISOLingua, int prezzoMin, int prezzoMax, LocalDateTime dataOra) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM (((Prodotto p JOIN Incontro i ON p.ID=i.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "JOIN Esperto e ON i.IDEsperto=e.ID WHERE l.codISOLingua=? AND p.prezzoAttuale>=? " +
                    "AND p.prezzoAttuale<? AND c.dataOra>=? AND c.prenotato = false");
            ps.setString(1, codISOLingua);
            ps.setInt(2, prezzoMin);
            ps.setInt(3, prezzoMax);
            ps.setTimestamp(4, Timestamp.valueOf(dataOra));


            ResultSet rs = ps.executeQuery();

            List<Incontro> incontri = new ArrayList<>();

            while (rs.next()) {
                Incontro i = new Incontro();

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
                e.setValutazione(rs.getDouble("e.valutazione"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));


                i.setID(rs.getInt("IDProdotto"));
                i.setPrezzoBase(rs.getDouble("prezzoBase"));
                i.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                i.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                i.setCategoria(cat);
                i.setLingua(l);
                i.setEsperto(e);
                i.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                i.setPrenotato(rs.getBoolean("prenotato"));
                i.setAvvenuto(rs.getBoolean("avvenuto"));
                i.setVotoUtente(rs.getInt("votoUtente"));
                i.setCAP(rs.getString("CAP"));
                i.setVia(rs.getString("via"));
                i.setCivico(rs.getString("civico"));

                incontri.add(i);
            }

            return incontri;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
