package Controller.loginLogoutRegistrazione;

import Model.Bean.Utente;
import Model.DAO.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = null;
        String address = "loginAdmin.jsp?";
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


        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = utenteDAO.doRetrieveByEmailAndPassword(email, password);
        if (utente == null || !utente.isAdmin())
            address += "error=14&"; //e-mail e/o password errata

        address = address.substring(0, address.length()-1);

        if(!address.contains("error") && utente.isAdmin()) {
            session = req.getSession();
            session.invalidate(); //se mentre mi sono loggato come utente o esperto tento di loggarmi come admin invalido la sessione con utente o esperto

            session = req.getSession();
            session.setAttribute("utente", utente);
            address = "homeAdmin.jsp";
        }


        /*PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println(address);
        out.println("<br>"+ req.getAttribute("address"));
        out.println("</body></html>");
        */

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
