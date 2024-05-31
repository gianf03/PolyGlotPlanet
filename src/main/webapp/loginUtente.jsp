<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

    <div id="div-login">
        <div id="log"><h1>Login</h1></div>

        <form id="form-login" action="loginUtente" method="POST">
            <div class="credenziali"><input type="email" id="email" name = "email" placeholder="email" required></div>
            <div class="credenziali"><input type="password" id="password" name = "password" placeholder="password" required></div>
            <div class="credenziali"><input type="submit" value="Login" id="tasto-login"></div>
        </form>

        <div id="reg"><p id="nonUtente">Non hai un account?</p><a href="registrazioneUtente.jsp">Registrati</a></div>
    </div>
<footer>
    <%@ include file="footer.jsp"%>
</footer>

</body>
</html>
