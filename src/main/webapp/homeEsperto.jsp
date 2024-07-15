<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 04/07/2024
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>

    <%
        Esperto esp = (Esperto) session.getAttribute("esperto");
    %>

    <div class="containerOfAll">

        <div id="containerEsperto">
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="colloquio stilizzato" src="img/categorie/colloquio.png">
                </div>

                <div class="settingsLink">
                    <a href="colloquio?IDEsperto=<%=esp.getID()%>">I miei colloqui</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="incontro stilizzato" src="img/categorie/incontro.png">
                </div>

                <div class="settingsLink">
                    <a href="incontro?IDEsperto=<%=esp.getID()%>">I miei incontri</a>
                </div>
            </div>
            <div class="espertoSettings">
                <div class="settingsImg">
                    <img alt="lingua stilizzata" src="img/lingua.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraLingueEsperto?IDEsperto=<%=esp.getID()%>">Le mie lingue</a>
                </div>
            </div>
        </div>

    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
