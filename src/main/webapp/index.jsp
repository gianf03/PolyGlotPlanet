<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Home</title>
    <link type="text/css" href="css/home.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/chargeAllStates.js"></script>

    <!--anche se sottolineato giallo non modificare-->
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <section id="outer-container">

            <%
                String error = request.getParameter("error");

                if(error != null && error.equals("11")) { %>

                    <div id="divErrorePermessi">Non disponi dei permessi necessari</div>
            <%
                }
            %>

            <div id="flex-container">

                <%
                    List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                    for(int i = 0; i < 45; i++) { %>

                        <div class="flex-item" id="<%=i+1%>">
                            <a class="linkLingua" href="mostraCategorie?codLingua=<%=lingue.get(i).getCodISOLingua()%>">
                            <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>">
                            <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                            </a>
                        </div>

                        <% if(i >= 6) {%> <!--parentesi graffa obbligatoria altrimenti è come se l'if non ci fosse-->
                            <script>
                                document.getElementById("<%=i+1%>").style.display = "none";
                            </script>
                        <%}%>

                <%}%>

                <div id="divPlus"><button id="plus" onclick="chargeAllStates(<%=lingue.size()%>)"><img id="imgPlus" src="img/plus_1.png"></button></div>
            </div>
        </section>
    </div>
<%@ include file="WEB-INF/jsp/footer.jsp"%>
    <!--anche se sottolineato giallo non modificare-->
    <script src="JavaScript/cambiaAltezza.js"></script>
    <script src="JavaScript/resizeContainer.js"></script>
</body>
</html>