<%@ page import="Model.Bean.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login utente</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="JavaScript/utility.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div id="containerOfAll">
        <div id="div-loginUtente">

            <%
                if(request.getParameter("registration") != null && request.getParameter("registration").equals("good")) {%>
                    <script>alert("Registrazione andata a buon fine!")</script>
            <%}%>

            <div id="log"><a href="index.jsp" title="logo"><img id="logo" src="img/logo.png" alt="logo"></a></div>

            <%String queryString = request.getQueryString();%>

            <%if (queryString!=null && (queryString.contains("error=14&") || queryString.endsWith("error=14"))) { %>
                <p id="error14" class="logError">E-mail e/o password errata</p>
            <%}%>

            <form id="form-login" action="loginUtente" method="POST">
                <div class="credenziali">
                    <label id="labelEmail" for="email">E-mail : </label><br>
                    <input type="email" id="email" name = "email" placeholder="es.:marcorossi@gmail.com" required onclick="removeError('error3'); removeError('error4'); removeError('error14')">
                    <%if (queryString!=null && (queryString.contains("error=3&") || queryString.endsWith("error=3"))) { %>
                        <p id="error3" class="logError">Email assente</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=4&") || queryString.endsWith("error=4"))) { %>
                        <p id="error4" class="logError">Email non conforme</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <label id="labelPassword" for="password">Password : </label><br>
                    <input type="password" id="password" name = "password" placeholder="almeno 8 caratteri" required onclick="removeError('error5'); removeError('error6'); removeError('error14')">

                    <%if (queryString!=null && (queryString.contains("error=5&") || queryString.endsWith("error=5"))) { %>
                        <p id="error5" class="logError">Password assente</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=6&") || queryString.endsWith("error=6"))) { %>
                        <p id="error6" class="logError">Password troppo corta</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <input type="submit" value="Login" id="tasto-login">
                </div>
            </form>

            <div id="divAdmin">
                <a id="linkAdmin" href="loginAdmin.jsp">Sei admin?</a>
            </div>

            <div id="reg"><p id="nonUtente">Non hai un account?</p><a id="registrazioneUtente" href="registrazioneUtente.jsp">Registrati</a></div>
        </div>
    </div>
    <%@ include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
