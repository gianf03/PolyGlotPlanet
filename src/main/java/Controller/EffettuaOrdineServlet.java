package Controller;

import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.DAO.ComposizioneDAO;
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

@WebServlet("/effettuaOrdine")
public class EffettuaOrdineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        OrdineDAO ordineDAO = new OrdineDAO();
        ComposizioneDAO composizioneDAO = new ComposizioneDAO();

        Ordine ordine = new Ordine();
        ordine.setDataOra(LocalDateTime.now());
        ordine.setUtente((Utente) session.getAttribute("utente"));

        ordineDAO.doSave(ordine);


    }
}
