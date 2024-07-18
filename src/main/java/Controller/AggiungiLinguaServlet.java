package Controller;

import Model.Bean.Lingua;
import Model.DAO.LinguaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@MultipartConfig
@WebServlet("/aggiungiLingua")
public class AggiungiLinguaServlet extends HttpServlet {

    private static final String CARTELLA_UPLOAD = "img" + File.separator + "stati";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String codISOLingua = req.getParameter("codISOLingua");
        String nome = req.getParameter("nomeLingua");
        int numParlanti = Integer.parseInt(req.getParameter("parlanti"));
        Part imgLingua = req.getPart("fotoStatoOrigine");

        String address = "homeAdmin.jsp";

        if(codISOLingua == null || codISOLingua.isBlank() || codISOLingua.length() > 2 || nome == null
            || nome.isBlank() || numParlanti <= 0 || imgLingua == null) {
            address += "?error=18"; //caricamento della lingua non avvenuto
        }

        if(!address.contains("error")) {

            String nomeOriginale = Paths.get(imgLingua.getSubmittedFileName()).getFileName().toString();
            int lastIndex = nomeOriginale.lastIndexOf('.');
            String estensione = nomeOriginale.substring(lastIndex + 1);

            String fileName = nome + "." + estensione;
            String destinazione = CARTELLA_UPLOAD + File.separator + fileName;

            Path pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));

            InputStream fileInputStream = imgLingua.getInputStream();

            // crea CARTELLA_UPLOAD, se non esiste
            Files.createDirectories(pathDestinazione.getParent());

            // scrive il file
            Files.copy(fileInputStream, pathDestinazione);

            Lingua l = new Lingua();
            l.setCodISOLingua(codISOLingua);
            l.setNome(nome);
            l.setParlanti(numParlanti);
            l.setFotoStatoOrigine(destinazione);

            LinguaDAO linguaDAO = new LinguaDAO();
            linguaDAO.doSave(l);

            List<Lingua> lingue = linguaDAO.doRetrieveAll();
            getServletContext().setAttribute("lingue", lingue);

            address += "?insertion=good";
        }

        resp.sendRedirect(address);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
