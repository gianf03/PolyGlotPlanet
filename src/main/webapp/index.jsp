<%@ page import="java.util.List" %>
<%@ page import="Model.Lingua" %>
<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Home</title>
    <link type="text/css" href="css/homeCSS.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<style>.disNone{display: none}</style>

    <%@ include file="header.jsp"%>

    <section id="outer-container">
        <div id="flex-container">

            <%
                List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                for(int i = 0; i < 6; i++) { %>

                <a class="linkLingua" href=""><div class="flex-item">
                    <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>">
                    <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                </div></a>

            <%}%>

            <div id="divPlus"><button id="plus"><img src="img/plus.png"></button></div>
        </div>
    </section>


    <%@ include file="footer.jsp"%>
</body>
</html>