package Controller;

import Model.Lingua;
import Model.LinguaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.util.List;

@WebServlet(value = "/initLingue", loadOnStartup = 0)
public class CaricaLingueServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        LinguaDAO linguaDAO = new LinguaDAO();

        List<String> lingue = linguaDAO.doRetrieveFoto();

        getServletContext().setAttribute("lingue", lingue);
    }
}
