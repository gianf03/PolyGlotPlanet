package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Conoscenza;
import Model.Bean.Lingua;
import Model.DAO.ColloquioDAO;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.LinguaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
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

            /*inserisco la lista delle lingue conosciute dell'esperto nella request
            per poter aggiungere un nuovo colloquio*/
            ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
            List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

            List<Lingua> lingueConosciute = new ArrayList<>();

            for(Conoscenza c : conoscenze) {
                lingueConosciute.add(c.getLingua());
            }

            req.setAttribute("lingueConosciute", lingueConosciute);

            address = "/colloquiEsperto.jsp";
        }

        req.setAttribute("colloqui", colloqui);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
