package Controller;

import Model.Bean.Corso;
import Model.Bean.Prodotto;
import Model.DAO.CorsoDAO;
import Model.DAO.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/modificaCorso")
public class ModificaCorsoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        boolean disponibile = Boolean.parseBoolean(req.getParameter("disponibile")); //questo metodo non lancia mai eccezioni perchè se stringa != true restituisce sempre false
        double prezzoBase = 0;
        double scontoPercentuale = -1;
        int IDProdotto = 0;

        String address = "corsiAdmin.jsp";

        CorsoDAO corsoDAO = new CorsoDAO();

        try {
            prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
            scontoPercentuale = Double.parseDouble(req.getParameter("scontoPercentuale"));
            IDProdotto = Integer.parseInt(req.getParameter("IDProdotto"));

            ProdottoDAO prodottoDAO = new ProdottoDAO();

            Prodotto p = prodottoDAO.doRetrieveById(IDProdotto);

            //se il prezzo è > 0, lo sconto è >= 0, il prodotto esiste già nel DB e è un corso (categoria = 1) lo aggiorno
            if(prezzoBase > 0 && scontoPercentuale >=0 && p != null && p.getCategoria().getID() == 1) {

                prodottoDAO.doUpdate(IDProdotto, prezzoBase, scontoPercentuale);

                corsoDAO.doUpdate(disponibile, IDProdotto);
            } else {
                address += "?error=23"; //corso non modificato
            }

        } catch (NumberFormatException e) {
            address += "?error=23"; //corso non modificato
        }

        List<Corso> corsi = corsoDAO.doRetrieveAll();
        req.setAttribute("corsi", corsi);

        //forward indispensabile perchè ci sono dati necessari nella richiesta che con sendRedirect andrebbero persi
        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
