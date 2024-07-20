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


        //jsp e servlet solo per l'admin
        if((path.contains("homeAdmin.jsp") || path.contains("corsiAdmin.jsp") || path.contains("espertiAdmin.jsp") ||
                path.contains("utentiAdmin.jsp") || path.contains("ordiniUtente.jsp")
                || path.contains("aggiungiCorso") || path.contains("aggiungiLingua")
                || path.contains("modificaCorso") || path.contains("mostraEsperti")
                || path.contains("mostraUtenti") || path.contains("mostraCorsiAdmin")) && !isAdmin) {

            httpServletResponse.sendError(401);

            return; //interrompe l'esecuzione del filtro
        }


        //jsp e servlet solo per l'esperto
        if((path.contains("homeEsperto.jsp") || path.contains("areaEsperto.jsp") ||
                path.contains("aggiungiColloquioEsperto") || path.contains("aggiungiIncontroEsperto") ||
                path.contains("aggiungiRimuoviLinguaEsperto") || path.contains("modificaDatiEsperto") ||
                path.contains("mostraLingueEsperto") || path.contains("rimuoviColloquiIncontriEsperto")) && !isEsperto) {

            httpServletResponse.sendError(401);

            return;
        }

        //jsp e servlet in comune tra admin e esperto
        if((path.contains("colloquiEsperto.jsp") || path.contains("incontriEsperto.jsp") ||
                path.contains("mostraColloquiAdminEsperto") || path.contains("mostraIncontriAdminEsperto")) &&
                (!isAdmin && !isEsperto)) {
            httpServletResponse.sendError(401);

            return;
        }

        //jsp e servlet in comune tra admin e utente loggato
        if(path.contains("mostraOrdiniUtente") && !isAdmin && !isUser) {
            httpServletResponse.sendError(401);

            return;
        }

        //jsp e servlet solo per l'utente loggato
        if((path.contains("areaUtente.jsp") || path.contains("mieiOrdini.jsp") ||
                path.contains("effettuaOrdine") || path.contains("modificaDatiUtente")) && !isUser) {

            httpServletResponse.sendError(401);

            return;
        }

        //jsp e servlet in comune tra utente loggato e non loggato
        if((path.contains("carrello.jsp") || path.contains("colloqui.jsp") || path.contains("corsi.jsp")
                || path.contains("incontri.jsp") || path.contains("index.jsp") ||
                path.contains("sceltaLingua.jsp") || path.contains("aggiungiProdottoCarrello") ||
                path.contains("mostraColloquiAjax") || path.contains("mostraCorsiAjax") ||
                path.contains("mostraIncontriAjax") || path.contains("rimuoviProdottiCarrello"))
                && (!isUser && !isWithoutAccount)) {

            httpServletResponse.sendError(401);

            return;
        }

        if(path.contains("sceltaLingua.jsp") && (httpServletRequest.getQueryString()==null || !httpServletRequest.getQueryString().contains("categoria"))){
            //nessuna categoria selezionata
            httpServletResponse.sendError(401);
            return;
        }

        if(path.contains("sceltaLingua.jsp") && httpServletRequest.getQueryString().contains("categoria")){
            String categoria = httpServletRequest.getParameter("categoria");
            if (!categoria.contains("corso") && !categoria.contains("incontro") && !categoria.contains("colloquio")) {
                httpServletResponse.sendError(404);
                return;
            }
        }

        if(path.contains("colloqui.jsp") || path.contains("corsi.jsp") || path.contains("incontri.jsp")){
            if(httpServletRequest.getQueryString()==null){
                if(path.contains("colloqui.jsp")) {
                    httpServletResponse.sendRedirect(getServletContext().getContextPath() +
                            "/colloqui.jsp?codLingua=all&filtro=false");
                } else if (path.contains("incontri.jsp")){
                    httpServletResponse.sendRedirect(getServletContext().getContextPath() +
                            "/incontri.jsp?codLingua=all&filtro=false");
                } else {
                    httpServletResponse.sendRedirect(getServletContext().getContextPath() +
                            "/corsi.jsp?codLingua=all&filtro=false");
                }
                return;
            } else if (httpServletRequest.getQueryString().isBlank()){
                httpServletResponse.sendError(401);
                return;
            }
        }


        /*la sessione contiene eventualmente il carrello. Se io vado su una pagina di login utente,
         soltanto se sono già loggato come utente o come epserto faccio l'invalidazione altrimenti la sessione corrente mi sta bene
         se vado su login Admin o login Esperto il carrello non mi serve e quindi invalido a prescindere*/
        if(((path.contains("loginUtente") || path.contains("registrazioneUtente")) && (httpServletRequest.getSession(false).getAttribute("utente") != null ||
                httpServletRequest.getSession(false).getAttribute("esperto") != null)) ||
                (path.contains("loginAdmin") || (path.contains("loginEsperto") || path.contains("registrazioneEsperto")) && httpServletRequest.getSession(false) != null)){
            httpServletRequest.getSession(false).invalidate(); //non ci vuole return perché mi serve che esegua chain.doFilter()
        }


        chain.doFilter(req, res); //Se il filtro corrente è l'ultimo nella catena, l'istruzione passa il controllo al servlet o alla risorsa web (come una JSP) designata per gestire la richiesta
    }
}
