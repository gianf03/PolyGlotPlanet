<%@ page import="Model.Bean.Conoscenza" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <script src="JavaScript/showElemById.js"></script>
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>

    <%
        Esperto esp = (Esperto) session.getAttribute("esperto");
        List<Conoscenza> conoscenze = (List<Conoscenza>) request.getAttribute("conoscenzeEsp");
        List<Lingua> lingueNonConosciute = (List<Lingua>) request.getAttribute("lingueNonConosciute");
    %>

    <div class="containerOfAll">

        <div id="containerEsperto">
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="colloquio stilizzato" src="img/categorie/colloquio.png">
                </div>

                <div class="settingsLink">
                    <a href="colloquio?IDEsperto=<%=esp.getID()%>">I miei colloqui</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="incontro stilizzato" src="img/categorie/incontro.png">
                </div>

                <div class="settingsLink">
                    <a href="incontro?IDEsperto=<%=esp.getID()%>">I miei incontri</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="lingua stilizzata" src="img/lingua.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraLingueEsperto?IDEsperto=<%=esp.getID()%>">Le mie lingue</a>
                </div>
            </div>
        </div>

        <%if(conoscenze != null) { %>

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
                            <button id="btnRimuovi" onclick="document.location='aggiungiRimuoviLinguaEsperto?IDEsperto=<%=esp.getID()%>&codISOLingua=<%=c.getLingua().getCodISOLingua()%>&operation=del'">Rimuovi
                            </button>
                        </td>
                    </tr>
                    <%}%>
                </table>

                <button id="btnAggiungiLingua" onclick="showElemById('divAggiungiLingua')">Aggiungi lingua</button>
                <button id="btnChiudiLista" onclick="hideElemById('divListaConoscenze')">Chiudi</button>
            </div>

            <div id="divAggiungiLingua">
                <label for="formLingua">Seleziona una lingua:</label>
                <form id="formLingua" action="aggiungiRimuoviLinguaEsperto?IDEsperto=<%=esp.getID()%>&operation=add" method="POST">
                    <select name="codISOLingua">
                        <%for(Lingua l : lingueNonConosciute) {%>
                        <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                        <%}%>
                    </select>
                    <input id="btnConferma" type="submit" value="Conferma">
                </form>
            </div>

        <%}%>

    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
