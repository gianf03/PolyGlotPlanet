package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Incontro;
import Model.Bean.Prodotto;
import Model.DAO.ProdottoDAO;
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

        Prodotto p = prodottoDAO.doRetrieveById(idProdotto);

        if (session.getAttribute("utente") == null){

            if(session.getAttribute("carrello") == null) {
                List<Prodotto> prodotti = new ArrayList<>();
                session.setAttribute("carrello", prodotti);
            }

            if(p!=null){
                listaProdotti = (List<Prodotto>) session.getAttribute("carrello");

                int posizione = -1;
                for(int i=0; i<listaProdotti.size(); i++){
                    if (listaProdotti.get(i).getID() == p.getID()) {
                        posizione = i;
                    }
                }

                if(posizione>-1)
                    listaProdotti.remove(posizione);
                else
                    listaProdotti.add(p);


                session.setAttribute("carrello", listaProdotti);
            }
        }

        /*PrintWriter out = resp.getWriter();
        for(Prodotto p : listaProdotti)
            out.println(p.getPrezzoAttuale()+"€");
*/
        if(p instanceof Colloquio){
            resp.sendRedirect("colloqui.jsp");
        } else if (p instanceof Incontro) {
            resp.sendRedirect("incontri.jsp");
        } else {
            resp.sendRedirect("corsi.jsp");
        }
    }
}
