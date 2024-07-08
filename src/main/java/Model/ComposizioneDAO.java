package Model;

import Utils.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ComposizioneDAO {

    public List<Composizione> doRetrieveAllByUtente(int IDUtente) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM (((Utente u JOIN Ordine o ON o.IDUtente=u.ID) JOIN Composizione c ON c.IDOrdine=o.ID) JOIN " +
                    "Prodotto p ON c.IDProdotto=p.ID) JOIN Categoria ca ON p.IDCategoria=ca.ID WHERE u.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDUtente);

            ResultSet rs = ps.executeQuery();

            List<Composizione> composizioni = new ArrayList<>();

            while(rs.next()) {

                Utente u = new Utente();
                u.setID(IDUtente);
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setDataNascita(rs.getDate("dataNascita").toLocalDate());
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("passwordHash"));
                u.setGenere(rs.getString("genere"));
                u.setAdmin(rs.getBoolean("admin"));

                Ordine o = new Ordine();
                o.setID(rs.getInt("IDOrdine"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setUtente(u);

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("foto"));

                Prodotto p = new Prodotto();
                p.setID(rs.getInt("IDProdotto"));
                p.setCategoria(cat);
                p.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                p.setPrezzoBase(rs.getDouble("prezzoBase"));
                p.setScontoPercentuale(rs.getDouble("scontoPercentuale"));

                Composizione c = new Composizione();
                c.setOrdine(o);
                c.setProdotto(p);
                c.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("dataOra")));
                c.setPrezzoAcquisto(rs.getDouble("prezzoAcquisto"));

                composizioni.add(c);
            }

            return composizioni;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
