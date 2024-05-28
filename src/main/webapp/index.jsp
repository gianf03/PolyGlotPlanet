<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Home</title>
    <link type="text/css" href="css/homeCSS.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

    <header>
        <%@ include file="header.jsp"%>
    </header>

    <section id="outer-container">
        <div id="flex-container">

            <%
                List<String> lingue = (List<String>) application.getAttribute("lingue");

                for(int i = 0; i < 6; i++) { %>

                <div class="flex-item"><img class="foto-lingue" src="<%=lingue.get(i)%>"></div>

            <%}%>

            <div id="divPlus"><a id="plus" href=""><img src="img/plus.png"></a></div>
        </div>
    </section>


    <footer>
        <%@ include file="footer.jsp"%>
    </footer>

</body>
</html>