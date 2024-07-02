package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorsoDAO  extends ProdottoDAO{

    public Corso doRetrieveById(int IDProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT p.prezzoBase, p.scontoPercentuale, p.IDCategoria, c.descrizione, c.numeroUnita, c.livello, c.codISOLingua " +
                                                "FROM (Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) JOIN Categoria ca ON p.IDCatgoria=ca.ID" +
                                                "WHERE id=?");
            ps.setInt(1, IDProdotto);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                c.setID(IDProdotto);
<<<<<<< HEAD
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setCategoria(cat);
=======
                c.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                c.setIDCategoria(rs.getInt("p.IDCategoria"));
>>>>>>> bc09c0ca7c4735830f40dc8a4e7f3ae01361d25d
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
<<<<<<< HEAD
            if (!codISOLingua.isEmpty()){
                ps = con.prepareStatement("SELECT * FROM (Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) JOIN Categoria ca ON p.IDCategoria=ca.ID WHERE codISOLingua=?");
                ps.setString(1, codISOLingua);
            } else {
                ps = con.prepareStatement("SELECT * FROM (Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) JOIN Categoria ca ON p.IDCategoria=ca.ID");
            }
=======
            ps = con.prepareStatement("SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto WHERE codISOLingua=?");
            ps.setString(1, codISOLingua);

>>>>>>> bc09c0ca7c4735830f40dc8a4e7f3ae01361d25d


            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
<<<<<<< HEAD
                c.setCategoria(cat);
=======
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setIDCategoria(rs.getInt("IDCategoria"));
>>>>>>> bc09c0ca7c4735830f40dc8a4e7f3ae01361d25d
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

    public List<Corso> doRetrieveByLivello(String livello) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto WHERE livello=?");
            ps.setString(1, livello);


            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
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

            String sql = "SELECT * FROM (Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) JOIN Categoria ca ON p.IDCategoria=ca.ID";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
<<<<<<< HEAD
                c.setCategoria(cat);
=======
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setIDCategoria(rs.getInt("IDCategoria"));
>>>>>>> bc09c0ca7c4735830f40dc8a4e7f3ae01361d25d
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

    public List<Corso> doRetrieveByCodISOLinguaPrezzoMinMaxAndLivello(String codISOLingua, int prezzoMin, int prezzoMax, String livello) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;

            ps = con.prepareStatement("SELECT * FROM Prodotto p JOIN Corso c ON p.ID=c.IDProdotto " +
                        "WHERE codISOLingua=? AND prezzoAttuale>=? AND prezzoAttuale<? AND livello=?");
            ps.setString(1, codISOLingua);
            ps.setInt(2, prezzoMin);
            ps.setInt(3, prezzoMax);
            ps.setString(4, livello);

            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while (rs.next()) {
                Corso c = new Corso();

                c.setID(rs.getInt("ID"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
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

    public List<Integer> doRetrievePrezzoMinMax(){
        return doRetrievePrezzoMinMaxByCategoria(1);
    }
}
