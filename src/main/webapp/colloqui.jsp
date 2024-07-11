<%@ page import="Model.Bean.Colloquio" %>
<%@ page import="java.util.List" %><%--
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
    <div id="colloqui" class="containerOfAll">
        <% List<Colloquio> colloqui = (List<Colloquio>) request.getAttribute("colloqui"); %>
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
                    <p id="mostraTuttiColloqui">Indeciso su quale lingua apprendere? Vedi tutti i colloqui</p>
                </div>
            </a>
            <%}%>

            <div id="pagesContainer">
            <% for (int i = 0, j=0; i<colloqui.size(); i+=10) {%>
                <a id="page<%=j+1%>" href=""><%=j+1%></a>
            <%}%>
            </div>
        </div>
    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
