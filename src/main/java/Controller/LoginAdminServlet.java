package Controller;

import Model.Utente;
import Model.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = null;
        String address = "areaAdmin.jsp";
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(email==null || !email.contains("@"))   //controllo che l'utente abbia effettivamente inserito qualcosa nel campo email e che essa presenti la @
            address = "loginAdmin.jsp?error=1";
        else {

            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".") || password == null || password.length()<8) {          //controllo che il dominio della mail presenti almeno un punto
                address = "loginAdmin.jsp?error=1";
            } else {
                UtenteDAO utenteDAO = new UtenteDAO();
                Utente utente = utenteDAO.doRetrieveByEmailAndPassword(email, password);

                if (utente == null)
                    address = "loginAdmin.jsp?error=1";
                else if(utente.isAdmin()){
                    session = req.getSession();
                    session.setAttribute("utente", utente);
                } else {
                    address = "loginAdmin.jsp?error=2";
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
