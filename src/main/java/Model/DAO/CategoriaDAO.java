package Model.DAO;

import Model.Bean.Categoria;
import Model.ConPool;

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
                c.setImmagine(rs.getString("foto"));

                categorie.add(c);
            }

            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Categoria doRetrieveByName(String name){
        try (Connection con = ConPool.getConnection()) {
            String sql = "select * from Categoria where nome=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();


            Categoria cat = null;

            if(rs.next()){
                cat = new Categoria();

                cat.setNome(rs.getString("nome"));
                cat.setID(rs.getInt("ID"));
                cat.setImmagine(rs.getString("foto"));
            }

            return cat;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
