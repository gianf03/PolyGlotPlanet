<%@ page import="Model.Composizione" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista esperti</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>
    <%
        List<Composizione> ordini = (List<Composizione>) request.getAttribute("ordini");

        Utente ut = null;

        if(!ordini.isEmpty()) {
            ut = ordini.getFirst().getOrdine().getUtente();
        }
    %>

    <div class="containerOfAll">

        <%@include file="WEB-INF/jsp/header.jsp"%>

        <table id="tableOrdini">
            <%
                if(ut != null) {%>
                    <tr>
                        <td>Ordini Utente: #<%=ut.getID()%> <%=ut.getNome()%> <%=ut.getCognome()%></td>
                    </tr>
            <%}%>
            <tr>
                <th>ID ordine</th>
                <th>Data e ora</th>
                <th>ID prodotto</th>
                <th>Categoria</th>
                <th>Prezzo acquisto</th>
            </tr>

        <%for(Composizione c : ordini) {%>

                <tr>
                    <td><%=c.getOrdine().getID()%></td>
                    <td><%=c.getDataOra()%></td>
                    <td><%=c.getProdotto().getID()%></td>
                    <td><%=c.getProdotto().getCategoria().getNome()%></td>
                    <td><%=c.getPrezzoAcquisto()%></td>
                </tr>

        <%}%>

        </table>
    </div>
</body>
</html>
