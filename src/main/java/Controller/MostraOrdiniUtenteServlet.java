package Controller;

import Model.Bean.Composizione;
import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.DAO.ComposizioneDAO;
import Model.DAO.OrdineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mostraOrdiniUtente")
public class MostraOrdiniUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String address;
        HttpSession session = req.getSession(false);
        Utente u = (Utente) session.getAttribute("utente");

        if(u.isAdmin()){
            address = "ordiniUtente.jsp";
        } else {
            address = "mieiOrdini.jsp";
        }

        resp.setContentType("text/html");

        List<Ordine> ordini = null;
        OrdineDAO ordineDAO = new OrdineDAO();;

        if(!req.getParameter("IDUtente").equals("all")) {
            int IDUtente = Integer.parseInt(req.getParameter("IDUtente"));

            //fare controlli sul valore di IDUtente
            ordini = ordineDAO.doRetrieveAllByUtente(IDUtente);
        } else if(u.isAdmin()){ /*controllo necessario per evitare che se un utente semplice digita IDUtente=all possa avere accesso agli ordini di tutti gli altri utenti*/
            address+="?IDUtente=all";
            ordini = ordineDAO.doRetrieveAll();
        }

        req.setAttribute("ordini", ordini);

        /*per ogni ordine, ho una lista di composizioni, quindi avrò una lista di liste di composizioni*/
        ComposizioneDAO composizioneDAO = new ComposizioneDAO();
        List<List<Composizione>> listaComposizioniOrdini = new ArrayList<>();

        for (Ordine o : ordini) {
            listaComposizioniOrdini.add(composizioneDAO.doRetrieveAllByOrdine(o.getID()));
        }
        req.setAttribute("listaComposizioniOrdini", listaComposizioniOrdini);

        RequestDispatcher rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
