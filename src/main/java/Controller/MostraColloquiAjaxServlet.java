package Controller;

import Model.Bean.Colloquio;
import Model.Bean.Corso;
import Model.Bean.Lingua;
import Model.DAO.ColloquioDAO;
import Model.DAO.CorsoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/mostraColloquiAjax")
public class MostraColloquiAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] parametri;
        ColloquioDAO colloquioDAO = new ColloquioDAO();
        List<Colloquio> colloqui = new ArrayList<Colloquio>();
        List<Lingua> lingue = (List<Lingua>) getServletContext().getAttribute("lingue");

        parametri = req.getQueryString().split("&");
        List<String> params = Arrays.asList(parametri);
        List<String> codiciLingue = new ArrayList<>();
        //List<Integer> prezzi = new ArrayList<>();
        //List<String> livelli = new ArrayList<>();

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        for (String p : params) {

            String[] coppia = p.split("=");
            if (coppia[0].equals("codLingua")) {
                codiciLingue.add(coppia[1]);
            } /*else if (coppia[0].equals("prezzoMin") || coppia[0].equals("prezzoMax")) {
                prezzi.add(Integer.parseInt(coppia[1]));
            } else if (coppia[0].equals("livello"))
                livelli.add(coppia[1]);
*/
        }

        /*if (codiciLingue.size() == 1 && codiciLingue.get(0).equals("tutte")) {
            for (Lingua l : lingue)
                codiciLingue.add(l.getCodISOLingua());
        }*/

        /*for (String cod : codiciLingue) {
            for (String liv : livelli) {
                List<Corso> c1 = corsoDAO.doRetrieveByCodISOLinguaPrezzoMinMaxAndLivello(cod, prezzi.get(0), prezzi.get(1), liv);
                corsi.addAll(c1);
            }
        }*/

        if (codiciLingue.size() == 1 && codiciLingue.get(0).contains("all")){
            codiciLingue.remove(0);
            for (Lingua l : lingue){
                codiciLingue.add(l.getCodISOLingua());
            }
        }


        colloqui = colloquioDAO.doRetrieveByStartAndEnd(codiciLingue, 0, 100);

        //resp.setContentType("text/html");
        //PrintWriter out = resp.getWriter();
        //out.println(colloqui.size());

        JSONArray colloquiArray = new JSONArray();

        for (Colloquio c : colloqui) {
            JSONObject obj = new JSONObject();
            obj.put("codISOLingua", c.getLingua().getCodISOLingua());
            obj.put("ID", c.getID());
            obj.put("prezzoOrario", c.getPrezzoAttuale());

            obj.put("idEsperto", c.getEsperto().getID());
            obj.put("nomeEsperto", c.getEsperto().getNome());
            obj.put("cognomeEsperto", c.getEsperto().getCognome());
            obj.put("fotoEsperto", c.getEsperto().getFotoRiconoscitiva());
            colloquiArray.add(obj);
        }

        out.print(colloquiArray.toJSONString());

        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
