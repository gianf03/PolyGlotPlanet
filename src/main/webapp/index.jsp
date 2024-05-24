<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link type="text/css" href="css/homeCSS.css" rel="stylesheet">
</head>
<body>

    <header>
        <div class="logo"> Logo </div> <!--qui ci va il logo -->

        <div class="menu">
            <ul id="ulMenu">
                <li class="liMenu"><a class="menuElem" href="">ACCEDI</a></li>
                <li class="liMenu"><a class="menuElem" href="">CARRELLO</a></li>
                <li class="liMenu"><a class="menuElem" href=""><img src="img/utente.png"></a></li>
            </ul>
        </div>
    </header>

    <section id="outer-container">

        <div id="flex-container">

            <%
                List<String> lingue = (List<String>) application.getAttribute("lingue");

                for(int i = 0; i < 6; i++) { %>

                <div class="flex-item"><img class="foto-lingue" src="<%=lingue.get(i)%>"></div>

            <%} %>

            <div id="divPlus"><a id="plus" href=""><img src="img/plus.png"></a></div>
        </div>

    </section>

    <footer>
        <p>Supporto</p>
        <ul>
            <li class="supporto"><a href="">Contatti</a></li>
            <li class="supporto"><a href="">FAQ</a></li>
        </ul>
    </footer>

</body>
</html>