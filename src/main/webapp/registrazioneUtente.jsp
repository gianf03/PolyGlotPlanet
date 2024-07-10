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
    <title>Registrazione utente</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="JavaScript/registrazione.js"></script>
</head>
<body>
    <div class="containerOfAll">
        <div id="div-registrazioneUtente">
            <div id="reg"><h1>Registrazione</h1></div>

            <% String queryString = request.getQueryString(); %>

            <form id="form-registrazione" action="registrazioneUtente" method="POST">
                <div class="credenziali">
                    <label id="labelNome" for="nome">Nome : </label>
                    <input type="text" id="nome" name="nome" placeholder="es.:Marco" required onclick="removeError('error1')">

                    <!-- contains("error=1") non va bene perché se si verifica solo erro 12 la stringa di errore verrà mostrata comunque -->
                    <%if (queryString!=null && (queryString.contains("error=1&") || queryString.endsWith("error=1"))) { %>
                        <p id="error1" class="regError">Nome assente</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <label id="labelCognome" for="cognome">Cognome : </label>
                    <input type="text" id = "cognome" name = "cognome" placeholder="es.:Rossi" required onclick="removeError('error2')">

                    <%if (queryString!=null && (queryString.contains("error=2&") || queryString.endsWith("error=2"))) { %>
                        <p id="error2" class="regError">Cogome assente</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <label id="labelDdn">Data di nascita : </label>
                    <input type="date" id = "ddn" name = "ddn" placeholder="data di nascita" required onclick="removeError('error8'); removeError('error9')">

                    <%if (queryString!=null && (queryString.contains("error=8&") || queryString.endsWith("error=8"))) { %>
                        <p id="error8" class="regError">Data nascita non impostata</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=9&") || queryString.endsWith("error=9"))) { %>
                        <p id="error9" class="regError">Ciò che hai inserito non è una data</p>
                    <%}%>
                </div>

                <script>
                    // Funzione per ottenere la data di 14 anni fa dalla data odierna
                    function maxDate() {
                        let today = new Date();
                        let year = today.getFullYear() - 14;
                        let month = today.getMonth()+1; //i mesi partono da 0
                        let day = today.getDate();

                        if(month<10) month = '0' + month;
                        if(day<10) day = '0' + day;

                        let date = year + '-' + month + '-' + day;
                        return date;
                    }

                    document.getElementById("ddn").max = maxDate();
                </script>

                <div class="credenziali">
                    <label id="labelEmail" for="email">E-mail : </label>
                    <input type="email" id="email" name = "email" placeholder="es.:marcorossi@gmail.com" required onclick="removeError('error3'); removeError('error4'); removeError('error12')">

                    <%if (queryString!=null && (queryString.contains("error=3&") || queryString.endsWith("error=3"))) { %>
                        <p id="error3" class="regError">Email assente</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=4&") || queryString.endsWith("error=4"))) { %>
                        <p id="error4" class="regError">Email non conforme</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=12&") || queryString.endsWith("error=12"))) { %>
                        <p id="error12" class="regError">Email già in uso</p>
                    <%}%>
                </div>



                <div class="credenziali">
                    <label id="labelPassword" for="password">Password : </label>
                    <input type="password" id="password" name = "password" placeholder="almeno 8 caratteri" required onclick="removeError('error5'); removeError('error6')">

                    <%if (queryString!=null && (queryString.contains("error=5&") || queryString.endsWith("error=5"))) { %>
                        <p id="error5" class="regError">Password assente</p>
                    <%}%>

                    <%if (queryString!=null && (queryString.contains("error=6&") || queryString.endsWith("error=6"))) { %>
                        <p id="error6" class="regError">Password troppo corta</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <label>Sesso :</label><br>
                    <input type="radio" id="male" name="sesso" value="M" onclick="removeError('error7')">
                    <label for="male">Maschio</label><br>
                    <input type="radio" id="female" name="sesso" value="F" onclick="removeError('error7')">
                    <label for="female">Femmina</label><br><br>

                    <%if (queryString!=null && (queryString.contains("error=7&") || queryString.endsWith("error=7"))) { %>
                        <p id="error7" class="regError">Genere non previsto o non selezionato</p>
                    <%}%>
                </div>

                <div class="credenziali"><input type="submit" value="Registrati" id="tasto-registrazione"></div>
            </form>
        </div>
    </div>

    <%@ include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
