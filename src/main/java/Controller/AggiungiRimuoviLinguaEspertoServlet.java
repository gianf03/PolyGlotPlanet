package Controller;

import Model.Bean.Conoscenza;
import Model.Bean.Esperto;
import Model.Bean.Lingua;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.LinguaDAO;
import Model.DAO.ProdottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/aggiungiRimuoviLinguaEsperto")
public class AggiungiRimuoviLinguaEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");
        String codISOLingua = req.getParameter("codISOLingua");
        String operation = req.getParameter("operation");

        String address = "homeEsperto.jsp";

        if(codISOLingua != null && !codISOLingua.isBlank()) {

            ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();

            if(operation.equals("add")) {

                LinguaDAO linguaDAO = new LinguaDAO();
                Lingua l = linguaDAO.doRetrieveById(codISOLingua);

                if(l != null) {

                    Conoscenza conoscenza = new Conoscenza();
                    conoscenza.setLingua(l);
                    conoscenza.setEsperto(e);

                    conoscenzaDAO.doSave(conoscenza);
                    address += "?op=insertion";
                } else {
                    address += "?error=21"; //lingua inesistente
                }
            } else if(operation.equals("del")) {
                conoscenzaDAO.doUpdate(e.getID(), codISOLingua);
                address += "?op=removal";
            }
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
