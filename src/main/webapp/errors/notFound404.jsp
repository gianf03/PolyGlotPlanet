<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 15/07/2024
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Not Found 404</title>

    <link rel="stylesheet" type="text/css" href="css/errori.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div id="logoNome">
        <img id="logo" src="img/logoNero.png" alt="logo">
        <span id="nome">PolyGlotPlanet</span>
    </div>

    <div id="container">
        <div id="contenuto">
            <p id="p1">Oops!</p>
            <p id="p2">Non riesco a trovare la pagina che stai cercando</p>
            <p id="p3">Error code : 404</p>
            <p id="p4">Puoi sempre tornare alla home :</p>
            <a id="index" href="index.jsp">Home</a>
        </div>

        <div id="imgErrore">
            <img src="img/404.png" alt="robot rotto">
        </div>
    </div>
</body>
</html>
