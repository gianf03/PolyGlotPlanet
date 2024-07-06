package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspertoDAO {
    public void doSave(Esperto esperto) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO esperto (nome, cognome, email, passwordHash, dataNascita, genere, fotoRiconoscitiva) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, esperto.getNome());
            ps.setString(2, esperto.getCognome());
            ps.setString(3, esperto.getEmail());
            ps.setString(4, esperto.getPassword());
            ps.setString(5, esperto.getDataNascita().toString());
            ps.setString(6, esperto.getGenere());
           // ps.setDouble(7, esperto.getValutazione());
            ps.setString(7, esperto.getFotoRiconoscitiva());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Esperto doRetrieveByEmailAndPassword(String email, String password){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Esperto esperto = null;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM esperto WHERE email=? and password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                esperto = new Esperto();
                esperto.setID(resultSet.getInt("ID"));
                esperto.setNome(resultSet.getString("nome"));
                esperto.setCognome(resultSet.getString("cognome"));
                esperto.setEmail(resultSet.getString("email"));
                esperto.setPassword(password);
                esperto.setDataNascita(resultSet.getDate("dataNascita").toLocalDate());
                esperto.setGenere(resultSet.getString("genere"));
                esperto.setValutazione(resultSet.getInt("valutazione"));
                esperto.setFotoRiconoscitiva(resultSet.getString("fotoRiconoscitiva"));
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return esperto;
    }

    public int getNextId(){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Esperto esperto = null;
        int i = 1;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM esperto ORDER BY ID", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //ho bisogno di un ResultSet Type_scroll_insensitive perché quello di default non supporta il metodo last()
            resultSet = statement.executeQuery();

            //uando eseguo resultSet.last(), il ResultSet si sposta all'ultima riga del set di risultati ottenuto da una query SQL
            if (resultSet.last()) {
                if (resultSet.getInt("ID") >= i){
                    i = resultSet.getInt("ID")+1;
                }
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return i;
    }
}