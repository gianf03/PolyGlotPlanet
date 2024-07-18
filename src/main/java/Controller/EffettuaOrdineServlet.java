package Controller;

import Model.Bean.*;
import Model.DAO.CarrelloDAO;
import Model.DAO.ComposizioneDAO;
import Model.DAO.FormazioneDAO;
import Model.DAO.OrdineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/effettuaOrdine")
public class EffettuaOrdineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        OrdineDAO ordineDAO = new OrdineDAO();
        ComposizioneDAO composizioneDAO = new ComposizioneDAO();
        FormazioneDAO formazioneDAO = new FormazioneDAO();
        CarrelloDAO carrelloDAO = new CarrelloDAO();
        Utente u = (Utente) session.getAttribute("utente");

        Ordine ordine = new Ordine();
        ordine.setDataOra(LocalDateTime.now());
        ordine.setUtente((Utente) session.getAttribute("utente"));

        ordineDAO.doSave(ordine);
        /*prima odine non aveva id, glielo setto quando faccio doSave, quindi me lo riprendo con un doRetrieve*/
        ordine = ordineDAO.doRetrieveLastOrderByIdUtente(u.getID()); /*non può mai restituire null perché l'ordine lo creo poco prima*/

        Carrello carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());
        List<Formazione> formazioniCarrello = formazioneDAO.doRetrieveByIdCarrello(carrello.getId());

        for (Formazione f : formazioniCarrello){
            Composizione c = new Composizione();

            c.setOrdine(ordine);
            c.setProdotto(f.getProdotto());
            c.setPrezzoAcquisto(f.getProdotto().getPrezzoAttualeDouble());

            composizioneDAO.doSave(c);
            formazioneDAO.doRemove(f);
        }
        session.removeAttribute("carrello");

        //carrelloDAO.doRemove(carrello);

        resp.sendRedirect("index.jsp?ordine=effettuato");
    }
}
