<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.*" %>
<%@ page import="Utils.Utility" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 16/07/2024
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I miei ordini</title>

    <link rel="stylesheet" type="text/css" href="css/mieiOrdini.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%
        List<Ordine> ordini = (List<Ordine>) request.getAttribute("ordini");
        List<List<Composizione>> listaComposizioniOrdini = (List<List<Composizione>>) request.getAttribute("listaComposizioniOrdini");
    %>

    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div class="containerOfAll">
        <% if(ordini.isEmpty()) { %>
            <p id="nessunRisultato">
                Non hai ancora effettuato il tuo primo ordine
            </p>

            <script>
                document.getElementsByClassName("containerOfAll")[0].style.textAlign = "center";
            </script>
        <% } else {
                for (int i = 0; i< ordini.size(); i++) {%>
                    <div class="containerOrdine">
                        <div class="infoOrdine">
                            <div class="info">
                                <p>ORDINE EFFETTUATO IL : <br><%=Utility.adjustDate(ordini.get(i).getDataOra().toString())%></p>
                            </div>

                            <div class="info">
                                <p>TOTALE : <br><%=ordini.get(i).getPrezzoTotale()%>€</p>
                            </div>

                            <div class="info">
                                <p>ORDINE #: <br><%=ordini.get(i).getID()%></p>
                            </div>
                        </div>

                        <div class="prodottiOrdine">
                        <% for(int j = 0; j<ordini.get(i).getNumeroProdotti(); j++) {
                            Composizione c = listaComposizioniOrdini.get(i).get(j); %>

                            <div class="prodotto">
                            <%if (c.getProdotto().getCategoria().getID() == 1) {
                                Corso corso = (Corso) c.getProdotto(); %>
                                <div class="imgContainer">
                                    <img src="<%=corso.getLingua().getFotoStatoOrigine()%>">
                                </div>

                                <div>
                                    <p>
                                        Corso di <%=corso.getLingua().getNome()%> livello <%=corso.getLivello()%>
                                    </p>
                                    <p>
                                        Prezzo di acquisto : <%=c.getPrezzoAcquisto()%> €
                                    </p>
                                </div>
                            <%} else if(c.getProdotto().getCategoria().getID() == 2) {
                                Incontro incontro = (Incontro) c.getProdotto();%>
                                <div class="imgContainer">
                                    <img src="<%=incontro.getEsperto().getFotoRiconoscitiva()%>">
                                </div>

                                <div>
                                    <p>
                                        Incontro con <%=incontro.getEsperto().getNome()%> <%=incontro.getEsperto().getCognome()%>
                                        il <%=Utility.adjustDate(incontro.getDataOra().toString())%> in <%=incontro.getVia()%>
                                        <%=incontro.getCivico()%>, <%=incontro.getCAP()%> in lingua <%=incontro.getLingua().getNome()%>
                                    </p>
                                    <p>
                                        Prezzo di acquisto : <%=c.getPrezzoAcquisto()%> €
                                    </p>
                                </div>
                            <%} else {
                                Colloquio colloquio = (Colloquio) c.getProdotto(); %>
                                <div class="imgContainer">
                                    <img src="<%=colloquio.getEsperto().getFotoRiconoscitiva()%>">
                                </div>

                                <div>
                                    <p>
                                        Colloquio con <%=colloquio.getEsperto().getNome()%> <%=colloquio.getEsperto().getCognome()%>
                                        il <%=Utility.adjustDate(colloquio.getDataOra().toString())%> in lingua <%=colloquio.getLingua().getNome()%>
                                    </p>
                                    <p>
                                        Prezzo di acquisto : <%=c.getPrezzoAcquisto()%> €
                                    </p>
                                </div>
                            <%}%>
                            </div>
                        <%}%>
                        </div>
                    </div>
        <%      }
            } %>
    </div>
    <%@include file="WEB-INF/jsp/footer.jsp"%>

    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
