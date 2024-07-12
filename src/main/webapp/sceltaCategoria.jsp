<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <link type="text/css" href="css/sceltaCategorie.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">
        <div id="containerCategorie">
            <c:forEach items="${categorie}" var="categoria" >
                <section>
                    <img class="categoria" src="${categoria.immagine}">
                    <div id="divLinkCat">
                        <a class="categoria" href="colloqui.jsp?codLingua=<%=request.getParameter("codLingua")%>">${categoria.nome}</a>
                    </div>
                </section>
            </c:forEach>
        </div>
    </div>
<%@ include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
