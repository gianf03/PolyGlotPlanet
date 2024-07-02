<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="containerOfAll">
        <div id="div-loginUtente">
            <div id="log"><a href="index.jsp"><img id="logoLogin" alt="immagine del globo circondato da bandiere" src="img/logo.jpg"></a></div>

            <%
                if(request.getParameter("error") != null &&
                        request.getParameter("error").equals("1")) { %>

                    <div class="credenziali" id="loginError">Login errato, riprova</div>

            <%}%>

            <form id="form-login" action="loginUtente" method="POST">
                <div class="credenziali"><input type="email" id="email" name = "email" placeholder="email" required></div>
                <div class="credenziali"><input type="password" id="password" name = "password" placeholder="password" required></div>
                <div class="credenziali"><input type="submit" value="Login" id="tasto-login"></div>
            </form>

            <div id="reg"><p id="nonUtente">Non hai un account?</p><a href="registrazioneUtente.jsp">Registrati</a></div>
        </div>
        <%@ include file="footer.jsp"%>
    </div>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
