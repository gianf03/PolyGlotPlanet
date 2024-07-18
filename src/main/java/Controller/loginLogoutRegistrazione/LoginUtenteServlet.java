package Controller.loginLogoutRegistrazione;

import Model.Bean.Carrello;
import Model.Bean.Formazione;
import Model.Bean.Prodotto;
import Model.Bean.Utente;
import Model.DAO.CarrelloDAO;
import Model.DAO.ComposizioneDAO;
import Model.DAO.FormazioneDAO;
import Model.DAO.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginUtente")
public class LoginUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        HttpSession session = null;
        String address = "loginUtente.jsp?";
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
        if (utente == null || utente.isAdmin())
            address += "error=14&"; //e-mail o password errata

        address = address.substring(0, address.length()-1);

        //PrintWriter out = resp.getWriter();

        if(!address.contains("error") && !utente.isAdmin()) {
            session = req.getSession();
            session.setAttribute("utente", utente);
            address = "index.jsp";

            List<Prodotto> prodottiCarrelloLogico = (List<Prodotto>) session.getAttribute("carrello");
            FormazioneDAO formazioneDAO = new FormazioneDAO();
            CarrelloDAO carrelloDAO = new CarrelloDAO();

            Utente u = (Utente) session.getAttribute("utente");
            Carrello carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());

            if(carrello == null){
                carrello = new Carrello();
                carrello.setUtente(u);
                carrelloDAO.doSave(carrello);
                /*salvo carrello senza id e poi mi prendo carrello con id */
                carrello = carrelloDAO.doRetrieveByIdUtente(u.getID());
            }

            if(prodottiCarrelloLogico!=null){

                ComposizioneDAO composizioneDAO = new ComposizioneDAO();
                for(Prodotto p : prodottiCarrelloLogico){

                    /*se il prodotto in questione non fa già parte del carrello o di un ordine*/
                    if(formazioneDAO.doRetrieveByIdProdottoAndIdCarrello(p.getID(), carrello.getId()) == null  &&
                            composizioneDAO.doRetrieveByIdProdottoAndIdUtente(p.getID(), u.getID()) == null) {
                        //out.println(p.getID() + "non appartiene a carrello fisico");

                        Formazione formazione = new Formazione();
                        formazione.setProdotto(p);
                        formazione.setCarrello(carrello);

                        //out.println("idCarrello : "+carrello.getId() + "\nidProdtto : "+p.getID()+"\n\n");

                        formazioneDAO.doSave(formazione);
                    }
                }
            }

            List<Formazione> formazioni = formazioneDAO.doRetrieveByIdCarrello(carrello.getId());
            List<Prodotto> prodottiCarrelloFisico = new ArrayList<>();
            for(Formazione f : formazioni) {
                prodottiCarrelloFisico.add(f.getProdotto());
            }
            session.setAttribute("carrello", prodottiCarrelloFisico);
        }

        resp.sendRedirect(address);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
