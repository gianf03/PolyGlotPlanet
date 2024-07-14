<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <link type="text/css" href="css/index.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">
        <%
            String error = request.getParameter("error");

            if(error != null && error.equals("11")) { %>

                <div id="divErrorePermessi">Non disponi dei permessi necessari</div>
        <%}%>

        <div id="containerCategorie">
            <c:forEach items="${categorie}" var="categoria" >
                <section>
                    <img class="categoria" src="${categoria.immagine}">
                    <div id="divLinkCat">
                        <a class="categoria" href="sceltaLingua.jsp?categoria=${categoria.nome}">${categoria.nome}</a>
                    </div>
                </section>
            </c:forEach>
        </div>
    </div>
<%@ include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
