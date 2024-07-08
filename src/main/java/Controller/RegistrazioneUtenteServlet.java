package Controller;

import Model.Utente;
import Model.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/registrazioneUtente")
public class RegistrazioneUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = "registrazioneUtente.jsp?";
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String ddn = req.getParameter("ddn");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sesso = req.getParameter("sesso");
        boolean admin = false;
        LocalDate dataNascita = null;

        UtenteDAO utenteDAO = new UtenteDAO();

        if (nome==null || nome.isBlank()) { address += "error=1&";  /*nome assente*/ }
        if (cognome==null || cognome.isBlank()){address += "error=2&"; /*cognome assente*/}

        if (utenteDAO.isExistingEmail(email)){
            address += "error=12&";
        } else if (email==null || email.isEmpty()){
            address += "error=3&"; /*email assente*/
        } else if (!email.contains("@")){
            address += "error=4&"; //email non conforme
        } else {
            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".")) {
                address += "error=4&";
            }
        }

        if (password==null || password.isEmpty()) {
            address += "error=5&"; //password assente
        } else if (password.length()<8){
            address += "error=6&"; //password troppo corta
        }

        if (sesso==null || (!sesso.equals("M") && !sesso.equals("F"))){address += "error=7&"; /*genere non previsto*/}

        try {
            if (ddn == null || ddn.isEmpty()){
                address += "error=8&"; /*nessuna data di nascita*/
            } else
                dataNascita = LocalDate.parse(ddn);
        }
        catch (DateTimeParseException e) {
            address += "error=9&";  //non è una data di nascita
        }
        finally {

            address = address.substring(0, address.length() - 1);

            if (!address.contains("error")) {

                Utente utente = new Utente();

                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);
                utente.setPassword(password);
                utente.setDataNascita(dataNascita);
                utente.setGenere(sesso);
                utente.setAdmin(admin);

                utenteDAO.doSave(utente);
                address = "index.jsp";
            }
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
