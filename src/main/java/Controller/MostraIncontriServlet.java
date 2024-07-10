package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Incontro;
import Model.DAO.ColloquioDAO;
import Model.DAO.IncontroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/incontro")
public class MostraIncontriServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        IncontroDAO incontroDAO = new IncontroDAO();
        List<Incontro> incontri = null;
        String address = null;

        String codISOLingua = req.getParameter("lingua");
        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));

        if(codISOLingua != null) {
            incontri = incontroDAO.doRetrieveByCodISOLingua(codISOLingua);
            address = "/incontri.jsp";
        } else if(IDEsperto > 0) {
            incontri = incontroDAO.doRetrieveByEsperto(IDEsperto);
            address = "/incontriEsperto.jsp";
        }

        req.setAttribute("incontri", incontri);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
