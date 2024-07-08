package Controller;

import Model.EspertoDAO;
import Model.Esperto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/loginEsperto")
public class LoginEspertoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = null;
        String address = "homeEsperto.jsp";
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(email==null || !email.contains("@"))    //controllo che l'esperto abbia effettivamente inserito qualcosa nel campo email e che essa presenti la @
            address = "loginEsperto.jsp?error=1";
        else {

            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".") || password == null || password.length()<8) {          //controllo che il dominio della mail presenti almeno un punto
                address = "loginEsperto.jsp?error=1";
            } else {
                EspertoDAO espertoDAO = new EspertoDAO();
                Esperto esperto = espertoDAO.doRetrieveByEmailAndPassword(email, password);
                if (esperto == null)
                    address = "loginEsperto.jsp?error=1";
                else {
                    session = req.getSession();
                    session.setAttribute("esperto", esperto);
                }
            }
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
