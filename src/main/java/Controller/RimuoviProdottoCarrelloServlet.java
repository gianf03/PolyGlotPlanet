package Controller;

import Model.Bean.Carrello;
import Model.Bean.Formazione;
import Model.Bean.Prodotto;
import Model.Bean.Utente;
import Model.DAO.CarrelloDAO;
import Model.DAO.FormazioneDAO;
import Model.DAO.ProdottoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/rimuoviProdottoCarrello")
public class RimuoviProdottoCarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ProdottoDAO prodottoDAO = new ProdottoDAO();
        int idProdotto;

        String address = "carrello.jsp";

        try{
            idProdotto = Integer.parseInt(req.getParameter("IDProdotto"));
            Prodotto p = prodottoDAO.doRetrieveById(idProdotto);

            if (p == null)
                address += "?error=26"; //impossibile rimuovere elemento dal carrello
            else {
                HttpSession session = req.getSession();
                List<Prodotto> prodotti = (List<Prodotto>) session.getAttribute("carrello");
                int index = -1;

                if (prodotti == null || prodotti.isEmpty()) {
                    address += "?error=26"; //impossibile rimuovere elemento dal carrello
                } else {
                    for (Prodotto prod : prodotti) {
                        index++;
                        if (prod.getID() == p.getID()) {
                            break;
                        }
                    }

                    if (index > -1) {
                        prodotti.remove(index);
                        session.setAttribute("carrello", prodotti);
                    }
                }


                if(!address.contains("error")) {
                    if (session.getAttribute("utente") == null) {
                        if (index == -1) {
                            address += "?error=26"; //impossibile rimuovere elemento dal carrello
                        }
                    } else {
                        Utente u = (Utente) session.getAttribute("utente");

                        CarrelloDAO carrelloDAO = new CarrelloDAO();
                        FormazioneDAO formazioneDAO = new FormazioneDAO();

                        Carrello c = carrelloDAO.doRetrieveByIdUtente(u.getID());
                        if (c != null) {
                            Formazione f = formazioneDAO.doRetrieveByIdProdottoAndIdCarrello(p.getID(), c.getId());
                            if (f != null) {
                                formazioneDAO.doRemove(f);
                            } else
                                address += "?error=26"; //impossibile rimuovere elemento dal carrello
                        } else
                            address += "?error=26"; //impossibile rimuovere elemento dal carrello
                    }
                }
            }
        }
        catch (NumberFormatException e){
            address += "?error=26"; //impossibile rimuovere elemento dal carrello
        }

        resp.sendRedirect(address);
    }
}
