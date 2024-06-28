package Controller;

import Model.Corso;
import Model.CorsoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.*;
@SuppressWarnings("unchecked")
@WebServlet("/mostraCorsiAjax")
public class MostraCorsiAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lingua = req.getParameter("lingua");

        CorsoDAO corsoDAO = new CorsoDAO();

        if(lingua == null) lingua = "1";

        List<Corso> corsi = corsoDAO.doRetrieveByCodISOLingua(lingua);


        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();


        JSONObject result = new JSONObject();
        JSONArray corsiArray = new JSONArray();

        for (Corso c : corsi) {
            JSONObject obj = new JSONObject();
            obj.put("codISOLingua", c.getCodISOLingua());
            obj.put("descrizione", c.getDescrizione());
            corsiArray.add(obj);
        }

        result.put("corsi", corsiArray);
        out.print(result.toJSONString());

        out.flush();
    }
}
