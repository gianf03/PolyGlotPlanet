<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 17/07/2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>

    <link type="text/css" href="css/carrello.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%List<Prodotto> prodotti = (List<Prodotto>) session.getAttribute("carrello"); %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">
        <% if(prodotti != null){
            for(Prodotto p : prodotti) { %>
            <p>
                <%=p.getID()%> <%=p.getLingua().getNome()%> <%=p.getPrezzoAttuale()%>
            </p>
        <%  }%>
            <form id="ordina">
                <input type="submit" value="Ordina" id="buttonOrdina">
            </form>
            <%if(session.getAttribute("utente") == null) {%>
                <script>
                    let x = "ordina";
                    document.getElementById("ordina").action = "loginUtente.jsp";
                </script>
            <%} else {%>
                <script>
                    document.getElementById("ordina").action = "effettuaOrdine";
                </script>
            <%  }%>
        <%}%>
    </div>
    <%@include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
