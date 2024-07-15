package Controller;

import Model.Bean.Conoscenza;
import Model.DAO.ConoscenzaDAO;
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

        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));
        List<Conoscenza> conoscenzeEsp = null;

        String address = "lingueEsperto.jsp";

        if(IDEsperto > 0) {
            ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
            conoscenzeEsp = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

            req.setAttribute("conoscenzeEsp", conoscenzeEsp);
        }

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
