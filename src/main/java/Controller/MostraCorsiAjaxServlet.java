package Controller;

import Model.Corso;
import Model.CorsoDAO;
import Model.Lingua;
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
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import org.json.simple.*;
@SuppressWarnings("unchecked")
@WebServlet("/mostraCorsiAjax")
public class MostraCorsiAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] parametri;
        String codLingua;
        CorsoDAO corsoDAO = new CorsoDAO();
        List<Corso> corsi = new ArrayList<Corso>();
        List<Lingua> lingue = (List<Lingua>) getServletContext().getAttribute("lingue");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if(req.getQueryString() == null || req.getQueryString().isEmpty() ||
                    !req.getQueryString().contains("codLingua") || !req.getQueryString().contains("prezzoMin") ||
                    !req.getQueryString().contains("prezzoMax") || !req.getQueryString().contains("livello")){
            JSONObject obj = new JSONObject();
            obj.put("filtro", "incompleto");
            out.print(obj.toJSONString());
            out.flush();
        } else {
            parametri = req.getQueryString().split("&");
            List<String> params = Arrays.asList(parametri);
            List<String> codiciLingue = new ArrayList<>();
            List<Integer> prezzi = new ArrayList<>();
            List<String> livelli = new ArrayList<>();

            for (String p : params) {

                String[] coppia = p.split("=");
                if (coppia[0].equals("codLingua")) {
                    codiciLingue.add(coppia[1]);
                } else if (coppia[0].equals("prezzoMin") || coppia[0].equals("prezzoMax")) {
                    prezzi.add(Integer.parseInt(coppia[1]));
                } else if (coppia[0].equals("livello"))
                    livelli.add(coppia[1]);

            }

            if (codiciLingue.get(0).equals("tutte")) {
                for (Lingua l : lingue)
                    codiciLingue.add(l.getCodISOLingua());
            }

            for (String cod : codiciLingue) {
                for (String liv : livelli) {
                    List<Corso> c1 = corsoDAO.doRetrieveByCodISOLinguaPrezzoMinMaxAndLivello(cod, prezzi.get(0), prezzi.get(1), liv);
                    corsi.addAll(c1);
                }
            }

            JSONArray corsiArray = new JSONArray();

            for (Corso c : corsi) {
                JSONObject obj = new JSONObject();
                obj.put("codISOLingua", c.getCodISOLingua());
                obj.put("descrizione", c.getDescrizione());
                obj.put("numeroUnita", c.getNumeroUnita());
                obj.put("livello", c.getLivello());
                obj.put("prezzo", c.getPrezzoAttuale());

                for (Lingua l : lingue) {
                    if (l.getCodISOLingua().equals(c.getCodISOLingua()))
                        obj.put("foto", l.getFotoStatoOrigine());
                }

                corsiArray.add(obj);
            }

            out.print(corsiArray.toJSONString());

            out.flush();
        }
    }
}
