<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<html>
<head>
    <title>Impostazioni</title>

    <link type="text/css" href="css/general.css" rel="stylesheet">
    <script src="JavaScript/impostazioniUtente.js"></script>
</head>
<body>

    <%@ include file="header.jsp"%>

    <script>
        document.getElementById("impostazioni").style.display = "none";
    </script>

    <%
        Utente ut = (Utente) session.getAttribute("utente");
    %>

    <div id="mainContainer">
        <div id="topContainer">
            <button class="item" id="it1" onclick="modificaDati(0)">Modifica dati personali</button>
            <button class="item" id="it2" onclick="mostraOrdini(1)">I miei ordini</button>
            <button class="item" id="it3" onclick="mostraOrdini(2)">II</button>
        </div>

        <div id="bottomContainer">
            <div id="intestazione"><p>Compila i campi da modificare</p></div>
            <form action="modificaDatiUtente" method="POST">

                <%
                    String error = request.getParameter("error");

                    if(error != null) {
                    if(error.equals("1")) {%>
                    <div class="credenziali">Nome e cognome vuoti, riprova </div>
                <%} else if(error.equals("2")) {%>
                    <div class="credenziali">Le due password non coincidono, riprova </div>
                <%} else if(error.equals("3")) {%>
                    <div class="credenziali">La password deve contenere almeno 8 caratteri</div>
                <%}}%>

                <div class="credenziali">
                    <label for="nome">Nome</label>
                    <input type="text" id="nome" name="nome" value="<%=ut.getNome()%>">
                </div>
                <div class="credenziali">
                    <label for="cognome">Cognome</label>
                    <input type="text" id="cognome" name="cognome" value="<%=ut.getCognome()%>">
                </div>
                <div class="credenziali">
                    <label for="newPass">Nuova password</label>
                    <input type="password" id="newPass" name="newPass">
                </div>
                <div class="credenziali">
                    <label for="confNewPass">Conferma password</label>
                    <input type="password" id="confNewPass" name="confNewPass">
                </div>
                <div class="credenziali">
                    <input id="tastoConferma" type="submit" value="Conferma">
                </div>
            </form>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>
