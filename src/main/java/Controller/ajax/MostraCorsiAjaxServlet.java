package Controller.ajax;

import Model.Bean.Colloquio;
import Model.Bean.Corso;
import Model.DAO.CorsoDAO;
import Model.Bean.Lingua;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.*;
@SuppressWarnings("unchecked")
@WebServlet("/mostraCorsiAjax")
public class MostraCorsiAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] parametri = req.getQueryString().split("&");
        String codLingua;
        CorsoDAO corsoDAO = new CorsoDAO();
        List<Corso> corsi = new ArrayList<Corso>();
        List<Lingua> lingue = (List<Lingua>) getServletContext().getAttribute("lingue");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if(req.getQueryString() == null || req.getQueryString().isEmpty() ||
                req.getParameter("filtro") == null ||

                (!req.getParameter("filtro").equals("true") && !req.getParameter("filtro").equals("false")) ||

                (req.getParameter("filtro").equals("true") && (!req.getQueryString().contains("codLingua") ||
                !req.getQueryString().contains("prezzoMin") || !req.getQueryString().contains("prezzoMax") ||
                !req.getQueryString().contains("livello")  || req.getParameter("prezzoMin").isBlank() ||
                req.getParameter("prezzoMax").isBlank())) ||

                (req.getParameter("filtro").equals("false") && (req.getParameter("codLingua") == null ||
                parametri.length>2))) {

            JSONObject obj = new JSONObject();
            obj.put("filtro", "incompleto");
            out.print(obj.toJSONString());
            out.flush();
        } else {
            List<String> params = Arrays.asList(parametri);
            List<String> codiciLingue = new ArrayList<>();
            List<Integer> prezzi = new ArrayList<>(Arrays.asList(0, 0));;
            List<String> livelli = new ArrayList<>();


            if(req.getParameter("filtro").equals("false")) {
                for (String p : params) {
                    String[] coppia = p.split("=");
                    if (coppia[0].equals("codLingua"))
                        codiciLingue.add(coppia[1]);
                }

                if (codiciLingue.size() == 1 && codiciLingue.get(0).equals("all")) {
                    codiciLingue.remove(0);
                    for (Lingua l : lingue)
                        codiciLingue.add(l.getCodISOLingua());
                }

                for (String cod : codiciLingue) {
                    List<Corso> c1 = corsoDAO.doRetrieveByCodISOLinguaDisponibili(cod);
                    corsi.addAll(c1);
                }
            } else {
                for (String p : params) {

                    String[] coppia = p.split("=");
                    if (coppia[0].equals("codLingua")) {
                        codiciLingue.add(coppia[1]);
                    } else if (coppia[0].equals("prezzoMin") || coppia[0].equals("prezzoMax")) {
                        try {
                            if(coppia[0].equals("prezzoMin"))
                                prezzi.add(0, Integer.parseInt(coppia[1]));
                            else
                                prezzi.add(1, Integer.parseInt(coppia[1]));
                        }
                        catch (NumberFormatException e) {
                            JSONObject obj = new JSONObject();
                            obj.put("filtro", "incompleto");
                            out.print(obj.toJSONString());
                            out.flush();
                            return;
                        }

                        if(prezzi.get(1) <= prezzi.get(0)) {
                            JSONObject obj = new JSONObject();
                            obj.put("filtro", "incompleto");
                            out.print(obj.toJSONString());
                            out.flush();
                        }
                    } else if (coppia[0].equals("livello"))
                        livelli.add(coppia[1]);

                }

                if (codiciLingue.size() == 1 && codiciLingue.get(0).equals("all")) {
                    codiciLingue.remove(0);
                    for (Lingua l : lingue)
                        codiciLingue.add(l.getCodISOLingua());
                }

                /*aggiungere check disponibile a true nel DAO*/
                for (String cod : codiciLingue) {
                    for (String liv : livelli) {
                        List<Corso> c1 = corsoDAO.doRetrieveByCodISOLinguaPrezzoMinMaxAndLivello(cod, prezzi.get(0), prezzi.get(1), liv);
                        corsi.addAll(c1);
                    }
                }
            }

            JSONArray corsiArray = new JSONArray();

            for (Corso c : corsi) {
                JSONObject obj = new JSONObject();
                obj.put("id", c.getID());
                obj.put("codISOLingua", c.getLingua().getCodISOLingua());
                obj.put("nomeLingua", c.getLingua().getNome());
                obj.put("descrizione", c.getDescrizione());
                obj.put("numeroUnita", c.getNumeroUnita());
                obj.put("livello", c.getLivello());
                obj.put("prezzo", c.getPrezzoAttuale());
                obj.put("fotoLingua", c.getLingua().getFotoStatoOrigine());

                corsiArray.add(obj);
            }

            out.print(corsiArray.toJSONString());

            out.flush();
        }
    }
}
