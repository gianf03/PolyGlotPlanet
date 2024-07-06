<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login admin</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="containerOfAll">
        <div id="div-loginAdmin">
            <div id="log"><a href="index.jsp">Area admin</a></div>

                <%
                    String error = request.getParameter("error");

                    if(error != null && error.equals("1")) { %>
                        <div class="credenziali" id="loginError">Login errato, riprova</div>
                <%} else if(error != null && error.equals("2")) {%>
                        <div class="credenziali" id="loginError">Utente non autorizzato</div>
                <%}
                %>

            <form id="form-login" action="loginAdmin" method="POST">
                <div class="credenziali"><input type="email" id="email" name="email" placeholder="email" required></div>
                <div class="credenziali"><input type="password" id="password" name="password" placeholder="password" required></div>
                <div class="credenziali"><input type="submit" value="Login" id="tasto-login"></div>
            </form>
        </div>
    </div>
</body>
</html>
