<%@ page import="Model.Bean.Conoscenza" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Le mie lingue</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" href="css/general.css" rel="stylesheet">
</head>
<body>

<%@include file="WEB-INF/jsp/header.jsp"%>

    <%
        List<Conoscenza> conoscenze = (List<Conoscenza>) request.getAttribute("conoscenzeEsp");
    %>

    <div class="containerOfAll">

        <table id="tableLingue">
            <tr id="rigaLingue">
                <th>ID</th>
                <th>Lingua</th>
            </tr>

            <%for(Conoscenza c : conoscenze) {%>
            <tr class="rigaCorsi">
                <td><%=c.getLingua().getCodISOLingua()%></td>
                <td><%=c.getLingua().getNome()%></td>
                <td><img id="imgLingua" alt="immagine stato origine lingua" src="<%=c.getLingua().getFotoStatoOrigine()%>"></td>
                <td><button>Rimuovi</button></td>
            </tr>
            <%}%>
        </table>
    </div>


<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
