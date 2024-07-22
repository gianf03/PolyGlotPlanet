package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Conoscenza;
import Model.Bean.Esperto;
import Model.Bean.Lingua;
import Model.DAO.ColloquioDAO;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.EspertoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mostraColloquiAdminEsperto")
public class MostraColloquiAdminEspertoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ColloquioDAO colloquioDAO = new ColloquioDAO();
        int IDEsperto = 0;
        String address = "colloquiEsperto.jsp";
        List<Lingua> lingueConosciute = null;

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");

        try {
            IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));

            EspertoDAO espertoDAO = new EspertoDAO();

            if((e != null && e.getID() == IDEsperto) || espertoDAO.doRetrieveById(IDEsperto) != null) {

                /*inserisco la lista delle lingue conosciute dell'esperto nella request
                per poter aggiungere un nuovo colloquio*/
                ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
                List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

                lingueConosciute = new ArrayList<>();

                for (Conoscenza c : conoscenze) {
                    lingueConosciute.add(c.getLingua());
                }

                List<Colloquio> colloqui = colloquioDAO.doRetrieveByEsperto(IDEsperto);
                req.setAttribute("lingueConosciute", lingueConosciute);
                req.setAttribute("colloqui", colloqui);

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

        if (address.contains("error"))  /*necessario altrimenti IllegalStateException : non posso chiamare sendRedirect dopo un forward*/
            resp.sendRedirect(address);
    }
}
