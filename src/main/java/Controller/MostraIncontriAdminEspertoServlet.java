package Controller;

import Model.Bean.Conoscenza;
import Model.Bean.Incontro;
import Model.Bean.Lingua;
import Model.DAO.ConoscenzaDAO;
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
        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));
        List<Incontro> incontri = incontroDAO.doRetrieveByEsperto(IDEsperto);
        String address = "/incontriEsperto.jsp";


        /*inserisco la lista delle lingue conosciute dell'esperto nella request
        per poter aggiungere un nuovo incontro*/
        ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
        List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(IDEsperto);

        List<Lingua> lingueConosciute = new ArrayList<>();

        for(Conoscenza c : conoscenze) {
            lingueConosciute.add(c.getLingua());
        }

        req.setAttribute("lingueConosciute", lingueConosciute);
        req.setAttribute("incontri", incontri);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
