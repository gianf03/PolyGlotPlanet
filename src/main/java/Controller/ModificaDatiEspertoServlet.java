package Controller;

import Model.Bean.Esperto;
import Model.DAO.EspertoDAO;
import Utils.Utility;
import jakarta.servlet.ServletException;
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

@WebServlet("/modificaDatiEsperto")
public class ModificaDatiEspertoServlet extends HttpServlet {

    private static final String CARTELLA_UPLOAD = "img" + File.separator + "esperti";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String nome = req.getParameter("nomeEsp");
        String cognome = req.getParameter("cognomeEsp");
        String newPassword = req.getParameter("newPassEsp");
        String confNewPassword = req.getParameter("confNewPassEsp");
        Part imgEsperto = req.getPart("imgEsperto");



        String address = "areaEsperto.jsp?";

        Esperto e = (Esperto) req.getSession().getAttribute("esperto");

        if(nome.isEmpty() || Utility.checkIfStringContainsOnlySpaces(nome)) {
            address = address + "error=1&";
        }

        if(cognome.isEmpty() || Utility.checkIfStringContainsOnlySpaces(cognome)) {
            address = address + "error=2&";
        }

        //controllo che la nuova password non sia vuota e abbia almeno 8 caratteri
        if (!newPassword.isEmpty() && newPassword.length() < 8) {
            address = address + "error=6&";
        } else if (!confNewPassword.equals(newPassword)) { //controllo che la nuova password e la sua conferma siano uguali
            address = address + "error=10&"; //password non coincidono
        }

        String pathImgEsperto;

        /*se l'esperto non ha aggiunto una nuova immagine riutilizzo il path di quella gia impostata altrimenti calcolo
        il path della nuova immagine inserita*/
        if(imgEsperto == null) {
            pathImgEsperto = e.getFotoRiconoscitiva();
        } else {

            String nomeOriginale = Paths.get(imgEsperto.getSubmittedFileName()).getFileName().toString();
            int lastIndex = nomeOriginale.lastIndexOf('.');
            String estensione = nomeOriginale.substring(lastIndex + 1);

            String fileName = e.getID() + "." + estensione;
            pathImgEsperto = CARTELLA_UPLOAD + File.separator + fileName;

            Path pathDestinazione = Paths.get(getServletContext().getRealPath(pathImgEsperto));

            InputStream fileInputStream = imgEsperto.getInputStream();

            // crea CARTELLA_UPLOAD, se non esiste
            Files.createDirectories(pathDestinazione.getParent());

            // scrive il file
            Files.copy(fileInputStream, pathDestinazione);
        }


        /*in assenza di errori rimuovo il '?' da address altrimenti rimuovo
        un '&' per come ho progettato i controlli*/
        address = address.substring(0, address.length()-1);

        if(address.equals("areaEsperto.jsp")) {
            EspertoDAO espertoDAO = new EspertoDAO();
            espertoDAO.doUpdate(e.getID(), nome, cognome, newPassword, pathImgEsperto);

            int IDEsperto = e.getID();

            e = espertoDAO.doRetrieveById(IDEsperto);

            req.getSession().setAttribute("esperto", e);
        }


        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
