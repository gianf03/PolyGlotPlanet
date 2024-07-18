<%@ page import="Model.Bean.Corso" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista corsi</title>
    <link type="text/css" href="css/admin.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/modificaCorso.js"></script>
    <script src="JavaScript/showElemById.js"></script>
</head>
<body>

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
        List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

        String insertion = request.getParameter("insertion");

        if(insertion != null && insertion.equals("good")) {%>
            <script>alert("Inserimento avvenuto con successo!")</script>
    <%} else if(request.getParameter("error") != null){%>
            <script>alert("Corso non aggiunto!")</script>
    <%}
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

            <button class="dropbtn" onclick="showElemById('aggiungiCorso')">Aggiungi corso</button>
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
                            <button id="btnModifica" onclick="modificaCorso(<%=c.getID()%>,<%=c.getPrezzoBase()%>, <%=c.getScontoPercentuale()%>)">Modifica</button>
                        </td>
                    </tr>
            <%}%>
        </table>

        <div id="divModifica">
            <form action="modificaCorso">
                <div class="datiMod">
                    <input type="hidden" name="IDProdotto" id="idProd">
                </div>
                <div class="datiMod">
                    <p>Disponibile: </p>
                    <label for="disponibile">Si</label>
                    <input type="radio" name="disponibile" id="disponibile" value="true" checked>
                    <label for="nonDisponibile">No</label>
                    <input type="radio" name="disponibile" id="nonDisponibile" value="false">
                </div>

                <div class="datiMod">
                    <label for="prBase">Prezzo base</label><br>
                    <input type="text" name="prezzoBase" id="prBase">
                </div>

                <div class="datiMod">
                    <label for="sconto">Sconto</label><br>
                    <input type="text" name="scontoPercentuale" id="sconto">
                </div>

                <div class="datiMod">
                    <input class="btnConferma" type="submit" value="Conferma">
                    <button type="button" class="btnChiudi" onclick="hideElemById('divModifica')">Chiudi</button>
                </div>
            </form>
        </div>

        <div id="aggiungiCorso">
            <form action="aggiungiCorso">
                <div class="aggiungiCorsoItem">
                    <label for="linguaCorso">Lingua</label><br>
                    <select id="linguaCorso" name="codISOLingua">
                        <%
                            for(Lingua l : lingue) {%>
                                <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                        <%}%>
                    </select>
                </div>

                <div class="aggiungiCorsoItem">
                    <label for="descCorso">Descrizione</label><br>
                    <textarea name="descrizione" id="descCorso"></textarea>
                </div>

                <div class="aggiungiCorsoItem">
                    <label for="numUniCorso">Numero unità</label><br>
                    <input type="text" name="numeroUnita" id="numUniCorso">
                </div>

                <div class="aggiungiCorsoItem">
                    <label for="livCorso">Livello</label><br>
                    <select name="livello" id="livCorso">
                        <option value="A1-A2">A1-A2</option>
                        <option value="B1-B2">B1-B2</option>
                        <option value="C1-C2">C1-C2</option>
                    </select>
                </div>

                <div class="aggiungiCorsoItem">
                    <label for="prBaseCorso">Prezzo base</label><br>
                    <input type="text" name="prezzoBase" id="prBaseCorso">
                </div>

                <div class="aggiungiCorsoItem">
                    <label for="scontoCorso">Sconto</label><br>
                    <input type="text" name="scontoPercentuale" id="scontoCorso">
                </div>

                <div class="aggiungiCorsoItem">
                    <input class="btnAggiungi" type="submit" value="Aggiungi">
                    <button type="button" class="btnChiudi" onclick="hideElemById('aggiungiCorso')">Chiudi</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
