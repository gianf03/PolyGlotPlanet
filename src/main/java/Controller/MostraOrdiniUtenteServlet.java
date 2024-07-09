package Controller;

import Model.Bean.Composizione;
import Model.DAO.ComposizioneDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraOrdiniUtente")
public class MostraOrdiniUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        int IDUtente = Integer.parseInt(req.getParameter("IDUtente"));

        ComposizioneDAO composizioneDAO = new ComposizioneDAO();
        List<Composizione> ordini = composizioneDAO.doRetrieveAllByUtente(IDUtente);

        //fare controlli sul valore di IDUtente

        req.setAttribute("ordini", ordini);

        RequestDispatcher rd = req.getRequestDispatcher("ordiniUtente.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
