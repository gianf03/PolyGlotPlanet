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

@WebServlet("/registrazioneUtente")
public class RegistrazioneUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address;
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String ddn = req.getParameter("ddn");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sesso = req.getParameter("sesso");
        boolean admin = false;
        LocalDate dataNascita;

        if (nome == null || cognome == null ||
                (email == null || !email.contains("a")) ||
                (password == null || password.length()<8) ||
                (sesso == null || (!sesso.equals("M") && !sesso.equals("F"))) ||
                ddn == null) {

            address = "registrazioneUtente.jsp";
        } else {

            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!email.contains(".")) {
                address = "registrazioneUtente.jsp";
            } else {

                Utente utente = new Utente();
                try {
                    dataNascita = LocalDate.parse(ddn);
                    utente.setDataNascita(dataNascita);
                    //PrintWriter out = resp.getWriter();
                    //out.println("<html><body>Data di nascita: " + dataNascita + "</body></html>");
                }
                catch (IllegalArgumentException e) {
                    resp.sendRedirect("registrazioneUtente.jsp");
                }

                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);
                utente.setPassword(password);
                utente.setGenere(sesso);
                utente.setAdmin(admin);

                UtenteDAO utenteDAO = new UtenteDAO();
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
