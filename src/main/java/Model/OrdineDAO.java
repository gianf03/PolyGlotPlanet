package Model;

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

                o.setID(rs.getInt("ID"));
                //o.setIDUtente(IDUtente);
                o.setPrezzoTotale(rs.getDouble("prezzoTotale"));
            }

            return ordini;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}