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

            while (rs.next()) {
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


    public List<Integer> doRetrievePrezzoMinMaxByCategoria(int categoria) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT min(prezzoAttuale) AS min FROM Prodotto WHERE IDCategoria=?");
            ps.setInt(1, categoria);
            ResultSet rs1 = ps.executeQuery();

            ps = con.prepareStatement("SELECT max(prezzoAttuale) AS max FROM Prodotto WHERE IDCategoria=?");
            ps.setInt(1, categoria);
            ResultSet rs2 = ps.executeQuery();

            int min=0, max=0;
            while (rs1.next()){
                min = rs1.getInt("min");
                while (min%10 != 0)
                    min--;
            }
            while (rs2.next()){
                max = rs2.getInt("max");
                while (max%10 != 0)
                    max++;
            }

            List<Integer> prezzi = new ArrayList<>();
            prezzi.add(min);
            prezzi.add(max);

            return prezzi;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
