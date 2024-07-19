package Controller;

import Model.Bean.*;
import Model.DAO.ColloquioDAO;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.EspertoDAO;
import Model.DAO.IncontroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mostraIncontriAdminEsperto")
public class MostraIncontriAdminEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        IncontroDAO incontroDAO = new IncontroDAO();
        int IDEsperto = 0;
        String address = "/incontriEsperto.jsp";
        List<Lingua> lingueConosciute = null;

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");

        try {
            IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));

            EspertoDAO espertoDAO = new EspertoDAO();

            if((e != null && e.getID() == IDEsperto) || espertoDAO.doRetrieveById(IDEsperto) != null) {

                /*inserisco la lista delle lingue conosciute dell'esperto nella request
                per poter aggiungere un nuovo incontro*/
                ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
                List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

                lingueConosciute = new ArrayList<>();

                for (Conoscenza c : conoscenze) {
                    lingueConosciute.add(c.getLingua());
                }

                List<Incontro> incontri = incontroDAO.doRetrieveByEsperto(IDEsperto);
                req.setAttribute("lingueConosciute", lingueConosciute);
                req.setAttribute("incontri", incontri);

                RequestDispatcher rd = req.getRequestDispatcher(address);
                rd.forward(req, resp);

            } else if (e == null && espertoDAO.doRetrieveById(IDEsperto) == null) {
                address = "homeAdmin.jsp?error=24"; //esperto inesistente
            } else if(e != null && IDEsperto != e.getID()) {
                address = "homeEsperto.jsp?error=24"; //esperto inesistente
            }

        } catch (NumberFormatException ex) {
            if(e == null) {
                address = "homeAdmin.jsp?error=24"; //esperto inesistente
            } else {
                address = "homeEsperto.jsp?error=24"; //esperto inesistente
            }
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
