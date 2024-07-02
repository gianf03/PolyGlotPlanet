<%@ page import="java.util.Date" %><%--
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
    <div class=containerOfAll">
        <div id="div-registrazioneEsperto" class="containerOfAll">
            <div id="reg"><h1>Registrazione</h1></div>

            <form id="form-registrazione" action="registrazioneUtente" method="POST">
                <div class="credenziali"><input type="text" id = "nome" name = "nome" placeholder="nome" required></div>
                <div class="credenziali"><input type="text" id = "cognome" name = "cognome" placeholder="cognome" required></div>


                <!-- l'esperto deve avere almeno 18 anni -->
                <div class="credenziali">
                    <label id="labelDdn">Data di nascita : </label>
                    <input type="date" id = "ddn" name = "ddn" required>
                </div>
                <script>
                    // Funzione per ottenere la data di 18 anni fa dalla data odierna
                    function maxDate() {
                        let today = new Date();
                        let year = today.getFullYear() - 18;
                        let month = today.getMonth()+1; //i mesi partono da 0
                        let day = today.getDate();

                        if(month<10) month = '0' + month;
                        if(day<10) day = '0' + day;

                        let date = year + '-' + month + '-' + day;
                        return date;
                    }

                    document.getElementById("ddn").max = maxDate();
                </script>

                <div class="credenziali"><input type="email" id="email" name = "email" placeholder="email" required></div>
                <div class="credenziali"><input type="password" id="password" name = "password" placeholder="password" required></div>

                <div class="credenziali">
                    <label>Sesso :</label><br>
                    <input type="radio" class="sesso" id="male" name="sesso" value="M">
                    <label for="male">Maschio</label><br>
                    <input type="radio" class="sesso" id="female" name="sesso" value="F">
                    <label for="female">Femmina</label><br><br>
                </div>

                <div class="credenziali">
                    <label id="labelFoto">Foto profilo : </label>
                    <input type="file" id="foto" name="foto" required>
                </div>
                <div class="credenziali"><input type="submit" value="Registrati" id="tasto-registrazione"></div>
            </form>
        </div>
        <%@ include file="footer.jsp"%>
    </div>

    <script src="JavaScript/cambiaAltezza.js"></script>

</body>
</html>
