package Model.DAO;

import Model.Bean.Utente;
import Model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {
    public void doSave(Utente utente) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO utente (nome, cognome, email, passwordHash, dataNascita, genere, admin) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getPassword());
            ps.setString(5, utente.getDataNascita().toString());
            ps.setString(6, utente.getGenere());
            ps.setBoolean(7, utente.isAdmin());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Utente doRetrieveByEmailAndPassword(String email, String password){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utente utente = null;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM utente WHERE email=? AND passwordhash=SHA1(?)");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utente = new Utente();
                utente.setID(resultSet.getInt("ID"));
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                utente.setEmail(resultSet.getString("email"));
                utente.setPasswordWithEncryption(password);
                utente.setDataNascita(resultSet.getDate("dataNascita").toLocalDate());
                utente.setGenere(resultSet.getString("genere"));
                utente.setAdmin(resultSet.getBoolean("admin"));
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

        return utente;
    }


    public Utente doRetrieveById(int id){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utente utente = null;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM utente WHERE ID=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utente = new Utente();
                utente.setID(resultSet.getInt("ID"));
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                utente.setEmail(resultSet.getString("email"));
                utente.setPassword(resultSet.getString("passwordHash"));
                utente.setDataNascita(resultSet.getDate("dataNascita").toLocalDate());
                utente.setGenere(resultSet.getString("genere"));
                utente.setAdmin(resultSet.getBoolean("admin"));
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

        return utente;
    }

    public void doUpdate(int IDUtente, String nome, String cognome, String newPassword) {

        try (Connection con = ConPool.getConnection()) {

            String sql = null;

            if(newPassword.isEmpty()) {
                sql = "UPDATE Utente SET nome=?, cognome=? WHERE id=?";
            } else {
                sql = "UPDATE Utente SET nome=?, cognome=?, passwordHash=SHA1(?) WHERE id=?";
            }


            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, cognome);

            if(!newPassword.isEmpty()) {
                ps.setString(3, newPassword);
                ps.setInt(4, IDUtente);
            } else {
                ps.setInt(3, IDUtente);
            }

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Utente> doRetrieveAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Utente> utenti;

        try (Connection connection = ConPool.getConnection()) {
            String sql = "SELECT * FROM utente WHERE admin=false";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            utenti = new ArrayList<>();

            while (resultSet.next()) {
                Utente utente = new Utente();

                utente.setID(resultSet.getInt("ID"));
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                utente.setEmail(resultSet.getString("email"));
                utente.setPassword(resultSet.getString("passwordHash"));
                utente.setDataNascita(resultSet.getDate("dataNascita").toLocalDate());
                utente.setGenere(resultSet.getString("genere"));
                utente.setAdmin(resultSet.getBoolean("admin"));

                utenti.add(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return utenti;
    }

    public boolean isExistingEmail(String email){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean flag = false;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM Utente WHERE email=?");
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
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

        return flag;
    }
}

