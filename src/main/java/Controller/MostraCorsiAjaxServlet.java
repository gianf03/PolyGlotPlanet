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

        if(req.getQueryString().isEmpty() ||
                (parametri.length == 1 && parametri[0].equals("codLingua="))){  //qui prendo tutti i corsi
             codLingua = "";
             corsi = corsoDAO.doRetrieveByCodISOLingua(codLingua);
        } else {   //qui prendo i corsi delle lingue di cui è stato passato il codice
            for(String s : parametri){
                String[] coppia = s.split("=");
                List<Corso> c1 = corsoDAO.doRetrieveByCodISOLingua(coppia[1]);
                corsi.addAll(c1);
            }
        }

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        JSONArray corsiArray = new JSONArray();
        JSONObject all = new JSONObject();
        /*List<Lingua> lingue = (List<Lingua>) getServletContext().getAttribute("lingue");
        for(Lingua l : lingue) {
            if(l.getCodISOLingua().equals(codLingua))
                all.put("foto", l.getFotoStatoOrigine());
        }*/

        for (Corso c : corsi) {
            JSONObject obj = new JSONObject();
            obj.put("codISOLingua", c.getCodISOLingua());
            obj.put("descrizione", c.getDescrizione());
            obj.put("numeroUnita", c.getNumeroUnita());
            obj.put("livello", c.getLivello());
            obj.put("prezzo", c.getPrezzoScontato());
            corsiArray.add(obj);
        }

        all.put("corsi", corsiArray);
        out.print(corsiArray.toJSONString());

        out.flush();
    }
}
