package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Conoscenza;
import Model.Bean.Lingua;
import Model.DAO.ColloquioDAO;
import Model.DAO.ConoscenzaDAO;
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
        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));
        List<Colloquio> colloqui = colloquioDAO.doRetrieveByEsperto(IDEsperto);
        String address = "/colloquiEsperto.jsp";

        /*inserisco la lista delle lingue conosciute dell'esperto nella request
        per poter aggiungere un nuovo colloquio*/
        ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
        List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

        List<Lingua> lingueConosciute = new ArrayList<>();

        for(Conoscenza c : conoscenze) {
            lingueConosciute.add(c.getLingua());
        }

        req.setAttribute("lingueConosciute", lingueConosciute);
        req.setAttribute("colloqui", colloqui);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
