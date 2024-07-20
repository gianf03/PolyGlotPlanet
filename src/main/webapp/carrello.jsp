<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.*" %>
<%@ page import="Utils.Utility" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 17/07/2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>

    <link type="text/css" href="css/mieiOrdini.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <%
        if(request.getQueryString() != null && request.getQueryString().contains("error=22")) {%>
            <script>alert("Non è stato possibile inserire il prodotto nel carrello!")</script>
        <%} else if(request.getQueryString() != null && request.getQueryString().contains("error=26")) {%>
            <script>alert("Impossibile rimuovere elemento dal carrello!")</script>
    <%}

        List<Prodotto> prodotti = (List<Prodotto>) session.getAttribute("carrello");

        int numeroProdotti;
        if(prodotti == null || prodotti.isEmpty())
            numeroProdotti = 0;
        else
            numeroProdotti = prodotti.size();
    %>

    <%@include file="WEB-INF/jsp/header.jsp"%>
    <div id="containerOfAll">
        <% if(numeroProdotti==0){ %>
            <p id="nessunRisultato">
                Nessun prodotto nel carrello
            </p>

            <script>
                document.getElementById("containerOfAll").style.textAlign = "center";
            </script>
        <%} else {%>
        <div id="containerCarrello">
            <div class="infoCarrello">
                <div class="info">
                    <%  double totale=0;
                        DecimalFormat df = new DecimalFormat("0.00");
                        for(Prodotto pro : prodotti){
                            totale += pro.getPrezzoAttualeDouble();
                        }
                    %>
                    <p>TOTALE PROVVISIORIO : <br><%=df.format(totale)%> €</p>
                </div>

                <div class="info">
                    <p># PRODOTTI : <br><%=numeroProdotti%></p>
                </div>
            </div>

            <div id="prodottiCarrello">
                <%for(Prodotto p : prodotti) { %>
                    <div class="prodotto">
                        <%if (p.getCategoria().getID() == 1) {
                            Corso corso = (Corso) p; %>
                        <div class="imgContainer">
                            <img src="<%=corso.getLingua().getFotoStatoOrigine()%>" alt="<%=corso.getLingua().getNome()%>">
                        </div>

                        <div>
                            <p>
                                Corso di <%=corso.getLingua().getNome()%> livello <%=corso.getLivello()%>
                            </p>
                            <p>
                                Prezzo : <%=p.getPrezzoAttuale()%> €
                            </p>
                            <a class="rimuovi" href="rimuoviProdottoCarrello?IDProdotto=<%=p.getID()%>">
                                Rimuovi
                            </a>
                        </div>
                        <%} else if(p.getCategoria().getID() == 2) {
                            Incontro incontro = (Incontro) p;%>
                        <div class="imgContainer">
                            <img src="<%=incontro.getEsperto().getFotoRiconoscitiva()%>" alt="<%=incontro.getEsperto().getNome()%> <%=incontro.getEsperto().getCognome()%>">
                        </div>

                        <div>
                            <p>
                                Incontro con <%=incontro.getEsperto().getNome()%> <%=incontro.getEsperto().getCognome()%>
                                il <%=Utility.adjustDate(incontro.getDataOra().toString())%> in <%=incontro.getVia()%>
                                <%=incontro.getCivico()%>, <%=incontro.getCAP()%> in lingua <%=incontro.getLingua().getNome()%>
                            </p>
                            <p>
                                Prezzo : <%=p.getPrezzoAttuale()%> €
                            </p>
                            <a class="rimuovi" href="rimuoviProdottoCarrello?IDProdotto=<%=p.getID()%>">
                                Rimuovi
                            </a>
                        </div>
                        <%} else {
                            Colloquio colloquio = (Colloquio) p; %>
                        <div class="imgContainer">
                            <img src="<%=colloquio.getEsperto().getFotoRiconoscitiva()%>" alt="<%=colloquio.getEsperto().getNome()%> <%=colloquio.getEsperto().getCognome()%>">
                        </div>

                        <div>
                            <p>
                                Colloquio con <%=colloquio.getEsperto().getNome()%> <%=colloquio.getEsperto().getCognome()%>
                                il <%=Utility.adjustDate(colloquio.getDataOra().toString())%> in lingua <%=colloquio.getLingua().getNome()%>
                            </p>
                            <p>
                                Prezzo di acquisto : <%=p.getPrezzoAttuale()%> €
                            </p>
                            <a class="rimuovi" href="rimuoviProdottoCarrello?IDProdotto=<%=p.getID()%>">
                                Rimuovi
                            </a>
                        </div>
                    <%}%>
                </div>
            <%  } %>
            </div>

            <form id="ordina">
                <input type="submit" value="ORDINA" id="buttonOrdina">
            </form>
            <%if(session.getAttribute("utente") == null) {%>
            <script>
                let x = "ordina";
                document.getElementById("ordina").action = "loginUtente.jsp";
            </script>
            <%} else {%>
            <script>
                document.getElementById("ordina").action = "effettuaOrdine";
            </script>
            <%}%>
        <%}%>
        </div>
    </div>
    <%@include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
