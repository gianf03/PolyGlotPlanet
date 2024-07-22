<%@ page import="java.util.Enumeration" %>
<%@ page import="Model.Bean.Utente" %>
<%@ page import="Model.Bean.Esperto" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 13/07/2024
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error 401</title>

    <link rel="stylesheet" type="text/css" href="css/errori.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <% String address;
       Utente u = (Utente) session.getAttribute("utente");
       Esperto e = (Esperto) session.getAttribute("esperto");
       if(u == null && e == null)
           address = "index.jsp";
       else
           address = "logout";
    %>

    <div id="logoNome">
        <img id="logo" src="img/logoNero.png" alt="logo">
        <span id="nome">PolyGlotPlanet</span>
    </div>

    <div id="container">
        <div id="contenuto">
            <p id="p1">Oops!</p>
            <p id="p2">Non disponi delle autorizzazioni necessarie per accedere a questa pagina</p>
            <p id="p3">Error code : 401</p>
            <p id="p4">Puoi sempre tornare alla home :</p>
            <a id="index" href="<%=address%>">Home</a>
        </div>

        <div id="imgErrore">
            <img id="stop" src="img/401.jpg" alt="robot rotto">
        </div>
    </div>
</body>
</html>
