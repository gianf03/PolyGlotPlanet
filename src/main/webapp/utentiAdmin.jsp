<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista utenti</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>

    <% List<Utente> utenti = (List<Utente>) request.getAttribute("utenti");%>

    <div class="containerOfAll">
        <%@include file="WEB-INF/jsp/header.jsp"%>

        <table id="tableUtenti">
            <tr class="rigaUtenti">
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di nascita</th>
                <th>Email</th>
                <th>Genere</th>
            </tr>

            <% for(Utente ut : utenti) {%>
                <tr class="rigaUtenti">
                    <td><%=ut.getID()%></td>
                    <td><%=ut.getNome()%></td>
                    <td><%=ut.getCognome()%></td>
                    <td><%=ut.getDataNascita()%></td>
                    <td><%=ut.getEmail()%></td>
                    <td><%=ut.getGenere()%></td>
                    <td><button onclick="document.location='mostraOrdiniUtente?IDUtente=<%=ut.getID()%>'">Mostra ordini</button></td>
                </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
