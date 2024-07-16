package Controller;

import Model.DAO.ConoscenzaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/aggiungiRimuoviLinguaEsperto")
public class AggiungiRimuoviLinguaEspertoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        int IDEsperto = Integer.parseInt(req.getParameter("IDEsperto"));
        String codISOLingua = req.getParameter("codISOLingua");
        String operation = req.getParameter("operation");

        String address = "homeEsperto.jsp";

        if(codISOLingua != null && !codISOLingua.isBlank()) {

            ConoscenzaDAO conoscenzaDAO = new ConoscenzaDAO();

            if(operation.equals("add")) {
                conoscenzaDAO.doSave(IDEsperto, codISOLingua);
            } else if(operation.equals("del")) {
                conoscenzaDAO.doUpdate(IDEsperto, codISOLingua);
            }
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
