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

    <%@ include file="header.jsp"%>

    <section id="outer-container">
        <div id="flex-container" onchange="chargeAllStates()">

            <%
                List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                for(int i = 0; i < 45; i++) { %>

                    <a class="linkLingua" href=""><div class="flex-item" id="<%=i+1%>">
                        <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>">
                        <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                    </div></a>

                    <% if(i >= 6) {%> <!--parentesi graffa obbligatoria altrimenti è come se l'if non ci fosse-->
                        <script>
                            document.getElementById("<%=i+1%>").style.display = "none";
                        </script>
                    <%}%>

            <%}%>

            <div id="divPlus"><button id="plus" onclick="chargeAllStates()"><img src="img/plus.png"></button></div>
        </div>
    </section>

    <script>
        function chargeAllStates() {
            for (let i = 6; i <= 45; i++) {
                document.getElementById(i).style.display = "";
            }


            //non fare getElementById().getPropertyValue() perchè non funziona, fai cosi
            var elemento = document.getElementById("flex-container");
            var height = window.getComputedStyle(elemento).getPropertyValue("height");

            if(height === "450px") {
                document.getElementById("flex-container").style.height = "2720px";
            } else if(height === "600px") {
                document.getElementById("flex-container").style.height = "8000px";

            } else {
                document.getElementById("flex-container").style.height = "8000px";
            }

        }
    </script>


    <%@ include file="footer.jsp"%>
</body>
</html>