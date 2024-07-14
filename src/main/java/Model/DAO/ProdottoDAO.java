package Model.DAO;

import Model.Bean.*;
import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public void doUpdate(int IDProdotto, boolean disponibile, double prezzoBase, double scontoPercentuale) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Prodotto " +
                                                            "SET disponibile=?, prezzoBase=?, scontoPercentuale=? " +
                                                            "WHERE ID=?");

            ps.setBoolean(1, disponibile);
            ps.setDouble(2, prezzoBase);
            ps.setDouble(3, scontoPercentuale);
            ps.setInt(4, IDProdotto);

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