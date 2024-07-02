<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 28/05/2024
  Time: 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="containerOfAll">
        <div id="div-loginEsperto">
            <div id="log"><a href="index.jsp"><img id="logoLogin" alt="immagine del globo circondato da bandiere" src="img/logo.jpg"></a></div>

            <%
                if(request.getParameter("error") != null &&
                        request.getParameter("error").equals("1")) { %>

            <div class="credenziali" id="loginError">Login errato, riprova</div>

            <%}%>

            <form id="form-login" action="loginEsperto" method="POST">
                <div class="credenziali"><input type="email" id="email" placeholder="email" required></div>
                <div class="credenziali"><input type="password" id="password" placeholder="password" required></div>
                <div class="credenziali"><input type="submit" value="Login" id="tasto-login"></div>
            </form>

            <div id="reg"><p id="nonUtente">Non hai un account?</p><a href="registrazioneEsperto.jsp">Registrati</a></div>
        </div>
        <%@ include file="footer.jsp"%>
    </div>

    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
