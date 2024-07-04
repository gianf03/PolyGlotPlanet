package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet("/registrazioneEsperto")

public class RegistrazioneEspertoServlet extends HttpServlet {
    private static final String CARTELLA_UPLOAD = "upload";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address;
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String ddn = req.getParameter("ddn");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sesso = req.getParameter("sesso");

        Path path = Paths.get("");
        PrintWriter out = resp.getWriter();
        out.println(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
