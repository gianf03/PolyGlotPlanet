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
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aggiungiIncontroEsperto")
public class AggiungiIncontroEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        LocalDateTime dataOra = null;
        String cap = req.getParameter("cap");
        String via = req.getParameter("via");
        String civico = req.getParameter("civico");
        String lingua = req.getParameter("codISOLingua");
        double prezzoBase = 0;
        double sconto = -1;

        String address = "incontriEsperto.jsp";
        boolean isNumber = true;

        try {
            prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
            sconto = Double.parseDouble(req.getParameter("sconto"));
            dataOra = LocalDateTime.parse(req.getParameter("dataOra"));
        } catch (NumberFormatException | DateTimeParseException e) {
            isNumber = false;
        }

        LocalDateTime minDate = LocalDateTime.now().plusHours(26);

        if(dataOra == null || cap == null || cap.isBlank() || via == null || via.isBlank() || !isNumber ||
            civico == null || civico.isBlank() || lingua == null || lingua.isBlank() || prezzoBase <= 0 ||
                sconto < 0 || dataOra.isBefore(minDate)) {
            address += "?error=19"; //incontro non inserito
        }

        IncontroDAO incontroDAO = new IncontroDAO();
        ProdottoDAO prodottoDAO = new ProdottoDAO();

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");

        if(!address.contains("error")) {

            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoria = categoriaDAO.doRetrieveByName("incontro");

            LinguaDAO linguaDAO = new LinguaDAO();
            Lingua l = linguaDAO.doRetrieveById(lingua);

            Prodotto p = new Prodotto();
            p.setPrezzoBase(prezzoBase);
            p.setScontoPercentuale(sconto);
            p.setCategoria(categoria);
            p.setLingua(l);

            prodottoDAO.doSave(p);

            p = prodottoDAO.doRetrieveLastProduct();

            Incontro i = new Incontro();
            i.setID(p.getID());
            i.setEsperto(e);
            i.setDataOra(dataOra);
            i.setCAP(cap);
            i.setVia(via);
            i.setCivico(civico);

            incontroDAO.doSave(i);

            address += "?insertion=good";
        }

        List<Incontro> incontri = incontroDAO.doRetrieveByEsperto(e.getID());

        ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
        List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(e.getID());

        List<Lingua> lingueConosciute = new ArrayList<>();

        for(Conoscenza c : conoscenze) {
            lingueConosciute.add(c.getLingua());
        }

        req.setAttribute("incontri", incontri);
        req.setAttribute("lingueConosciute", lingueConosciute);
        List<Integer> prezziIncontri = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(2);
        getServletContext().setAttribute("prezziIncontri", prezziIncontri);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
