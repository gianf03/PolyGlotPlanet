<%@ page import="Model.Bean.Incontro" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Incontri Esperto</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

    <%
        List<Incontro> incontri = (List<Incontro>) request.getAttribute("incontri");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

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
            </tr>
            <%}%>
        </table>
    </div>

</body>
</html>
