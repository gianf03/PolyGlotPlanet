<%@ page import="Model.Corso" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Corsi</title>

    <link type="text/css" href="css/general.css" rel="stylesheet">
    <script src="JavaScript/filterByLanguage.js"></script>
</head>
<body>

    <%@include file="header.jsp"%>

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
        List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");
        String foto = null;

        if(request.getParameter("lingua") == null) { %>

            <form onsubmit="filterByLanguage()">
                <label for="selectLingua">Seleziona una lingua:</label>
                <select id="selectLingua">
                    <%for(Lingua l : lingue) { %>
                        <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                    <%}%>
                </select>
                <input type="submit" value="submit">
            </form>
    <%}%>

    <%
        for(Corso c : corsi) {
    %>

        <div class="containerCorso">
            <div class="corsoItem">
                <%
                    for(Lingua l : lingue) {
                        if(l.getCodISOLingua().equals(c.getCodISOLingua()))
                            foto = l.getFotoStatoOrigine();
                    }
                %>
                <img id="imgLinguaCorso" src="<%=foto%>">
            </div>
            <div class="corsoItem">
                <p class="infoCorso">Livello: <%=c.getLivello()%></p>
                <p class="infoCorso">Numero unità: <%=c.getNumeroUnita()%></p>
                <p class="infoCorso"><%=c.getDescrizione()%></p>
            </div>
            <div class="corsoItem">
                <div id="prezzo"><p><%=c.getPrezzoBase()%> €</p></div>
                <div id="carrello"><button>Aggiungi al carrello</button></div>
            </div>
        </div>

    <%}%>

    <% if(request.getParameter("lingua") != null) { %>
        <a href="tuttiCorsi">Indeciso su quale lingua apprendere? Vedi tutti i corsi</a>
    <%}%>


    <%@include file="footer.jsp"%>

</body>
</html>
