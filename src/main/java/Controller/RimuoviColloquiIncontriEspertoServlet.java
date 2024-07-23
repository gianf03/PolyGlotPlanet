package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Esperto;
import Model.Bean.Incontro;
import Model.Bean.Prodotto;
import Model.DAO.ColloquioDAO;
import Model.DAO.IncontroDAO;
import Model.DAO.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/rimuoviColloquiIncontriEsperto")
public class RimuoviColloquiIncontriEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            int IDProdotto = Integer.parseInt(req.getParameter("IDProdotto"));

            Esperto e = (Esperto) req.getSession().getAttribute("esperto");

            ProdottoDAO prodottoDAO = new ProdottoDAO();
            Prodotto p = prodottoDAO.doRetrieveById(IDProdotto);

            String address = null;
            String catProdotto = null;

            if(p != null) {
                catProdotto = p.getCategoria().getNome();
            }

            List<Colloquio> colloqui = null;
            List<Incontro> incontri = null;

        /*effettuo questo controllo per evitare che un esperto possa digitare l'ID di un
        prodotto corrispondente ad un corso e quindi cancellarlo*/
            if(!catProdotto.equals("corso")) {

                if(catProdotto.equals("colloquio")) {

                    Colloquio c = (Colloquio) p;

                    if(!c.isPrenotato()) {
                        prodottoDAO.doRemove(IDProdotto);
                        address = "colloquiEsperto.jsp?removal=good";
                    } else {
                        address = "colloquiEsperto.jsp?error=27"; //impossibile rimuovere prodotto perchè prenotato
                    }

                    //ricarico la nuova lista di colloqui nella request senza quello eliminato
                    ColloquioDAO colloquioDAO = new ColloquioDAO();
                    colloqui = colloquioDAO.doRetrieveByEsperto(e.getID());
                    req.setAttribute("colloqui", colloqui);
                } else {

                    Incontro i = (Incontro) p;

                    if(!i.isPrenotato()) {
                        prodottoDAO.doRemove(IDProdotto);
                        address = "incontriEsperto.jsp?removal=good";
                    } else {
                        address = "incontriEsperto.jsp?error=27"; //impossibile rimuovere prodotto perchè prenotato
                    }

                    //ricarico la nuova lista di incontri nella request senza quello eliminato
                    IncontroDAO incontroDAO = new IncontroDAO();
                    incontri = incontroDAO.doRetrieveByEsperto(e.getID());
                    req.setAttribute("incontri", incontri);
                }
            }

            RequestDispatcher rd = req.getRequestDispatcher(address);
            rd.forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
