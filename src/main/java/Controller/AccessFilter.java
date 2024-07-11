package Controller;

import Model.Bean.Esperto;
import Model.Bean.Utente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "/AccessFilter", urlPatterns = "/*")
public class AccessFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        String path = httpServletRequest.getServletPath();

        Utente u = (Utente) httpServletRequest.getSession().getAttribute("utente");
        Esperto e = (Esperto) httpServletRequest.getSession().getAttribute("esperto");

        boolean isAdmin = false, isUser = false, isEsperto = false, isWithoutAccount = false;

        if(u != null && !u.isAdmin())
            isUser = true;
        else if(u != null && u.isAdmin())
            isAdmin = true;

        if(e != null)
            isEsperto = true;

        if(u == null && e == null)
            isWithoutAccount = true;


        if((path.contains("homeAdmin.jsp") || path.contains("corsiAdmin.jsp") || path.contains("espertiAdmin.jsp") ||
                path.contains("utentiAdmin.jsp") || path.contains("ordiniUtente.jsp")) && !isAdmin) {

            if(isEsperto)
                httpServletResponse.sendRedirect("homeEsperto.jsp?error=11");
            else
                httpServletResponse.sendRedirect("index.jsp?error=11");

            return; //interrompe l'esecuzione del filtro
        }

        if(path.contains("homeEsperto.jsp") && !isEsperto) {

            if(isAdmin)
                httpServletResponse.sendRedirect("homeAdmin.jsp?error=11");
            else
                httpServletResponse.sendRedirect("index.jsp?error=11");

            return;
        }

        if(path.contains("areaUtente.jsp") && !isUser) {

            if(isAdmin)
                httpServletResponse.sendRedirect("homeAdmin.jsp?error=11");
            else if(isEsperto)
                httpServletResponse.sendRedirect("homeEsperto.jsp?error=11");
            else
                httpServletResponse.sendRedirect("index.jsp?error=11");

            return;
        }

        if((path.contains("colloqui.jsp") || path.contains("corsi.jsp") || path.contains("incontri.jsp") ||
                path.contains("sceltaCategoria.jsp")) && !isUser && !isWithoutAccount) {

            if(isAdmin)
                httpServletResponse.sendRedirect("homeAdmin.jsp?error=11");
            else
                httpServletResponse.sendRedirect("homeEsperto.jsp?error=11");

            return;
        }

        if(path.contains("index.jsp") && (isAdmin || isEsperto)) {

            httpServletRequest.getSession().invalidate();
            httpServletResponse.sendRedirect("index.jsp?error=16"); //logout forzato

            return;
        }

        if(path.contains("mostraCategorie") && !httpServletRequest.getQueryString().contains("lingua")){
            httpServletResponse.sendRedirect("index.jsp?error=17"); //nessuna lingua selezionata
            return;
        }

        if(path.contains("login") && httpServletRequest.getSession(false) != null){
            httpServletRequest.getSession(false).invalidate(); //non ci vuole return perché mi serve che esegua chain.doFilter()
        }

        chain.doFilter(req, res); //Se il filtro corrente è l'ultimo nella catena, l'istruzione passa il controllo al servlet o alla risorsa web (come una JSP) designata per gestire la richiesta
    }
}
