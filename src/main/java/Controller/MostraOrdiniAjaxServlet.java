package Controller;

import Model.Ordine;
import Model.OrdineDAO;
import Model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraOrdiniAjax")
public class MostraOrdiniAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        Utente u = (Utente) req.getSession().getAttribute("utente");

        OrdineDAO ordineDAO = new OrdineDAO();

        List<Ordine> ordini = ordineDAO.doRetrieveAllByUtente(u.getID());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
