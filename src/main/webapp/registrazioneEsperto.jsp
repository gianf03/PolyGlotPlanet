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
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

    <div id="div-registrazione">
        <div id="reg"><h1>Registrazione</h1></div>

        <form id="form-registrazione" action="registrazioneUtente" method="POST">
            <div class="credenziali"><input type="text" id = "nome" name = "nome" placeholder="nome" required></div>
            <div class="credenziali"><input type="text" id = "cognome" name = "cognome" placeholder="cognome" required></div>
            <div class="credenziali"><input type="date" id = "ddn" name = "ddn" placeholder="data di nascita" required></div>
            <div class="credenziali"><input type="email" id="email" name = "email" placeholder="email" required></div>
            <div class="credenziali"><input type="password" id="password" name = "password" placeholder="password" required></div>

            <div class="credenziali">
                <label>Sesso :</label><br>
                <input type="radio" id="male" name="sesso" value="M">
                <label for="male">Maschio</label><br>
                <input type="radio" id="female" name="sesso" value="F">
                <label for="female">Femmina</label><br><br>
            </div>

            <div class="credenziali"><input type="submit" value="Registrati" id="tasto-registrazione"></div>
        </form>
    </div>


    <%@ include file="footer.jsp"%>

</body>
</html>
