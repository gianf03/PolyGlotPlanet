<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area admin</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/modificaCorso.js"></script>
    <script src="JavaScript/showElemById.js"></script>
</head>
<body>

    <%
        if(request.getQueryString() != null && request.getQueryString().equals("error=24")){%>
            <script>alert("Esperto inesistente!")</script>
    <%}

        String insertion = request.getParameter("insertion");

        if(insertion != null && insertion.equals("good")) {%>
            <script>alert("Inserimento avvenuto con successo!")</script>
    <%}%>

<%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <div id="containerAdmin">
            <div class="adminSettings">
                <div class="settingsImg">
                    <img alt="utente stilizzato" src="img/user.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraUtenti">Mostra utenti</a>
                </div>
            </div>
            <div class="adminSettings">
                <div class="settingsImg">
                    <img alt="insegnante stilizzato" src="img/insegnante.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraEsperti">Mostra esperti</a>
                </div>
            </div>
            <div class="adminSettings">
                <div class="settingsImg">
                    <img alt="libro stilizzato" src="img/categorie/corso.png">
                </div>

                <div class="settingsLink">
                    <a href="mostraCorsiAdmin">Mostra corsi</a>
                </div>
            </div>
            <div class="adminSettings">
                <div class="settingsImg">
                    <img alt="lingua stilizzata" src="img/lingua.png">
                </div>

                <div class="settingsLink">
                    <a href="#" onclick="showElemById('aggiungiLingua')">Aggiungi lingua</a>
                </div>
            </div>
        </div>

        <div id="aggiungiLingua">
            <form action="aggiungiLingua" method="POST" enctype="multipart/form-data">
                <div class="aggiungiLinguaItem">
                    <label for="codISO">Codice ISO</label><br>
                    <input type="text" name="codISOLingua" id="codISO" required>
                </div>

                <div class="aggiungiLinguaItem">
                    <label for="nomeLingua">Nome</label><br>
                    <input type="text" name="nomeLingua" id="nomeLingua" required>
                </div>

                <div class="aggiungiLinguaItem">
                    <label for="numParlanti">Numero parlanti</label><br>
                    <input type="text" name="parlanti" id="numParlanti" required>
                </div>

                <div class="aggiungiLinguaItem">
                    <label for="fotoLingua">Immagine stato origine</label><br>
                    <input type="file" name="fotoStatoOrigine" id="fotoLingua" required>
                </div>

                <div class="aggiungiLinguaItem">
                    <input class="btnAggiungi" type="submit" value="Aggiungi">
                    <button type="button" class="btnChiudi" onclick="hideElemById('aggiungiLingua')">Chiudi</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
