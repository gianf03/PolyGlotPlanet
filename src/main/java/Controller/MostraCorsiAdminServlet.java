package Controller;

import Model.Bean.Corso;
import Model.DAO.CorsoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraCorsiAdmin")
public class MostraCorsiAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        CorsoDAO corsoDAO = new CorsoDAO();

        List<Corso> corsi = corsoDAO.doRetrieveAll();


        String address = "corsiAdmin.jsp";

        String ordPer = req.getParameter("ordPer");
        String tipo = req.getParameter("tipo");

        if(ordPer != null && tipo != null) {
            corsi = corsoDAO.doRetrieveAllSorted(ordPer, tipo);
        }

        req.setAttribute("corsi", corsi);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
