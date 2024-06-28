package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrazioneEspertoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address;
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String ddn = req.getParameter("ddn");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sesso = req.getParameter("sesso");
        String fotoRiconoscitiva = "";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
