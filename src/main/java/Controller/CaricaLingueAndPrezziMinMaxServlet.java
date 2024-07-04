package Controller;

import Model.Lingua;
import Model.LinguaDAO;
import Model.ProdottoDAO;
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

        ProdottoDAO prodottoDAO = new ProdottoDAO();
        List<Integer> prezziCorsi = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(1);
        getServletContext().setAttribute("prezziCorsi", prezziCorsi);

        //List<Integer> prezziColloqui = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(2);
        //getServletContext().setAttribute("prezziColloqui", prezziColloqui);

        //List<Integer> prezziIncontri = prodottoDAO.doRetrievePrezzoMinMaxByCategoria(3);
        //getServletContext().setAttribute("prezziIncontri", prezziIncontri);

    }
}
