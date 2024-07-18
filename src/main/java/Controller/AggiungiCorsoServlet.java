package Controller;

import Model.Bean.Categoria;
import Model.Bean.Corso;
import Model.Bean.Lingua;
import Model.DAO.CategoriaDAO;
import Model.DAO.CorsoDAO;
import Model.DAO.LinguaDAO;
import Model.DAO.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/aggiungiCorso")
public class AggiungiCorsoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String codISOLingua = req.getParameter("codISOLingua");
        String descrizione = req.getParameter("descrizione");
        int numeroUnita = Integer.parseInt(req.getParameter("numeroUnita"));
        String livello = req.getParameter("livello");
        double prezzoBase = Double.parseDouble(req.getParameter("prezzoBase"));
        double scontoPercentuale = Double.parseDouble(req.getParameter("scontoPercentuale"));

        String address = "corsiAdmin.jsp";

        if(codISOLingua == null || codISOLingua.isBlank() || codISOLingua.length() > 2 || descrizione == null
        || descrizione.isBlank() || numeroUnita <= 0 || livello == null
        || livello.isBlank() || !livello.contains("-") || prezzoBase <=0 || scontoPercentuale < 0) {
            address += "?error=17"; //caricamento nuovo corso fallito
        }

        CorsoDAO corsoDAO = null;

        if(!address.contains("error")) {

            LinguaDAO linguaDAO = new LinguaDAO();

            Lingua l = linguaDAO.doRetrieveById(codISOLingua);

            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria cat = new Categoria();
            cat = categoriaDAO.doRetrieveByName("corso");

            ProdottoDAO prodottoDAO = new ProdottoDAO();
            int idCorso = prodottoDAO.getLastId();

            Corso c = new Corso();

            c.setID(idCorso);
            c.setPrezzoBase(prezzoBase);
            c.setScontoPercentuale(scontoPercentuale);
            c.setLingua(l);
            c.setDescrizione(descrizione);
            c.setNumeroUnita(numeroUnita);
            c.setLivello(livello);
            c.setCategoria(cat);


            //salvo nel db il nuovo prodotto
            prodottoDAO.doSave(c);

            //salvo nel db il nuovo corso associato al prodotto appena creato
            corsoDAO = new CorsoDAO();
            corsoDAO.doSave(c);

            List<Integer> prezziCorsi = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(1);
            getServletContext().setAttribute("prezziCorsi", prezziCorsi);

            address += "?insertion=good";
        }

        List<Corso> corsi = corsoDAO.doRetrieveAll();
        req.setAttribute("corsi", corsi);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
