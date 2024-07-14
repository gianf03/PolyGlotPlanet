package Model.DAO;

import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    public List<Ordine> doRetrieveAllByUtente(int IDUtente) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT o.ID, o.prezzoTotale FROM Utente u JOIN Ordine o ON u.ID=o.IDUtente WHERE u.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDUtente);

            ResultSet rs = ps.executeQuery();

            List<Ordine> ordini = new ArrayList<>();

            while(rs.next()) {
                Ordine o = new Ordine();

                Utente u = new Utente();
                u.setID(IDUtente);
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setDataNascita(rs.getDate("dataNascita").toLocalDate());
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("passwordHash"));
                u.setGenere(rs.getString("genere"));
                u.setAdmin(rs.getBoolean("admin"));

                o.setID(rs.getInt("ID"));
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                o.setUtente(u);
            }

            return ordini;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}