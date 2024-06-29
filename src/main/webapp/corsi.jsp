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
                <select id="selectLingua" multiple>
                    <%for(Lingua l : lingue) { %>
                        <option value="<%=l.getCodISOLingua()%>"><%=l.getNome()%></option>
                    <%}%>
                </select>
                <input type="submit" value="submit">
            </form>
    <%}%>


    <div id="fatherOfCoursesDivs">
    <%
        for(Corso c : corsi) {
            int i = 0;
    %>

        <div class="containerCorso">
            <div class="corsoItem" id="c1_"+<%=i%>>
                <%
                    for(Lingua l : lingue) {
                        if(l.getCodISOLingua().equals(c.getCodISOLingua()))
                            foto = l.getFotoStatoOrigine();
                    }
                %>
                <img class="imgLinguaCorso" src="<%=foto%>">
            </div>
            <div class="corsoItem" id="c2_"+<%=i%>>
                <p class="infoCorso" id="p1_"+<%=i%>>Livello : <%=c.getLivello()%></p>
                <p class="infoCorso" id="p2_"+<%=i%>>Numero unità : <%=c.getNumeroUnita()%></p>
                <p class="infoCorso" id="p3_"+<%=i%>><%=c.getDescrizione()%></p>
            </div>
            <div class="corsoItem" id="c3_"+<%=i%>>
                <div class="prezzo"><%=c.getPrezzoScontato()%> €</div>
                <div class="carrello"><button class="bt">Aggiungi al carrello</button></div>
            </div>
        </div>

    <%  i++;
        }%>

    </div>


    <% if(request.getParameter("lingua") != null) { %>
        <a href="tuttiCorsi">Indeciso su quale lingua apprendere? Vedi tutti i corsi</a>
    <%}%>


    <%@include file="footer.jsp"%>

</body>
</html>
