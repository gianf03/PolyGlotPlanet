package Controller;

import Model.Bean.Composizione;
import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.DAO.ComposizioneDAO;
import Model.DAO.OrdineDAO;
import Model.DAO.UtenteDAO;
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
        Utente u = (Utente) req.getSession().getAttribute("utente"); //c'è per forza un utente nella sessione

        if(u.isAdmin()){
            address = "ordiniUtente.jsp";
        } else {
            address = "mieiOrdini.jsp";
        }

        List<Ordine> ordini = null;
        OrdineDAO ordineDAO = new OrdineDAO();;

        try {
            int IDUtente;
            if(!u.isAdmin()){ //semplice utente
                //se nella request c'è IDUtente e non ha valore "all" tento di trasformarlo in intero
                if(req.getParameter("IDUtente") != null) {
                    UtenteDAO utenteDAO = new UtenteDAO();
                    IDUtente = Integer.parseInt(req.getParameter("IDUtente"));

                    if (IDUtente == u.getID())
                        ordini = ordineDAO.doRetrieveAllByUtente(IDUtente);
                    else {
                        address = "index.jsp?error=25";
                    }
                } else {
                    address = "index.jsp?error=25";
                }

            } else { //admin
                if(req.getParameter("IDUtente") != null && req.getParameter("IDUtente").equals("all")){
                    ordini = ordineDAO.doRetrieveAll();
                } else {
                    UtenteDAO utenteDAO = new UtenteDAO();
                    IDUtente = Integer.parseInt(req.getParameter("IDUtente"));

                    if (utenteDAO.doRetrieveById(IDUtente) != null)
                        ordini = ordineDAO.doRetrieveAllByUtente(IDUtente);
                    else {
                        address = "homeAdmin.jsp?error=25";
                    }
                }
            }
        } catch (NumberFormatException e) {
            if(u.isAdmin()) {
                address = "homeAdmin.jsp?error=25";
            }else{
                address = "index.jsp?error=25";
            }
        }

        if(!address.contains("error")) {
            req.setAttribute("ordini", ordini);

            /*per ogni ordine, ho una lista di composizioni, quindi avrò una lista di liste di composizioni*/
            ComposizioneDAO composizioneDAO = new ComposizioneDAO();
            List<List<Composizione>> listaComposizioniOrdini = new ArrayList<>();

            if(ordini != null) {
                for (Ordine o : ordini) {
                    listaComposizioniOrdini.add(composizioneDAO.doRetrieveAllByOrdine(o.getID()));
                }
            }
            req.setAttribute("listaComposizioniOrdini", listaComposizioniOrdini);

            RequestDispatcher rd = req.getRequestDispatcher(address);
            rd.forward(req, resp);
        } else
            resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
