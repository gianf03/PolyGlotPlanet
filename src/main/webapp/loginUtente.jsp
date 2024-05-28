<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/homeCSS.css">
</head>
<body>

    <div id="div-login">
        <form id="form-login" action="" method="POST">
            <input type="email" id="email"><br>
            <input type="password" id="password"><br>
            <input type="submit" value="Login" id="tasto-login">
        </form>

        <a href="registrazioneUtente.jsp">Registrati</a>
    </div>
<footer>
    <%@ include file="footer.jsp"%>
</footer>

</body>
</html>
