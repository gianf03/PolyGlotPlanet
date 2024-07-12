<%@ page import="Model.Bean.Corso" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista corsi</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/modificaCorso.js"></script>
</head>
<body>

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
    %>
    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">

        <div id="divFiltri">
            <div class="dropdown">
                <button class="dropbtn">Ordina per</button>
                <div class="dropdown-content">
                    <a href="tuttiCorsi?ordPer=prezzoBase&tipo=asc">Prezzo crescente</a>
                    <a href="tuttiCorsi?ordPer=prezzoBase&tipo=desc">Prezzo decrescente</a>
                    <a href="tuttiCorsi?ordPer=livello&tipo=asc">Livello</a>
                </div>
            </div>
        </div>


        <table id="tableCorsi">
            <tr id="rigaCorsi">
                <th>ID</th>
                <th>Lingua</th>
                <th>Descrizione</th>
                <th>Numero unità</th>
                <th>Livello</th>
                <th>Prezzo base</th>
                <th>Sconto percentuale</th>
                <th>Disponibile</th>
            </tr>

            <%for(Corso c : corsi) {%>
                    <tr class="rigaCorsi">
                        <td><%=c.getID()%></td>
                        <td>
                            <%=c.getLingua().getNome()%>
                            <img id="imgLingua" alt="immagine stato origine lingua" src="<%=c.getLingua().getFotoStatoOrigine()%>">
                        </td>
                        <td><%=c.getDescrizione()%></td>
                        <td><%=c.getNumeroUnita()%></td>
                        <td><%=c.getLivello()%></td>
                        <td><%=c.getPrezzoBase()%> €</td>
                        <td><%=c.getScontoPercentuale()%> %</td>
                        <td><%=c.isDisponibile()%></td>
                        <td>
                            <button onclick="modificaCorso(<%=c.getID()%>,<%=c.getPrezzoBase()%>, <%=c.getScontoPercentuale()%>)">Modifica</button>
                        </td>
                    </tr>
            <%}%>
        </table>

        <div id="divModifica">
            <form action="modificaProdotto" method="GET">
                <div class="datiMod">
                    <input type="hidden" name="IDProdotto" id="idProd">
                </div>
                <div class="datiMod">
                    <p>Disponibile: </p>
                    <label for="disponibile">Si</label>
                    <input type="radio" name="disponibile" id="disponibile" value="true" checked>
                    <label for="nonDisponibile">No</label>
                    <input type="radio" name="disponibile" id="nonDisponibile" value="false"><br>
                </div>

                <div class="datiMod">
                    <label for="prBase">Prezzo base</label><br>
                    <input type="text" name="prezzoBase" id="prBase"><br>
                </div>

                <div class="datiMod">
                    <label for="sconto">Sconto</label><br>
                    <input type="text" name="scontoPercentuale" id="sconto"><br>
                </div>

                <div class="datiMod">
                    <input type="submit" value="Conferma">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
