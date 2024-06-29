package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorsoDAO {

    public Corso doRetrieveById(int IDProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT p.prezzoBase, p.scontoPercentuale, p.IDCategoria, c.descrizione, c.numeroUnita, c.livello, c.codISOLingua " +
                                                "FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto" +
                                                "WHERE id=?");
            ps.setInt(1, IDProdotto);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Corso c = new Corso();

                c.setID(IDProdotto);
                c.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                c.setIDCategoria(rs.getInt("p.IDCategoria"));
                c.setIDProdotto(IDProdotto);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setCodISOLingua(rs.getString("codISOLingua"));

                return c;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Corso> doRetrieveByCodISOLingua(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            if (!codISOLingua.isEmpty()){
                ps = con.prepareStatement("SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto WHERE codISOLingua=?");
            ps.setString(1, codISOLingua);
            } else {
                ps = con.prepareStatement("SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto");
            }


            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setIDCategoria(rs.getInt("IDCategoria"));
                c.setIDProdotto(rs.getInt("IDProdotto"));
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setCodISOLingua(rs.getString("codISOLingua"));

                corsi.add(c);
            }

            return corsi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Corso> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setIDCategoria(rs.getInt("IDCategoria"));
                c.setIDProdotto(rs.getInt("IDProdotto"));
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setCodISOLingua(rs.getString("codISOLingua"));

                corsi.add(c);
            }

            return corsi;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
