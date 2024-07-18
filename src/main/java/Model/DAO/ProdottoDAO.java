package Model.DAO;

import Model.Bean.*;
import Model.ConPool;
import Utils.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {
    public void doUpdate(int IDProdotto, double prezzoBase, double scontoPercentuale) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Prodotto " +
                    "SET prezzoBase=?, scontoPercentuale=? WHERE ID=?");

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

    public Prodotto doRetrieveById(int idProdotto) {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM " +
                    "((Prodotto p " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=l.codISOLingua) " +
                    "LEFT JOIN Corso ON p.ID=corso.IDProdotto " +
                    "LEFT JOIN Colloquio ON p.ID=colloquio.IDProdotto " +
                    "LEFT JOIN Incontro ON p.ID=incontro.IDProdotto " +
                    "LEFT JOIN Esperto e ON (e.ID=colloquio.IDEsperto or e.ID=incontro.IDEsperto) " +
                    "WHERE p.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProdotto);

            ResultSet rs = ps.executeQuery();

            Corso corso = null;
            Incontro incontro = null;
            Colloquio colloquio = null;

            while(rs.next()) {
                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("foto"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setNome(rs.getString("l.nome"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                if(cat.getID() == 1){
                    corso = new Corso();

                    corso.setID(rs.getInt("p.ID"));
                    corso.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                    corso.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                    corso.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                    corso.setCategoria(cat);
                    corso.setLingua(l);

                    corso.setDescrizione(rs.getString("corso.descrizione"));
                    corso.setNumeroUnita(rs.getInt("corso.numeroUnita"));
                    corso.setLivello(rs.getString("corso.livello"));
                    corso.setDisponibile(rs.getBoolean("corso.disponibile"));
                } else {
                    Esperto e = new Esperto();

                    e.setID(rs.getInt("e.ID"));
                    e.setNome(rs.getString("e.nome"));
                    e.setCognome(rs.getString("e.cognome"));
                    e.setEmail(rs.getString("e.email"));
                    e.setPassword(rs.getString("e.passwordHash"));
                    e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                    e.setGenere(rs.getString("e.genere"));
                    e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));

                    if (cat.getID() == 2) {
                        incontro = new Incontro();

                        incontro.setID(rs.getInt("p.ID"));
                        incontro.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        incontro.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        incontro.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        incontro.setCategoria(cat);
                        incontro.setLingua(l);

                        incontro.setEsperto(e);
                        incontro.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("incontro.dataOra")));
                        incontro.setPrenotato(rs.getBoolean("incontro.prenotato"));
                        incontro.setCAP(rs.getString("incontro.CAP"));
                        incontro.setVia(rs.getString("incontro.via"));
                        incontro.setCivico(rs.getString("incontro.civico"));
                    } else {
                        colloquio = new Colloquio();

                        colloquio.setID(rs.getInt("p.ID"));
                        colloquio.setPrezzoBase(rs.getDouble("p.prezzoBase"));
                        colloquio.setScontoPercentuale(rs.getDouble("p.scontoPercentuale"));
                        colloquio.setPrezzoAttuale(rs.getDouble("p.prezzoAttuale"));
                        colloquio.setCategoria(cat);
                        colloquio.setLingua(l);

                        colloquio.setEsperto(e);
                        colloquio.setDataOra(Utility.sqlDateTimeToLocalDateTime(rs.getString("colloquio.dataOra")));
                        colloquio.setPrenotato(rs.getBoolean("colloquio.prenotato"));
                    }
                }

            }

            if (corso != null)
                return corso;
            else if (incontro != null)
                return incontro;
            else if (colloquio != null)
                return colloquio;
            else
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveLastProduct() {
        try (Connection con = ConPool.getConnection()) {

            String sql = "SELECT * FROM (Prodotto p JOIN Categoria ca ON p.IDCategoria=ca.ID) " +
                    "JOIN Lingua l ON p.codISOLingua=p.codISOLingua ORDER BY p.ID desc LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Prodotto p = null;

            while (rs.next()) {
                p = new Prodotto();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));
                cat.setImmagine(rs.getString("foto"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setNome(rs.getString("l.nome"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                p.setID(rs.getInt("p.ID"));
                p.setLingua(l);
                p.setCategoria(cat);
                p.setPrezzoBase(rs.getDouble("prezzoBase"));
                p.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                p.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
            }

            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}