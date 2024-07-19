<%@ page import="Model.Bean.Composizione" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Ordine" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista esperti</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%
        List<Ordine> ordini = (List<Ordine>) request.getAttribute("ordini");
        List<List<Composizione>> listaComposizioniOrdini = (List<List<Composizione>>) request.getAttribute("listaComposizioniOrdini");
    %>

    <div class="containerOfAll">

        <%@include file="WEB-INF/jsp/header.jsp"%>

        <table id="tableOrdini">

            <%if(!request.getParameter("IDUtente").equals("all") && !ordini.isEmpty()) {%>
            <tr>
                <td>Ordini Utente: #<%=ordini.get(0).getUtente().getID()%> <%=ordini.get(0).getUtente().getNome()%>
                    <%=ordini.get(0).getUtente().getCognome()%></td>
            </tr>
            <%}%>

            <tr>
                <th>ID ordine</th>
                <th>Data e ora</th>
                <th>ID prodotto</th>
                <th>Categoria</th>
                <th>Prezzo acquisto</th>

                <%if(request.getParameter("IDUtente").equals("all")) {%>
                    <th>ID utente</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                <%}%>
            </tr>

        <%for(int i=0; i<ordini.size(); i++) {

            for(int j=0; j<ordini.get(i).getNumeroProdotti(); j++){
                Composizione c = listaComposizioniOrdini.get(i).get(j);%>
                <tr>
                    <td><%=c.getOrdine().getID()%></td>
                    <td><%=c.getOrdine().getDataOra()%></td>
                    <td><%=c.getProdotto().getID()%></td>
                    <td><%=c.getProdotto().getCategoria().getNome()%></td>
                    <td><%=c.getPrezzoAcquisto()%> €</td>

                    <%if(request.getParameter("IDUtente").equals("all")) {%>
                        <td><%=c.getOrdine().getUtente().getID()%></td>
                        <td><%=c.getOrdine().getUtente().getNome()%></td>
                        <td><%=c.getOrdine().getUtente().getCognome()%></td>
                    <%}%>
                </tr>

        <%  }
        }%>

        </table>
    </div>
</body>
</html>
