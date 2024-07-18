package Controller.ajax;

import Model.Bean.Colloquio;
import Model.Bean.Conoscenza;
import Model.Bean.Incontro;
import Model.Bean.Lingua;
import Model.DAO.ColloquioDAO;
import Model.DAO.ConoscenzaDAO;
import Model.DAO.IncontroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/mostraIncontriAjax")
public class MostraIncontriAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] parametri = req.getQueryString().split("&");
        IncontroDAO incontroDAO = new IncontroDAO();
        List<Incontro> incontri = new ArrayList<Incontro>();
        List<Lingua> lingue = (List<Lingua>) getServletContext().getAttribute("lingue");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();


        //se la queryString è null oppure vuota, non c'è il parametro filtro oppure se c'è ma non ha valore true o false
        if(req.getQueryString() == null || req.getQueryString().isEmpty() ||
                req.getParameter("filtro") == null ||

                (!req.getParameter("filtro").equals("true") && !req.getParameter("filtro").equals("false")) ||

                (req.getParameter("filtro").equals("true") && (!req.getQueryString().contains("codLingua") ||
                        !req.getQueryString().contains("prezzoMin") || !req.getQueryString().contains("prezzoMax") ||
                        !req.getQueryString().contains("dataOra") || req.getParameter("codLingua").isBlank() ||
                        req.getParameter("prezzoMin").isBlank() || req.getParameter("prezzoMax").isBlank() ||
                        req.getParameter("dataOra").isBlank())) ||

                (req.getParameter("filtro").equals("false") && (req.getParameter("codLingua") == null ||
                        parametri.length>2))) {

            JSONObject obj = new JSONObject();
            obj.put("filtro", "incompleto");
            out.print(obj.toJSONString());
            out.flush();
        } else {
            List<String> params = Arrays.asList(parametri);
            List<String> codiciLingue = new ArrayList<>();
            List<Integer> prezzi = new ArrayList<>();
            String dataOraStringa = null;
            LocalDateTime dataOra = null;

            if(req.getParameter("filtro").equals("false")){
                for (String p : params) {
                    String[] coppia = p.split("=");
                    if (coppia[0].equals("codLingua")) {
                        codiciLingue.add(coppia[1]);
                    }
                }

                if (codiciLingue.size() == 1 && codiciLingue.get(0).contains("all")){
                    codiciLingue.remove(0);
                    for (Lingua l : lingue){
                        codiciLingue.add(l.getCodISOLingua());
                    }
                }

                for (String cod : codiciLingue) {
                    List<Incontro> i1 = incontroDAO.doRetrieveByCodISOLinguaNonPrenotati(cod);
                    incontri.addAll(i1);
                }
            } else {

                for (String p : params) {

                    String[] coppia = p.split("=");
                    if (coppia[0].equals("codLingua")) {
                        codiciLingue.add(coppia[1]);
                    } else if (coppia[0].equals("prezzoMin") || coppia[0].equals("prezzoMax")) {
                        try {
                            prezzi.add(Integer.parseInt(coppia[1]));
                        }
                        catch (NumberFormatException e) {
                            JSONObject obj = new JSONObject();
                            obj.put("filtro", "incompleto");
                            out.print(obj.toJSONString());
                            out.flush();
                            return;
                        }
                    } else if (coppia[0].equals("dataOra")) {
                        dataOraStringa = coppia[1];
                    }
                }

                JSONObject obj = new JSONObject();
                try {
                    dataOra = LocalDateTime.parse(dataOraStringa);
                    LocalDateTime now = LocalDateTime.now();
                    if (dataOra.isBefore(now)){
                        obj.put("data", "inammissibile");
                        out.print(obj.toJSONString());
                        out.flush();
                        return;
                    }
                } catch (DateTimeParseException e) {
                    obj.put("data", "sbagliata");
                    out.print(obj.toJSONString());
                    out.flush();
                    return;
                }

                if (codiciLingue.size() == 1 && codiciLingue.get(0).contains("all")) {
                    codiciLingue.remove(0);
                    for (Lingua l : lingue) {
                        codiciLingue.add(l.getCodISOLingua());
                    }
                }

                for (String cod : codiciLingue) {
                    List<Incontro> i1 = incontroDAO.doRetrieveByCodISOLinguaPrezzoMinMaxAndDataOra(cod, prezzi.get(0), prezzi.get(1), dataOra);
                    incontri.addAll(i1);
                }
            }

            JSONArray incontriArray = new JSONArray();

            for (Incontro i : incontri) {
                ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();
                List<Conoscenza> conoscenze = conoscenzaDAO.doRetrieveByIDEsperto(i.getEsperto().getID());
                String lingueConosciute = "";

                for (Conoscenza con : conoscenze) {
                    lingueConosciute += con.getLingua().getNome() + ", ";
                }
                lingueConosciute = lingueConosciute.substring(0, lingueConosciute.length()-2);

                JSONObject obj = new JSONObject();

                obj.put("id", i.getID());
                obj.put("nomeLingua", i.getLingua().getNome());

                obj.put("nomeEsperto", i.getEsperto().getNome());
                obj.put("cognomeEsperto", i.getEsperto().getCognome());

                DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String ddn = i.getEsperto().getDataNascita().format(dateFormatter1);
                obj.put("dataNascitaEsperto", ddn); /*occorre convertire data in stringa altrimenti errore nella lettura del JSON*/

                obj.put("valutazioneEsperto", i.getEsperto().getValutazione());
                obj.put("fotoEsperto", i.getEsperto().getFotoRiconoscitiva());
                obj.put("prezzoOrario", i.getPrezzoAttuale());

                DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                String dataColloquio = i.getDataOra().format(dateFormatter2);
                obj.put("dataOra", dataColloquio);

                obj.put("lingueConosciute", lingueConosciute);

                String indirizzo = i.getVia() + " " + i.getCivico() + ", " + i.getCAP();
                obj.put("indirizzo", indirizzo);

                incontriArray.add(obj);
            }

            out.print(incontriArray.toJSONString());
            out.flush();
        }
    }
}
