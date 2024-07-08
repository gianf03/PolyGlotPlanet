<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Utente utente = (Utente) session.getAttribute("utente");

    if(utente == null || !utente.isAdmin()) {%>
        <script>window.location.href="index.jsp?error=11"</script>
    <%}%>

<html>
<head>
    <title>Area admin</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>
    <div class="containerOfAll">

        <%@include file="header.jsp"%>

        <div id="leftContainerAdmin">
            <div class="adminSettings">
                <a href="mostraUtenti">Mostra utenti</a>
            </div>
            <div class="adminSettings">
                <a href="mostraEsperti">Mostra esperti</a>
            </div>
            <div class="adminSettings">
                <a href="tuttiCorsi">Mostra corsi</a>
            </div>
        </div>
    </div>
</body>
</html>
