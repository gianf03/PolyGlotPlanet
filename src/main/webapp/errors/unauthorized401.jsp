<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 13/07/2024
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error 401</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%String nome = "utente non registrato";
      Enumeration<String> attributeNames = session.getAttributeNames();
      if(attributeNames.hasMoreElements()) {
          nome = attributeNames.nextElement();
      }%>
    <div id="containerOfAll">
        <div>
            <h1>Unauthorized 401</h1>
            <p>In quanto <%=nome%>, non disponi dei permessi necessari per visualizzare questa pagina</p> <!--se admin figura come utente, non va bene -->
        </div>
        <div>
            <img src="img/401.png">
        </div>
    </div>
</body>
</html>
