<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area admin</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

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
