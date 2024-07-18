package Controller;

import Model.Bean.*;
import Model.DAO.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aggiungiColloquioEsperto")
public class AggiungiColloquioEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        LocalDateTime dataOra = null;
        String lingua = req.getParameter("codISOLingua");
        double prezzoBase = 0;
        double sconto = -1;

        String address = "colloquioEsperto.jsp";
        boolean isNumber = true;

        try {
            prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
            sconto = Double.parseDouble(req.getParameter("sconto"));
            dataOra = LocalDateTime.parse(req.getParameter("dataOra"));
        } catch (NumberFormatException | DateTimeParseException e) {
            isNumber = false;
        }

        LocalDateTime minDate = LocalDateTime.now().plusHours(2);

        if(dataOra == null || lingua == null || lingua.isBlank() || !isNumber || prezzoBase <= 0 || sconto < 0 ||
                dataOra.isBefore(minDate)) {
            address += "?error=20"; //colloquio non inserito
        }

        ColloquioDAO colloquioDAO = new ColloquioDAO();
        ProdottoDAO prodottoDAO = new ProdottoDAO();

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");

        if(!address.contains("error")) {

            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoria = categoriaDAO.doRetrieveByName("colloquio");

            LinguaDAO linguaDAO = new LinguaDAO();
            Lingua l = linguaDAO.doRetrieveById(lingua);

            Prodotto p = new Prodotto();
            p.setPrezzoBase(prezzoBase);
            p.setScontoPercentuale(sconto);
            p.setCategoria(categoria);
            p.setLingua(l);

            prodottoDAO.doSave(p);

            p = prodottoDAO.doRetrieveLastProduct();

            Colloquio c = new Colloquio();
            c.setID(p.getID());
            c.setEsperto(e);
            c.setDataOra(dataOra);

            colloquioDAO.doSave(c);

            address += "?insertion=good";
        }

        List<Colloquio> colloqui = colloquioDAO.doRetrieveByEsperto(e.getID());

        ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
        List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(e.getID());

        List<Lingua> lingueConosciute = new ArrayList<>();

        for(Conoscenza con : conoscenze) {
            lingueConosciute.add(con.getLingua());
        }

        req.setAttribute("colloqui", colloqui);
        req.setAttribute("lingueConosciute", lingueConosciute);
        List<Integer> prezziColloqui = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(3);
        getServletContext().setAttribute("prezziColloqui", prezziColloqui);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
