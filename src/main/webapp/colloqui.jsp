<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 07/07/2024
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colloqui</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <div id="containerColloquio">
            <div id="containerFotoEsperto" class="colloquioItem">
                <img src="" alt="foto di <%=1%>">
            </div>
            <div id="containerInfoGenerali" class="colloquioItem">

            </div>
            <div class="colloquioItem">

            </div>


            <% if(request.getParameter("lingua") != null) { %>
            <a id="anchorMostraTuttiColloqui" href="">
                <div id="mostraTuttiColloquiContainer">
                    <p id="mostraTuttiCorsi">Indeciso su quale lingua apprendere? Vedi tutti i colloqui</p>
                </div>
            </a>
            <%}%>
        </div>
    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
