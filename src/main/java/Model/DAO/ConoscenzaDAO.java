package Model.DAO;

import Model.Bean.Conoscenza;
import Model.Bean.Esperto;
import Model.Bean.Lingua;
import Model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConoscenzaDAO {

    public List<Conoscenza> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            String sql = "select * from (Conoscenza c join Esperto e on c.IDEsperto=e.ID) join Lingua l on c.codISOLingua=l.codISOLingua";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Conoscenza> conoscenze = new ArrayList<>();

            while(rs.next()){
                Conoscenza c = new Conoscenza();

                Esperto e = new Esperto();

                e.setID(rs.getInt("e.ID"));
                e.setNome(rs.getString("e.nome"));
                e.setCognome(rs.getString("e.cognome"));
                e.setEmail(rs.getString("e.email"));
                e.setPassword(rs.getString("e.passwordHash"));
                e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                e.setGenere(rs.getString("e.genere"));
                e.setValutazione(rs.getDouble("e.valutazione"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setEsperto(e);
                c.setLingua(l);

                conoscenze.add(c);
            }

            return conoscenze;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Conoscenza> doRetrieveByIDEsperto(int idEsperto){
        try (Connection con = ConPool.getConnection()) {
            String sql = "select * from (Conoscenza c join Esperto e on c.IDEsperto=e.ID) " +
                    "join Lingua l on c.codISOLingua=l.codISOLingua where e.ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEsperto);

            ResultSet rs = ps.executeQuery();

            List<Conoscenza> conoscenze = new ArrayList<>();

            while(rs.next()){
                Conoscenza c = new Conoscenza();

                Esperto e = new Esperto();

                e.setID(rs.getInt("e.ID"));
                e.setNome(rs.getString("e.nome"));
                e.setCognome(rs.getString("e.cognome"));
                e.setEmail(rs.getString("e.email"));
                e.setPassword(rs.getString("e.passwordHash"));
                e.setDataNascita(rs.getDate("e.dataNascita").toLocalDate());
                e.setGenere(rs.getString("e.genere"));
                e.setFotoRiconoscitiva(rs.getString("e.fotoRiconoscitiva"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                c.setEsperto(e);
                c.setLingua(l);

                conoscenze.add(c);
            }

            return conoscenze;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public void doSave(int IDEsperto, String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Conoscenza (codISOLingua, IDEsperto) VALUES(?,?)");

            ps.setString(1, codISOLingua);
            ps.setInt(2, IDEsperto);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(int IDEsperto, String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Conoscenza WHERE codISOLingua=? AND IDEsperto=?");

            ps.setString(1, codISOLingua);
            ps.setInt(2, IDEsperto);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
