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

@WebServlet("/modificaProdotto")
public class ModificaProdottoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Boolean disponibile = Boolean.parseBoolean(req.getParameter("disponibile"));
        Double prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
        Double scontoPercentuale = Double.parseDouble(req.getParameter("scontoPercentuale"));
        int IDProdotto = Integer.parseInt(req.getParameter("IDProdotto"));

        String address = "corsiAdmin.jsp";

        if(disponibile != null && prezzoBase != null && scontoPercentuale != null && prezzoBase > 0
                && scontoPercentuale >=0 && IDProdotto > 0) {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            prodottoDAO.doUpdate(IDProdotto, disponibile, prezzoBase, scontoPercentuale);
        }

        CorsoDAO corsoDAO = new CorsoDAO();
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
