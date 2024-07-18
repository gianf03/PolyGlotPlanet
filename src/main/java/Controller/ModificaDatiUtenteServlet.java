package Controller;

import Model.Bean.Utente;
import Model.DAO.UtenteDAO;
import Utils.Utility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/modificaDatiUtente")
public class ModificaDatiUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String newPassword = req.getParameter("newPass");
        String confNewPassword = req.getParameter("confNewPass");



        String address = "areaUtente.jsp?";

        Utente u = (Utente) req.getSession().getAttribute("utente");

        if(nome == null || nome.isBlank()) {
            address = address + "error=1&";
        }

        if (cognome == null || cognome.isBlank()) {
            address = address + "error=2&";
        }

        //controllo che la nuova password non sia vuota e abbia almeno 8 caratteri
        if (newPassword == null || (!newPassword.isEmpty() && newPassword.length() < 8)) {
            address = address + "error=6&";
        } else if (confNewPassword == null || !confNewPassword.equals(newPassword)) { //controllo che la nuova password e la sua conferma siano uguali
            address = address + "error=10&"; //password non coincidono
        }


        /*in assenza di errori rimuovo il '?' da address altrimenti rimuovo
        un '&' per come ho progettato i controlli*/
        address = address.substring(0, address.length()-1);

        if(address.equals("areaUtente.jsp")) {
            UtenteDAO utenteDAO = new UtenteDAO();
            utenteDAO.doUpdate(u.getID(), nome, cognome, newPassword);

            int IDUtente = u.getID();

            u = utenteDAO.doRetrieveById(IDUtente);

            req.getSession().setAttribute("utente",u);
        }


        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
