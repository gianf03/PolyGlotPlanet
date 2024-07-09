<%@ page import="Model.Corso" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista corsi</title>
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
    %>

    <div class="containerOfAll">
        <%@include file="WEB-INF/jsp/header.jsp"%>

        <table id="tableCorsi">
            <tr class="rigaCorsi">
                <th>ID</th>
                <th>Lingua</th>
                <th>Descrizione</th>
                <th>Numero unità</th>
                <th>Livello</th>
                <th>Prezzo base</th>
                <th>Sconto percentuale</th>
            </tr>

            <% for(Corso c : corsi) {%>
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
                <td><button>Modifica</button></td>
            </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
