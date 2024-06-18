package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoriaDAO {
    public List<Categoria> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            String sql = "select * from Categoria";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Categoria> categorie = new ArrayList<>();

            while(rs.next()){
                Categoria c = new Categoria();

                c.setNome(rs.getString("nome"));
                c.setID(rs.getInt("ID"));

                categorie.add(c);
            }

            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
