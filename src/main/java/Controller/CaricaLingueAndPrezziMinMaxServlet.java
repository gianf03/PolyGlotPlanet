package Controller;

import Model.CorsoDAO;
import Model.Lingua;
import Model.LinguaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.util.List;

@WebServlet(value = "/initLingue", loadOnStartup = 0)
public class CaricaLingueAndPrezziMinMaxServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        LinguaDAO linguaDAO = new LinguaDAO();
        List<Lingua> lingue = linguaDAO.doRetrieveAll();
        getServletContext().setAttribute("lingue", lingue);

        CorsoDAO corsoDAO = new CorsoDAO();
        List<Integer> prezziCorsi = corsoDAO.doRetrievePrezzoMinMax();
        getServletContext().setAttribute("prezziCorsi", prezziCorsi);

        //ColloquioDAO colloquioDAO = new ColloquioDAO();
        //List<Integer> prezziColloqui = colloquioDAO.doRetrievePrezzoMinMax();
        //getServletContext().setAttribute("prezziColloqui", prezziColloqui);

        //IncontroDAO incontroDAO = new IncontroDAO();
        //List<Integer> prezziIncontri = incontroDAO.doRetrievePrezzoMinMax();
        //getServletContext().setAttribute("prezziIncontri", prezziIncontri);

        System.out.println(prezziCorsi.get(0));
    }
}
