<%@ page import="java.util.List" %>
<%@ page import="Model.Lingua" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Home</title>
    <link type="text/css" href="css/homeCSS.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

    <%@ include file="header.jsp"%>

    <section id="outer-container">
        <div id="flex-container">

            <%
                List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                for(int i = 0; i < 6; i++) { %>

                <div class="flex-item">
                    <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>">
                    <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                </div>

            <%}%>

            <div id="divPlus"><a id="plus" href=""><img src="img/plus.png"></a></div>
        </div>
    </section>


    <%@ include file="footer.jsp"%>
</body>
</html>