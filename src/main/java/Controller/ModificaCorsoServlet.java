package Controller;

import Model.Bean.Corso;
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

        boolean disponibile = Boolean.parseBoolean(req.getParameter("disponibile"));
        double prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
        double scontoPercentuale = Double.parseDouble(req.getParameter("scontoPercentuale"));
        int IDProdotto = Integer.parseInt(req.getParameter("IDProdotto"));

        String address = "corsiAdmin.jsp";

        CorsoDAO corsoDAO = new CorsoDAO();

        if(prezzoBase > 0 && scontoPercentuale >=0) {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            prodottoDAO.doUpdate(IDProdotto, prezzoBase, scontoPercentuale);

            corsoDAO.doUpdate(disponibile, IDProdotto);
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
