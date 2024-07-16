package Model.DAO;

import Model.Bean.Lingua;
import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinguaDAO {

    public Lingua doRetrieveById(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codISOLingua, nome, parlanti, fotoStatoOrigine FROM Lingua WHERE codISOLingua=?");
            ps.setString(1, codISOLingua);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Lingua p = new Lingua();
                p.setCodISOLingua(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setParlanti(rs.getInt(3));
                p.setFotoStatoOrigine(rs.getString(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Lingua lingua) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Lingua (codISOLingua, nome, parlanti, fotoStatoOrigine) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, lingua.getCodISOLingua());
            ps.setString(2, lingua.getNome());
            ps.setInt(3, lingua.getParlanti());
            ps.setString(4, lingua.getFotoStatoOrigine());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
           // ResultSet rs = ps.getGeneratedKeys();
           // rs.next();
           // int id = rs.getInt(1);
           // customer.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lingua> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM Lingua ORDER BY parlanti DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Lingua> lingue = new ArrayList<>();

            while(rs.next()) {
                Lingua l = new Lingua();

                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setNome(rs.getString("nome"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                lingue.add(l);
            }

            return lingue;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> doRetrieveFoto() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT fotoStatoOrigine FROM Lingua order by parlanti DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<String> foto = new ArrayList<>();

            while(rs.next()) {
                foto.add(rs.getString(1));
            }

            return foto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Lingua> getlingueNonConosciute(int IDEsperto) {
        try (Connection con = ConPool.getConnection()) {
            String sql = "SELECT * FROM Lingua l WHERE l.codISOLingua " +
                    "NOT IN (SELECT l.codISOLingua FROM Conoscenza c JOIN Lingua l " +
                    "ON c.codISOLingua=l.codISOLingua WHERE c.IDEsperto=?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDEsperto);

            ResultSet rs = ps.executeQuery();

            List<Lingua> lingue = new ArrayList<>();

            while(rs.next()){
                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                lingue.add(l);
            }

            return lingue;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
