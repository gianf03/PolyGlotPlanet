<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area Esperto</title>
    <link type="text/css" href="css/utenteLoggatoEsperto.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
<div class="containerOfAll">
    <div id="containerAreaEsperto">
        <div id="containerDatiEsperto">

            <div id="divImgEsperto">
                <img id="imgEsperto" alt="foto esperto" src="${esperto.fotoRiconoscitiva}">
            </div>

            <table id="tableDatiEsperto">
                <tr>
                    <td>Nome</td>
                    <td>${esperto.nome}</td>
                </tr>
                <tr>
                    <td>Cognome</td>
                    <td>${esperto.cognome}</td>
                </tr>
                <tr>
                    <td>Data nascita</td>
                    <td>${esperto.dataNascita}</td>
                </tr>
                <tr>
                    <td>Genere</td>
                    <td>${esperto.genere}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${esperto.email}</td>
                </tr>
            </table>

            <div id="divTastoModifica">
                <button id="tastoModifica" onclick="showElemById('containerModificaDati')">Modifica</button>
            </div>
        </div>

        <% String error = request.getQueryString(); %>

        <div id="containerModificaDati">
            <form id="formModDati" action="modificaDatiEsperto" method="POST" enctype="multipart/form-data">
                <div class="credenziali">
                    <label for="nome">Nome</label><br>
                    <input type="text" id="nome" name="nomeEsp" value="${esperto.nome}" onclick="removeError('error1')">

                    <% if(error != null && error.contains("error=1")) {%>
                    <p id="error1" class="paragrafiRossi">Nome non consentito</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="cognome">Cognome</label><br>
                    <input type="text" id="cognome" name="cognomeEsp" value="${esperto.cognome}" onclick="removeError('error2')">

                    <% if(error != null && error.contains("error=2")) {%>
                    <p id="error2" class="paragrafiRossi">Cognome non consentito</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="newPass">Nuova password</label><br>
                    <input type="password" id="newPass" name="newPassEsp" onclick="removeError('error3')">

                    <% if(error != null && error.contains("error=6") ) {%>
                    <p id="error3" class="paragrafiRossi">Password troppo corta</p>
                    <%}%>
                </div>
                <div class="credenziali">
                    <label for="confNewPass">Conferma password</label><br>
                    <input type="password" id="confNewPass" name="confNewPassEsp" onclick="removeError('error4')">

                    <% if(error != null && error.contains("error=10") ) {%>
                    <p id="error4" class="paragrafiRossi">Password non coincidenti</p>
                    <%}%>
                </div>

                <div class="credenziali">
                    <label for="fotoEsperto">Seleziona una nuova immagine</label><br>
                    <input type="file" name="imgEsperto" id="fotoEsperto">
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
