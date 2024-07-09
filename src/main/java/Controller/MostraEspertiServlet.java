package Controller;

import Model.Esperto;
import Model.EspertoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraEsperti")
public class MostraEspertiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        EspertoDAO espertoDAO = new EspertoDAO();
        List<Esperto> esperti = espertoDAO.doRetrieveAll();

        req.setAttribute("esperti", esperti);

        RequestDispatcher rd = req.getRequestDispatcher("espertiAdmin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
