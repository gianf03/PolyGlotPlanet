<%@ page import="Model.Bean.Colloquio" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colloqui Esperto</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%
        List<Colloquio> colloqui = (List<Colloquio>) request.getAttribute("colloqui");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <table id="tableColloqui">
            <tr class="rigaColloqui">
                <th>ID</th>
                <th>Data e ora</th>
                <th>Lingua</th>
                <th>Prenotato (SI/NO)</th>
                <th>Prezzo base</th>
                <th>Sconto percentuale</th>
            </tr>

            <% for(Colloquio c : colloqui) {%>
            <tr class="rigaColloqui">
                <td><%=c.getID()%></td>
                <td><%=c.getDataOra()%></td>
                <td><%=c.getLingua().getNome()%></td>
                <td><%=c.isPrenotato()%></td>
                <td><%=c.getPrezzoBase()%> €</td>
                <td><%=c.getScontoPercentuale()%> %</td>
            </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
