package Model.DAO;

import Model.Bean.Categoria;
import Model.Bean.Colloquio;
import Model.ConPool;
import Model.Bean.Esperto;
import Model.Bean.Lingua;
import Utils.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColloquioDAO {

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

                e.setID(rs.getInt("ID"));
                e.setNome(rs.getString("nome"));
                e.setCognome(rs.getString("cognome"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("passwordHash"));
                e.setDataNascita(rs.getDate("dataNascita").toLocalDate());
                e.setGenere(rs.getString("genere"));
                e.setValutazione(rs.getDouble("valutazione"));
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
                c.setAvvenuto(rs.getBoolean("avvenuto"));
                c.setVotoUtente(rs.getInt("votoUtente"));

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
                e.setValutazione(rs.getDouble("valutazione"));
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
                c.setAvvenuto(rs.getBoolean("avvenuto"));
                c.setVotoUtente(rs.getInt("votoUtente"));

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
