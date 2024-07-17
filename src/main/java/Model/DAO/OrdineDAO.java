package Model.DAO;

import Model.Bean.Lingua;
import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {
    public void doSave(Ordine ordine) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Ordine (dataOra, IDUtente) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getDataOra()));
            ps.setInt(2, ordine.getUtente().getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ordine> doRetrieveAllByUtente(int IDUtente) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM Utente u JOIN Ordine o ON u.ID=o.IDUtente WHERE u.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDUtente);

            ResultSet rs = ps.executeQuery();

            List<Ordine> ordini = new ArrayList<>();

            while(rs.next()) {
                Ordine o = new Ordine();

                Utente u = new Utente();
                u.setID(IDUtente);
                u.setNome(rs.getString("u.nome"));
                u.setCognome(rs.getString("u.cognome"));
                u.setDataNascita(rs.getDate("u.dataNascita").toLocalDate());
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.passwordHash"));
                u.setGenere(rs.getString("u.genere"));
                u.setAdmin(rs.getBoolean("u.admin"));

                o.setID(rs.getInt("o.ID"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setNumeroProdotti(rs.getInt("numeroProdotti"));

                Timestamp timestamp = rs.getTimestamp("dataOra");
                o.setDataOra(timestamp.toLocalDateTime());

                o.setUtente(u);

                ordini.add(o);
            }

            return ordini;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ordine> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM Utente u JOIN Ordine o ON u.ID=o.IDUtente order by o.ID";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Ordine> ordini = new ArrayList<>();

            while(rs.next()) {
                Ordine o = new Ordine();

                Utente u = new Utente();
                u.setID(rs.getInt("u.ID"));
                u.setNome(rs.getString("u.nome"));
                u.setCognome(rs.getString("u.cognome"));
                u.setDataNascita(rs.getDate("u.dataNascita").toLocalDate());
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.passwordHash"));
                u.setGenere(rs.getString("u.genere"));
                u.setAdmin(rs.getBoolean("u.admin"));

                o.setID(rs.getInt("o.ID"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setNumeroProdotti(rs.getInt("numeroProdotti"));

                Timestamp timestamp = rs.getTimestamp("dataOra");
                o.setDataOra(timestamp.toLocalDateTime());

                o.setUtente(u);

                ordini.add(o);
            }

            return ordini;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}