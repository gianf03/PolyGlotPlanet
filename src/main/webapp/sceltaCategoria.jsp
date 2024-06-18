<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <link type="text/css" href="css/sceltaCategorieCSS.css" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp"%>

    <c:forEach items="${categorie}" var="categoria">
        <section><a href="">${categoria.nome}</a></section>
    </c:forEach>

    <%@ include file="footer.jsp"%>
</body>
</html>
