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
        String address = "loginEsperto.jsp?";
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email==null || email.isEmpty()){
            address += "error=3&"; /*email assente*/
        } else if (!email.contains("@")){
            address += "error=4&"; //email non conforme
        } else {
            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".")) {
                address += "error=4&";
            }
        }

        if (password==null || password.isEmpty()) {
            address += "error=5&"; //password assente
        } else if (password.length()<8){
            address += "error=6&"; //password troppo corta
        }

        EspertoDAO espertoDAO = new EspertoDAO();
        Esperto esperto = espertoDAO.doRetrieveByEmailAndPassword(email, password);
        if (esperto == null)
            address += "error=15&"; //esperto non registrato


        address = address.substring(0, address.length()-1);

        if(!address.contains("error")) {
            session = req.getSession();
            session.invalidate(); //se mentre mi sono loggato come utente o admin tento di loggarmi come esperto invalido la sessione con utente o admin

            session = req.getSession();
            session.setAttribute("esperto", esperto);
            address = "homeEsperto.jsp";
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
