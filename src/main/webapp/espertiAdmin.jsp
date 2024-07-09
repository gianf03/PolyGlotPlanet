<%@ page import="Model.Bean.Esperto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista esperti</title>
    <link rel="stylesheet" type="text/css" href="css/general.css">
</head>
<body>

    <%
        List<Esperto> esperti = (List<Esperto>) request.getAttribute("esperti");
    %>

    <div class="containerOfAll">
        <%@include file="WEB-INF/jsp/header.jsp"%>

        <table id="tableEsperti">
            <tr class="rigaEsperti">
                <th>ID</th>
                <th>Foto</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di nascita</th>
                <th>Email</th>
                <th>Genere</th>
                <th>Valutazione</th>
            </tr>

            <% for(Esperto esp : esperti) {%>
            <tr class="rigaEsperti">
                <td><%=esp.getID()%></td>
                <td>
                    <img id="imgEsperto" alt="foto esperto" src="<%=esp.getFotoRiconoscitiva()%>">
                </td>
                <td><%=esp.getNome()%></td>
                <td><%=esp.getCognome()%></td>
                <td><%=esp.getDataNascita()%></td>
                <td><%=esp.getEmail()%></td>
                <td><%=esp.getGenere()%></td>
                <td><%=esp.getValutazione()%></td>
                <td><button onclick="">Mostra colloqui</button></td>
                <td><button onclick="">Mostra incontri</button></td>
            </tr>
            <%}%>
        </table>
    </div>
</body>
</html>
