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
        HttpSession session = req.getSession();

        ProdottoDAO prodottoDAO = new ProdottoDAO();

        int idProdotto = Integer.parseInt(req.getParameter("ID"));
        List<Prodotto> listaProdotti = new ArrayList<>();
        Utente u = null;

        Prodotto p = prodottoDAO.doRetrieveById(idProdotto);

        if(session.getAttribute("utente") != null){
            u = (Utente) session.getAttribute("utente");
        }


        /*utente loggato o non faccio le stesse operazioni*/
        if(p!=null) {

            /*solo per utente loggato*/
            FormazioneDAO formazioneDAO = new FormazioneDAO();
            CarrelloDAO carrelloDAO = new CarrelloDAO();
            Carrello carrello = null;
            if (u != null) {

                /*salvo prodotto nel carrello fisico*/
                carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());

                /*se l'utente loggato non ha ancora un carrello*/
                if(carrello == null){
                    carrello = new Carrello();
                    carrello.setUtente(u);
                    carrelloDAO.doSave(carrello);
                }

                Formazione formazione = formazioneDAO.doRetrieveByIdProdottoAndIdCarrello(p.getID(),carrello.getId());

                if(formazione == null) {
                    formazione = new Formazione();
                    formazione.setCarrello(carrello);
                    formazione.setProdotto(p);
                    formazioneDAO.doSave(formazione);
                } else {
                    formazioneDAO.doRemove(formazione);
                }
            }


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
        }

        if(p instanceof Colloquio){
            resp.sendRedirect("colloqui.jsp");
        } else if (p instanceof Incontro) {
            resp.sendRedirect("incontri.jsp");
        } else if (p instanceof Corso){
            resp.sendRedirect("corsi.jsp");
        } else {
            resp.sendError(404);
        }
    }
}
