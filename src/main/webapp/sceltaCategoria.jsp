<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <link type="text/css" href="css/sceltaCategorie.css" rel="stylesheet">
</head>
<body>
    <div class="containerOfAll">
        <%@ include file="header.jsp"%>
        <div id="containerCategorie">
            <c:forEach items="${categorie}" var="categoria" >
                <section>
                    <img class="categoria" src="${categoria.immagine}">
                    <div id="divLinkCat">
                        <a class="categoria" href="${categoria.nome}?lingua=<%=request.getParameter("lingua")%>">${categoria.nome}</a>
                    </div>
                </section>
            </c:forEach>
        </div>
        <%@ include file="footer.jsp"%>
    </div>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
