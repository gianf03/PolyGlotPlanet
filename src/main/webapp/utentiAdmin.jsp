<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista utenti</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll" style="text-align: center;">

        <table id="tableUtenti">
            <tr class="rigaUtenti">
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di nascita</th>
                <th>Email</th>
                <th>Genere</th>
            </tr>

            <c:forEach items="${utenti}" var="utente">
                <tr class="rigaUtenti">
                    <td>${utente.ID}</td>
                    <td>${utente.nome}</td>
                    <td>${utente.cognome}</td>
                    <td>${utente.dataNascita}</td>
                    <td>${utente.email}</td>
                    <td>${utente.genere}</td>
                    <td><button onclick="document.location='mostraOrdiniUtente?IDUtente=${utente.ID}'">Mostra ordini</button></td>
                </tr>
            </c:forEach>
        </table>

        <button id="tuttiOrdini" onclick="document.location='mostraOrdiniUtente?IDUtente=all'">Mostra tutti gli ordini</button>
    </div>
</body>
</html>
