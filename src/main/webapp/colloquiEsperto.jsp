<%@ page import="Model.Bean.Colloquio" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colloqui Esperto</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <link type="text/css" href="css/utenteLoggatoEsperto.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/showElemById.js"></script>
</head>
<body>
    <%
        List<Colloquio> colloqui = (List<Colloquio>) request.getAttribute("colloqui");
        List<Lingua> lingueConosciute = (List<Lingua>) request.getAttribute("lingueConosciute");
        Esperto es = (Esperto) session.getAttribute("esperto");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <%
            if(es != null) {%>
                 <div id="divFiltri">
                    <button class="dropbtn" id="btnAggiunta" onclick="showElemById('divAggiungiColloquio')">Aggiungi colloquio</button>
                </div>
        <%}
            String insertion = request.getParameter("insertion");

            if(insertion != null && insertion.equals("good")) {%>
                <script>alert("Inserimento avvenuto con successo!")</script>
        <%} else if(request.getParameter("error") != null && request.getQueryString().contains("error=20")){%>
                <script>alert("Colloquio non aggiunto!")</script>
        <%}%>

        <table id="tableColloqui">
            <tr class="rigaColloqui">
                <th>ID</th>
                <th>Data e ora</th>
                <th>Lingua</th>
                <th>Prenotato (SI/NO)</th>
                <th>Prezzo base</th>
                <th>Sconto percentuale</th>
                <th>Prezzo attuale</th>
            </tr>

            <% if(colloqui != null && !colloqui.isEmpty()) {
                for(Colloquio c : colloqui) {%>
                    <tr class="rigaColloqui">
                        <td><%=c.getID()%></td>
                        <td><%=c.getDataOra()%></td>
                        <td><%=c.getLingua().getNome()%></td>
                        <td><%=c.isPrenotato()%></td>
                        <td><%=c.getPrezzoBase()%> €</td>
                        <td><%=c.getScontoPercentuale()%> %</td>
                        <td><%=c.getPrezzoAttuale()%> €</td>

                        <%
                            if(es != null) {%>
                                <td>
                                    <button id="btnRimuovi" onclick="document.location='rimuoviColloquiIncontriEsperto?IDProdotto=<%=c.getID()%>'">Rimuovi</button>
                                </td>
                        <%}%>
                    </tr>
            <%}
            }%>
        </table>

        <%
            if(es != null) {%>
        <div id="divAggiungiColloquio">
            <form action="aggiungiColloquioEsperto">
                <div class="aggiungiIncontroItem">
                    <label for="dataOra">Data e ora</label><br>
                    <input type="datetime-local" name="dataOra" id="dataOra">

                    <script>
                        // Funzione per ottenere l'ora successiva a quella attuale
                        function minDate() {
                            let today = new Date();
                            let year = today.getFullYear();
                            let month = today.getMonth()+1; //i mesi partono da 0
                            let day = today.getDate();
                            let hour = today.getHours() + 2;
                            let minutes = today.getMinutes();

                            if(month<10) month = '0' + month;
                            if(day<10) day = '0' + day;
                            if(hour<10) hour = '0' + hour;

                            let date = year + '-' + month + '-' + day + 'T' + hour + ':' + minutes;
                            return date;
                        }

                        document.getElementById("dataOra").min = minDate();
                    </script>
                </div>
                <div class="aggiungiIncontroItem">
                    <label for="linguaInc">Seleziona lingua</label><br>
                    <select name="codISOLingua" id="linguaInc">
                        <%
                            if(lingueConosciute != null && !lingueConosciute.isEmpty()) {
                                for(Lingua l : lingueConosciute) {%>
                                    <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                            <%}
                        }%>
                    </select>
                </div>
                <div class="aggiungiIncontroItem">
                    <label for="prBaseInc">Prezzo base</label><br>
                    <input type="text" name="prezzoBase" id="prBaseInc">
                </div>
                <div class="aggiungiIncontroItem">
                    <label for="scontoInc">Sconto</label><br>
                    <input type="text" name="sconto" id="scontoInc">
                </div>
                <div class="aggiungiIncontroItem">
                    <input type="submit" value="Aggiungi" class="btnAggiungi">
                    <button type="button" class="btnChiudi" onclick="hideElemById('divAggiungiColloquio')">Chiudi</button>
                </div>
            </form>
        </div>
        <%}%>
    </div>
</body>
</html>
