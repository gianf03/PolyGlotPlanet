package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;

public class CarrelloDAO {
    public void doSave(Carrello carrello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Carrello (IDUtente) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carrello.getUtente().getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Carrello doRetrieveByIdUtente(int idUtente) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM Carrello c JOIN Utente u ON c.IDUtente=u.ID WHERE u.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();

            Carrello c = null;

            while (rs.next()) {
                c = new Carrello();

                Utente u = new Utente();
                u.setID(rs.getInt("u.ID"));
                u.setNome(rs.getString("u.nome"));
                u.setCognome(rs.getString("u.cognome"));
                u.setDataNascita(rs.getDate("u.dataNascita").toLocalDate());
                u.setEmail(rs.getString("u.email"));
                u.setPassword(rs.getString("u.passwordHash"));
                u.setGenere(rs.getString("u.genere"));
                u.setAdmin(rs.getBoolean("u.admin"));

                c.setId(rs.getInt("c.ID"));
                c.setUtente(u);
            }

            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
