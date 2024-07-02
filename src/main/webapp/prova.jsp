<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 02/07/2024
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/prova.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%@include file="header.jsp"%>
    <div id="contentProva">

    </div>

    <%@include file="footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>  <!-- qui prima si caricano tutti gli elementi e poi si esegue lo script, se fosse stato in header lo script che va eseguito quando window.onload o window.onchange non avrebbe trovate gli elementi perché eseguito prima ancora che questi siano caricati-->
</body>
</html>
