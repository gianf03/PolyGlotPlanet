package Controller;

import Model.Esperto;
import Model.EspertoDAO;
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
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@MultipartConfig
@WebServlet("/registrazioneEsperto")

public class RegistrazioneEspertoServlet extends HttpServlet {
    private static final String CARTELLA_UPLOAD = "img" + File.separator + "esperti";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = "registrazioneEsperto?";
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String ddn = req.getParameter("ddn");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sesso = req.getParameter("sesso");
        LocalDate dataNascita = null;
        Part fotoPart = req.getPart("foto");

        if (nome==null || checkIfStringContainsOnlySpaces(nome)) { address += "error=1&";  /*nome assente*/ }
        if (cognome==null || checkIfStringContainsOnlySpaces(cognome)){address += "error=2&"; /*cognome assente*/}

        if (email==null){
            address += "error=3&"; /*email assente*/
        } else if (!email.contains("@")){
            address += "error=4&"; //email non conforme
        } else {
            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".")) {
                address += "error=4&";
            }
        }

        if (password==null) {
            address += "error=5&"; //password assente
        } else if (password.length()<8){
            address += "error=6&"; //password troppo corta
        }

        if (sesso==null || (!sesso.equals("M") && !sesso.equals("F"))){address += "error=7&"; /*genere non previsto*/}

        //if (fotoPart == null || fotoPart.getSize()<1) {address+= "error=13&"; /*immagine non caricata*/}

        //PrintWriter out = resp.getWriter();
        //out.println("Contenuto: "+req.getContentType());

        try {
            if (ddn == null){
                address += "error=8&"; /*nessuna data di nascita*/
            } else
                dataNascita = LocalDate.parse(ddn);
        }
        catch (DateTimeParseException e) {
            address += "error=9&";  //non è una data di nascita
        }
        catch (Exception e){
            address += "error=13&";
        }
        finally {
            address = address.substring(0, address.length() - 1);

            if (!address.contains("error")) {

                EspertoDAO espertoDAO = new EspertoDAO();
                int id = espertoDAO.getNextId();

                String nomeOriginale = Paths.get(fotoPart.getSubmittedFileName()).getFileName().toString();
                int lastIndex = nomeOriginale.lastIndexOf('.');
                String estensione = nomeOriginale.substring(lastIndex + 1);

                String fileName = id + "." + estensione;
                String destinazione = CARTELLA_UPLOAD + File.separator + fileName;

                Path pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));
                /*String currentDirectory = System.getProperty("user.dir");
                Path currentPath = Paths.get(currentDirectory);
                Path parentPath = currentPath.getParent();
                Path webappPath = parentPath.resolveSibling("webapp");
                Path pathDestinazione = webappPath.resolve(destinazione);*/

                //PrintWriter out = resp.getWriter();
                //out.println("Percroso : " + Paths.get(getRealPath));

                InputStream fileInputStream = fotoPart.getInputStream();

                // crea CARTELLA_UPLOAD, se non esiste
                Files.createDirectories(pathDestinazione.getParent());

                // scrive il file
                Files.copy(fileInputStream, pathDestinazione);

                Esperto e = new Esperto();

                e.setNome(nome);
                e.setCognome(cognome);
                e.setEmail(email);
                e.setPassword(password);
                e.setGenere(sesso);
                e.setFotoRiconoscitiva(destinazione);
                e.setDataNascita(dataNascita);

                espertoDAO.doSave(e);
                address = "homeEsperto.jsp";
            }
        }


        resp.sendRedirect(address);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private boolean checkIfStringContainsOnlySpaces(String s) {

        //restituisce true se la stringa s contiene soltanto spazi vuoti

        boolean flag = true;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) != ' ') {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
