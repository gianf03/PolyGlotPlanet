package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginUtente")
public class LoginUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String address = "index.jsp";
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(email==null || !email.contains("@"))    //controllo che l'utente abbia effettivamente inserito qualcosa nel campo email e che essa presenti la @
            address = "loginUtente.jsp";
        else {

            int indexAt = email.indexOf("@");
            String dominio = email.substring(indexAt);

            if (!dominio.contains(".") || password == null || password.length()<8) {          //controllo che il dominio della mail presenti almeno un punto
                address = "loginUtente.jsp";
            }
        }

        /*PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println(address);
        out.println("<br>email : " + email + "<br>password : " + password);
        out.println("</body></html>");*/
        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
