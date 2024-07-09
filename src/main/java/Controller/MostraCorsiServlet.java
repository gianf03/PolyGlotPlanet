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

@WebServlet("/corso")
public class MostraCorsiServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        CorsoDAO corsoDAO = new CorsoDAO();

        String codISOLingua = req.getParameter("lingua");

        List<Corso> corsi = corsoDAO.doRetrieveByCodISOLingua(codISOLingua);

        req.setAttribute("corsi", corsi);

        RequestDispatcher rd = req.getRequestDispatcher("/corsi.jsp");
        rd.forward(req, res);
    }
}
