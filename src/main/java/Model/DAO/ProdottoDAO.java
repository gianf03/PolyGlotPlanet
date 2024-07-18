package Model.DAO;

import Model.Bean.*;
import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public Prodotto doRetrieveById(int IDProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM (Prodotto p JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                            "JOIN Categoria ca ON p.IDCategoria=ca.ID " +
                            "WHERE p.ID=?");

            ps.setInt(1, IDProdotto);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Prodotto p = new Prodotto();

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("foto"));

                p.setID(rs.getInt("p.ID"));
                p.setPrezzoBase(rs.getDouble("prezzoBase"));
                p.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                p.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                p.setLingua(l);
                p.setCategoria(cat);

                return p;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(int IDProdotto, double prezzoBase, double scontoPercentuale) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Prodotto " +
                    "SET prezzoBase=?, scontoPercentuale=? WHERE IDProdotto=?");

            ps.setDouble(1, prezzoBase);
            ps.setDouble(2, scontoPercentuale);
            ps.setInt(3, IDProdotto);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int IdProdotto) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE ID=?");

            ps.setInt(1, IdProdotto);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

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

    public void doSave(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotto (prezzoBase, scontoPercentuale, IDCategoria, codISOLingua) VALUES(?,?,?,?)");

            ps.setDouble(1, prodotto.getPrezzoBase());
            ps.setDouble(2, prodotto.getScontoPercentuale());
            ps.setInt(3, prodotto.getCategoria().getID());
            ps.setString(4, prodotto.getLingua().getCodISOLingua());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLastId() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT ID FROM Prodotto ORDER BY ID DESC LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int id = 0;

            if(rs.next()) {
                id = rs.getInt("ID");
            }

            return (id + 1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}