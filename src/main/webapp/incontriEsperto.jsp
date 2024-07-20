<%@ page import="Model.Bean.Incontro" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Incontri Esperto</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <link type="text/css" href="css/utenteLoggatoEsperto.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/utility.js"></script>
</head>
<body>

    <%
        List<Incontro> incontri = (List<Incontro>) request.getAttribute("incontri");
        List<Lingua> lingueConosciute = (List<Lingua>) request.getAttribute("lingueConosciute");
        Esperto es = (Esperto) session.getAttribute("esperto");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div id="containerOfAll">

        <%
            if(es != null) {%>
                <div id="divFiltri">
                    <button class="dropbtn btn" id="btnAggiunta" onclick="showElemById('divAggiungiIncontro')">Aggiungi incontro</button>
                </div>
        <%}
            String insertion = request.getParameter("insertion");

            if(insertion != null && insertion.equals("good")) {%>
                <script>alert("Inserimento avvenuto con successo!")</script>
        <%} else if(request.getParameter("error") != null){%>
                <script>alert("Incontro non aggiunto!")</script>
        <%}%>

        <div id="containerOfTable">
            <table id="tableIncontri">
                <tr class="rigaIncontri">
                    <th>ID</th>
                    <th>Data e ora</th>
                    <th>Indirizzo</th>
                    <th>Lingua</th>
                    <th>Prenotato (SI/NO)</th>
                    <th>Prezzo base</th>
                    <th>Sconto percentuale</th>
                    <th>Prezzo attuale</th>
                </tr>

                <% if(incontri != null && !incontri.isEmpty()) {
                    for(Incontro i : incontri) {%>
                        <tr class="rigaIncontri">
                            <td><%=i.getID()%></td>
                            <td><%=i.getDataOra()%></td>
                            <td><%=i.getVia()%> <%=i.getCivico()%> <%=i.getCAP()%></td>
                            <td><%=i.getLingua().getNome()%></td>
                            <td><%=i.isPrenotato()%></td>
                            <td><%=i.getPrezzoBase()%> €</td>
                            <td><%=i.getScontoPercentuale()%> %</td>
                            <td><%=i.getPrezzoAttuale()%> €</td>

                            <%
                                if(es != null) {%>
                            <td>
                                <button class="btn" id="btnRimuovi" onclick="document.location='rimuoviColloquiIncontriEsperto?IDProdotto=<%=i.getID()%>'">Rimuovi</button>
                            </td>
                            <%}%>
                        </tr>
                <%}
                }%>
            </table>
        </div>

        <%
            if(es != null) {%>
                <div id="divAggiungiIncontro">
                    <form action="aggiungiIncontroEsperto">
                        <div class="aggiungiIncontroItem">
                            <label for="dataOra">Data e ora</label><br>
                            <input type="datetime-local" name="dataOra" id="dataOra">

                            <script>
                                // Funzione per ottenere la data di 18 anni fa dalla data odierna
                                function minDate() {
                                    let tomorrow = new Date();
                                    tomorrow.setDate(tomorrow.getDate() + 1);
                                    let year = tomorrow.getFullYear();
                                    let month = tomorrow.getMonth()+1; //i mesi partono da 0
                                    let day = tomorrow.getDate(); //da capire se funziona
                                    let hour = tomorrow.getHours()+2;
                                    let minutes = tomorrow.getMinutes();

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
                            <label for="capInc">CAP</label><br>
                            <input type="text" name="cap" id="capInc">
                        </div>
                        <div class="aggiungiIncontroItem">
                            <label for="viaInc">Via</label><br>
                            <input type="text" name="via" id="viaInc">
                        </div>
                        <div class="aggiungiIncontroItem">
                            <label for="civicoInc">Civico</label><br>
                            <input type="text" name="civico" id="civicoInc">
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
                            <input type="submit" value="Aggiungi" class="btnAggiungi btn">
                            <button type="button" class="btnChiudi btn" onclick="hideElemById('divAggiungiIncontro')">Chiudi</button>
                        </div>
                    </form>
                </div>
        <%}%>
    </div>

</body>
</html>
