package Controller;

import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/tuttiCorsi")
public class TuttiCorsiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        CorsoDAO corsoDAO = new CorsoDAO();

        List<Corso> corsi = corsoDAO.doRetrieveAll();
        req.setAttribute("corsi", corsi);

        String address;

        Utente u = (Utente) req.getSession().getAttribute("utente");

        if(u!=null && u.isAdmin()) {
            address = "WEB-INF/jsp/corsiAdmin.jsp";
        } else {
            address = "corsi.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
