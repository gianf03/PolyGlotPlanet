package Model.DAO;

import Model.Bean.Categoria;
import Model.Bean.Corso;
import Model.ConPool;
import Model.Bean.Lingua;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorsoDAO{

    public Corso doRetrieveById(int IDProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                            "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) JOIN Categoria ca ON p.IDCategoria=ca.ID " +
                            "WHERE id=?");
            ps.setInt(1, IDProdotto);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Corso c = new Corso();

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("immagine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

                return c;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Corso> doRetrieveByCodISOLinguaDisponibili(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua " +
                    "WHERE l.codISOLingua=? AND disponibile=true");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

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
            ps = con.prepareStatement("SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua " +
                    "WHERE livello=?");
            ps.setString(1, livello);


            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

                corsi.add(c);
            }

            return corsi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Corso> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

                corsi.add(c);
            }

            return corsi;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Corso> doRetrieveAllSorted(String ordPer, String tipo) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua" +
                    " ORDER BY " + ordPer + " " + tipo;

            PreparedStatement ps = con.prepareStatement(sql);



            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while(rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

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

            ps = con.prepareStatement("SELECT * FROM ((Prodotto p JOIN Corso c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON p.codISOLingua=l.codISOLingua " +
                    "WHERE l.codISOLingua=? AND prezzoAttuale>=? AND prezzoAttuale<? AND livello=? AND disponibile=true");
            ps.setString(1, codISOLingua);
            ps.setInt(2, prezzoMin);
            ps.setInt(3, prezzoMax);
            ps.setString(4, livello);

            ResultSet rs = ps.executeQuery();

            List<Corso> corsi = new ArrayList<>();

            while (rs.next()) {
                Corso c = new Corso();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setID(rs.getInt("IDProdotto"));
                c.setPrezzoBase(rs.getDouble("prezzoBase"));
                c.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                c.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                c.setCategoria(cat);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);
                c.setDisponibile(rs.getBoolean("disponibile"));

                corsi.add(c);
            }

            return corsi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void doSave(Corso corso) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Corso (IDprodotto, descrizione, numeroUnita, livello) VALUES(?,?,?,?)");

            ps.setInt(1, corso.getID());
            ps.setString(2, corso.getDescrizione());
            ps.setInt(3, corso.getNumeroUnita());
            ps.setString(4, corso.getLivello());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
