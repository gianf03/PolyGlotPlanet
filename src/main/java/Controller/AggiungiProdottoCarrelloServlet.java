package Controller;

import Model.Bean.*;
import Model.DAO.CarrelloDAO;
import Model.DAO.FormazioneDAO;
import Model.DAO.ProdottoDAO;
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

@WebServlet("/aggiungiProdottoCarrello")
public class AggiungiProdottoCarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        HttpSession session = req.getSession();

        ProdottoDAO prodottoDAO = new ProdottoDAO();

        int idProdotto = 0;
        List<Prodotto> listaProdotti = new ArrayList<>();
        Utente u = null;

        try {
            idProdotto = Integer.parseInt(req.getParameter("ID"));
            Prodotto p = prodottoDAO.doRetrieveById(idProdotto);

            if(p != null) {
                if(session.getAttribute("utente") != null){
                    u = (Utente) session.getAttribute("utente");
                }


                /*utente loggato oppure no faccio le stesse operazioni*/

                /*solo per utente loggato*/
                FormazioneDAO formazioneDAO = new FormazioneDAO();
                CarrelloDAO carrelloDAO = new CarrelloDAO();
                Carrello carrello = null;
                if (u != null) {

                    /*salvo prodotto nel carrello fisico*/
                    carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());

                    /*se l'utente loggato non ha ancora un carrello glielo creo e me lo faccio restituire*/
                    if(carrello == null){
                        carrello = new Carrello();
                        carrello.setUtente(u);
                        carrelloDAO.doSave(carrello);
                        carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());
                    }

                    Formazione formazione = formazioneDAO.doRetrieveByIdProdottoAndIdCarrello(p.getID(),carrello.getId());

                    /*se prodotto non presente nel carrello fisico (formazione == null) lo inserisco
                    altrimenti lo rimuovo*/
                    if(formazione == null) {
                        formazione = new Formazione();
                        formazione.setCarrello(carrello);
                        formazione.setProdotto(p);
                        formazioneDAO.doSave(formazione);
                    } else {
                        formazioneDAO.doRemove(formazione);
                    }
                }

                /*se carrello logico non presente in sessione ne creo uno vuoto e lo inserisco*/
                if (session.getAttribute("carrello") == null) {
                    List<Prodotto> prodotti = new ArrayList<>();
                    session.setAttribute("carrello", prodotti);
                }

                listaProdotti = (List<Prodotto>) session.getAttribute("carrello");


                int posizione = -1;
                for (int i = 0; i < listaProdotti.size(); i++) {
                    if (listaProdotti.get(i).getID() == p.getID()) {
                        posizione = i;
                    }
                }

                if (posizione > -1) {
                    listaProdotti.remove(posizione);
                } else
                    listaProdotti.add(p);


                session.setAttribute("carrello", listaProdotti);

                if(p instanceof Colloquio){
                    resp.sendRedirect("colloqui.jsp");
                } else if (p instanceof Incontro) {
                    resp.sendRedirect("incontri.jsp");
                } else if (p instanceof Corso){
                    resp.sendRedirect("corsi.jsp");
                } else {
                    resp.sendError(404);
                }
            } else {
                resp.sendRedirect("carrello.jsp?error=22"); //prodotto inesistente
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("carrello.jsp?error=22");
        }
    }
}
