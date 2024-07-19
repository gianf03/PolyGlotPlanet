package Controller;

import Model.Bean.Conoscenza;
import Model.Bean.Esperto;
import Model.Bean.Lingua;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.LinguaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraLingueEsperto")
public class MostraLingueEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        int IDEsperto = ((Esperto) req.getSession().getAttribute("esperto")).getID();
        List<Conoscenza> conoscenzeEsp = null;

        String address = "homeEsperto.jsp";

        ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
        conoscenzeEsp = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

        LinguaDAO linguaDAO = new LinguaDAO();
        List<Lingua> lingue = linguaDAO.getLingueNonConosciuteEsperto(IDEsperto);

        req.setAttribute("lingueNonConosciute", lingue);
        req.setAttribute("conoscenzeEsp", conoscenzeEsp);


        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
