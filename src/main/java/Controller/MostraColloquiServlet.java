package Controller;

import Model.Bean.Colloquio;
import Model.DAO.ColloquioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/colloquio")
public class MostraColloquiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ColloquioDAO colloquioDAO = new ColloquioDAO();
        List<Colloquio> colloqui = null;
        String address = null;

        String codISOLingua = req.getParameter("codLingua");
        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));

        if(codISOLingua != null) {
            colloqui = colloquioDAO.doRetrieveByCodISOLingua(codISOLingua);
            address = "/colloqui.jsp";
        } else if(IDEsperto > 0) {
            colloqui = colloquioDAO.doRetrieveByEsperto(IDEsperto);
            address = "/colloquiEsperto.jsp";
        }

        req.setAttribute("colloqui", colloqui);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
