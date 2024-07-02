package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public List<Prodotto> doRetrieveAllByOrdine(int IDOrdine) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT *" +
                    "FROM (Composizione c JOIN Prodotto p ON c.IDProdotto=p.ID) JOIN Categoria ca ON p.IDCategoria=ca.ID" +
                    "WHERE c.IDOrdine=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDOrdine);

            ResultSet rs = ps.executeQuery();

            List<Prodotto> prodotti = new ArrayList<>();

            while(rs.next()) {
                String nomeCat = rs.getString("nome");
                int idCat = rs.getInt("IDCategoria");

                Categoria cat = new Categoria();
                cat.setNome(nomeCat);
                cat.setID(idCat);

            }

            return prodotti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
