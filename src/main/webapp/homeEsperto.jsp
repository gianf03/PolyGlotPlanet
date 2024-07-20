<%@ page import="Model.Bean.Conoscenza" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" href="css/utenteLoggatoEsperto.css" rel="stylesheet">
    <script src="JavaScript/utility.js"></script>
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>

    <%

        if(request.getQueryString() != null && request.getQueryString().contains("error=24")){%>
            <script>alert("Non puoi accedere a questa pagina!")</script>
        <%}

        Esperto esp = (Esperto) session.getAttribute("esperto");

        /*conoscenze è valorizzato solo quando l'esperto clicca su le mie lingue (viene richiamata la servlet mostraLingueEsperto)
        altrimenti è null (la servlet restituisce almeno una lista con size 0 anzichè null)*/

        List<Conoscenza> conoscenze = (List<Conoscenza>) request.getAttribute("conoscenzeEsp");
        List<Lingua> lingueNonConosciute = (List<Lingua>) request.getAttribute("lingueNonConosciute");

        String op = request.getParameter("op");

        if(op != null) {
            if(op.equals("insertion")) { %>
                <script>alert("Inserimento avvenuto con successo!")</script>
            <%} else if(op.equals("removal")){ %>
                <script>alert("Rimozione avvenuta con successo!")</script>
            <%}
        }%>

    <div id="containerOfAll" class="containerOfAllHomeEsperto">

        <div id="containerEsperto">
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="colloquio stilizzato" src="img/categorie/colloquio.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraColloquiAdminEsperto?IDEsperto=<%=esp.getID()%>">I miei colloqui</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="incontro stilizzato" src="img/categorie/incontro.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraIncontriAdminEsperto?IDEsperto=<%=esp.getID()%>">I miei incontri</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="lingua stilizzata" src="img/lingua.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraLingueEsperto">Le mie lingue</a>
                </div>
            </div>
        </div>


        <%if(request.getQueryString() != null && request.getQueryString().contains("lingue=open")) { %>

            <div id="divListaConoscenze">

                <table id="tableLingue">
                    <tr id="rigaLingue">
                        <th>ID</th>
                        <th>Lingua</th>
                    </tr>

                    <%for(Conoscenza c : conoscenze) {%>
                    <tr class="rigaLingue">
                        <td><%=c.getLingua().getCodISOLingua()%></td>
                        <td><%=c.getLingua().getNome()%></td>
                        <td><img id="imgLingua" alt="immagine stato origine lingua" src="<%=c.getLingua().getFotoStatoOrigine()%>"></td>
                        <td>
                            <button class="btn" id="btnRimuovi" onclick="document.location='aggiungiRimuoviLinguaEsperto?codISOLingua=<%=c.getLingua().getCodISOLingua()%>&operation=del'">Rimuovi
                            </button>
                        </td>
                    </tr>
                    <%}%>
                </table>

                <button class="btn" id="btnAggiungiLingua" onclick="showElemById('divAggiungiLingua')">Aggiungi lingua</button>
                <button class="btn" id="btnChiudiLista" onclick="hideElemById('divListaConoscenze'); hideElemById('divAggiungiLingua');">Chiudi</button>
            </div>

            <div id="divAggiungiLingua">
                <form id="formLingua" action="aggiungiRimuoviLinguaEsperto?operation=add" method="POST">
                    <label for="formLingua">Seleziona una lingua:</label><br>
                    <select name="codISOLingua">
                        <%for(Lingua l : lingueNonConosciute) {%>
                        <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                        <%}%>
                    </select>
                    <input class="btn" id="btnConferma" type="submit" value="Conferma">
                </form>
            </div>

        <%}%>

    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
