package Controller;

import Model.Bean.Colloquio;
import Model.DAO.ColloquioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MostraColloquiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ColloquioDAO colloquioDAO = new ColloquioDAO();

        String codISOLingua = req.getParameter("lingua");

        List<Colloquio> colloqui = colloquioDAO.doRetrieveByCodISOLingua(codISOLingua);

        req.setAttribute("colloqui", colloqui);

        RequestDispatcher rd = req.getRequestDispatcher("/colloqui.jsp");
        rd.forward(req, resp);
    }
}
