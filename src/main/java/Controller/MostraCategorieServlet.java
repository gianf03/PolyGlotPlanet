package Controller;

import Model.Bean.Categoria;
import Model.DAO.CategoriaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostraCategorie")
public class MostraCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        String address;

        List<Categoria> categorie = categoriaDAO.doRetrieveAll();

        if(categorie != null) {
            address = "/sceltaCategoria.jsp";
            req.setAttribute("categorie", categorie);
        }
        else
            address = "/sceltaCategoria.jsp";  //percorso a partire da webapp

        rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
