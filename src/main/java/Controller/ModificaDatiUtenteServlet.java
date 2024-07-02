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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/modificaDatiUtente")
public class ModificaDatiUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String newPassword = req.getParameter("newPass");
        String confNewPassword = req.getParameter("confNewPass");



        String address = "impostazioniUtente.jsp";

        Utente u = (Utente) req.getSession().getAttribute("utente");

        if(nome.isEmpty() && cognome.isEmpty()) {
            address = address + "?error=1";
        } else if(!confNewPassword.equals(newPassword)){
            address = address + "?error=2";
        } else if(!newPassword.isEmpty() && newPassword.length() < 8) {
            address = address + "?error=3";
        } else {
            UtenteDAO utenteDAO = new UtenteDAO();
            utenteDAO.doUpdate(u.getID(), nome, cognome, newPassword);
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
