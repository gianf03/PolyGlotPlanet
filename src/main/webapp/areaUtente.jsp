<%@ page import="Model.Bean.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area Utente</title>
    <link type="text/css" href="css/utenteLoggatoEsperto.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
<div class="containerOfAll">
    <div id="containerAreaUtente">
        <div id="containerdatiUtente">

            <table id="tableDatiUtente">
                <tr>
                    <td>Nome</td>
                    <td>${utente.nome}</td>
                </tr>
                <tr>
                    <td>Cognome</td>
                    <td>${utente.cognome}</td>
                </tr>
                <tr>
                    <td>Data nascita</td>
                    <td>${utente.dataNascita}</td>
                </tr>
                <tr>
                    <td>Genere</td>
                    <td>${utente.genere}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${utente.email}</td>
                </tr>
            </table>

            <div id="divTastoModifica">
                <button id="tastoModifica" onclick="showElemById('containerModificaDati')">Modifica</button>
            </div>
        </div>

        <% String error = request.getQueryString(); %>

        <div id="containerModificaDati">
            <form id="formModificaDati" action="modificaDatiUtente">
                <div class="credenziali">
                    <label for="nome">Nome</label><br>
                    <input type="text" id="nome" name="nome" value="${utente.nome}" onclick="removeError('error1')">

                    <% if(error != null && error.contains("error=1")) {%>
                    <p id="error1" class="paragrafiRossi">Nome non consentito</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="cognome">Cognome</label><br>
                    <input type="text" id="cognome" name="cognome" value="${utente.cognome}" onclick="removeError('error2')">

                    <% if(error != null && error.contains("error=2")) {%>
                    <p id="error2" class="paragrafiRossi">Cognome non consentito</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="newPass">Nuova password</label><br>
                    <input type="password" id="newPass" name="newPass" onclick="removeError('error3')">

                    <% if(error != null && error.contains("error=6") ) {%>
                    <p id="error3" class="paragrafiRossi">Password troppo corta</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="confNewPass">Conferma password</label><br>
                    <input type="password" id="confNewPass" name="confNewPass" onclick="removeError('error4')">

                    <% if(error != null && error.contains("error=10") ) {%>
                    <p id="error4" class="paragrafiRossi">Password non coincidenti</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <input id="tastoConferma" type="submit" value="Conferma">
                </div>
            </form>
        </div>
    </div>

    <%
        if(error == null || error.isEmpty()) {%>
    <script>
        document.getElementById("containerModificaDati").style.display = "none";
    </script>
    <%}%>
</div>
<%@include file="WEB-INF/jsp/footer.jsp"%>

<script src="JavaScript/showElemById.js"></script>
<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
