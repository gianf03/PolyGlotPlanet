<%@ page import="Model.Bean.Incontro" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Incontri Esperto</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <link type="text/css" href="css/esperto.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/showElemById.js"></script>
</head>
<body>

    <%
        List<Incontro> incontri = (List<Incontro>) request.getAttribute("incontri");
        List<Lingua> lingueConosciute = (List<Lingua>) request.getAttribute("lingueConosciute");
        Esperto es = (Esperto) session.getAttribute("esperto");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <%
            if(es != null) {%>
                <div id="divFiltri">
                    <button class="dropbtn" id="btnAggiunta" onclick="showElemById('divAggiungiIncontro')">Aggiungi incontro</button>
                </div>
        <%}%>

        <table id="tableIncontri">
            <tr class="rigaIncontri">
                <th>ID</th>
                <th>Data e ora</th>
                <th>Indirizzo</th>
                <th>Lingua</th>
                <th>Prenotato (SI/NO)</th>
                <th>Prezzo base</th>
                <th>Sconto percentuale</th>
            </tr>

            <% for(Incontro i : incontri) {%>
            <tr class="rigaIncontri">
                <td><%=i.getID()%></td>
                <td><%=i.getDataOra()%></td>
                <td><%=i.getVia()%> <%=i.getCivico()%> <%=i.getCAP()%></td>
                <td><%=i.getLingua().getNome()%></td>
                <td><%=i.isPrenotato()%></td>
                <td><%=i.getPrezzoBase()%> €</td>
                <td><%=i.getScontoPercentuale()%> %</td>

                <%
                    if(es != null) {%>
                <td>
                    <button id="btnRimuovi" onclick="document.location='rimuoviColloquiIncontriEsperto?IDProdotto=<%=i.getID()%>'">Rimuovi</button>
                </td>
                <%}%>
            </tr>
            <%}%>
        </table>


        <%
            if(es != null) {%>
                <div id="divAggiungiIncontro">
                    <form>
                        <div class="aggiungiIncontroItem">
                            <label for="dateTime">Data e ora</label><br>
                            <input type="datetime-local" name="dataOra" id="dateTime">
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
                            <select name="lingua" id="linguaInc">
                                <%
                                    for(Lingua l : lingueConosciute) {%>
                                        <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                                <%}%>
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
                            <input type="submit" value="Aggiungi">
                        </div>
                    </form>
                </div>
        <%}%>
    </div>

</body>
</html>
