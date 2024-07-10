<%@ page import="Model.Bean.Corso" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Corsi</title>

    <link type="text/css" href="css/general.css" rel="stylesheet">
    <script src="JavaScript/filterByLanguagePriceAndLevel.js"></script>
    <script src="JavaScript/checkSelection.js"></script>
    <script src="JavaScript/showDropdownContent.js"></script>
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
<div class="containerOfAll">

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
        List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

        if(request.getParameter("lingua") == null) { %>

    <div id="f">
        <form onsubmit="filterByLanguagePriceAndLevel()">

            <div class="filtro" id="filtroLingua">
                <input type="checkbox" id="dropcheck-lingue" onchange="showDropdownContent()">
                <label id="droplabel-lingue" for="dropcheck-lingue">Scegli lingue</label>
                <div class="dropdown-content-lingue">
                    <div class="div-lingua">
                        <input type="checkbox" id="all" onchange="selectDeselectAll()">
                        <label for="all">tutte</label>
                    </div>
                    <%for(Lingua l : lingue) {%>
                    <div class="div-lingua">
                        <input type="checkbox" id="<%=l.getCodISOLingua()%>" onclick="deselectTutte(<%=l.getCodISOLingua()%>)">
                        <label for="<%=l.getCodISOLingua()%>"><%=l.getNome()%></label>
                    </div>
                    <%}%>
                </div>
            </div>

            <div class="filtro" id="filtroPrezzo">
                <%
                    List<Integer> prezziCorsi = (List<Integer>) application.getAttribute("prezziCorsi");
                %>
                <label>Scegli il prezzo in euro : </label><br>
                <p>da </p>
                <select id="prezzoMin" onchange="checkSelection(<%=prezziCorsi.get(1)%>)">
                    <option value="niente"> </option>
                    <%for(int i=prezziCorsi.get(0); i<= prezziCorsi.get(1)-10; i=i+10) { %>
                    <option value="<%=i%>"><%=i%></option>
                    <%}%>
                </select><br>

                <p>a </p>
                <select id="prezzoMax" disabled></select>
            </div>

            <div class="filtro" id="filtroLivello">
                <label>Seleziona livello : </label><br>
                <input type="checkbox" id="livello1" name="livello" value="A1-A2">
                <label for="livello1">A1-A2</label><br>
                <input type="checkbox" id="livello2" name="livello" value="B1-B2">
                <label for="livello2">B1-B2</label><br>
                <input type="checkbox" id="livello3" name="livello" value="C1-C2">
                <label for="livello3">C1-C2</label><br>
            </div>
            <div class="filtro" id="submit">
                <input type="submit" value="submit">
            </div>

        </form>
    </div>
    <%}%>

    <div id="fatherOfCoursesDivs">
        <%
            int i=1;
            for(Corso c : corsi) {
        %>

        <div class="containerCorso">
            <div class="corsoItem" id="c1_<%=i%>">
                <img class="imgLinguaCorso" src="<%=c.getLingua().getFotoStatoOrigine()%>">
            </div>
            <div class="corsoItem" id="c2_<%=i%>">
                <p class="infoCorso" id="p1_<%=i%>">Livello : <%=c.getLivello()%></p>
                <p class="infoCorso" id="p2_<%=i%>">Numero unità : <%=c.getNumeroUnita()%></p>
                <p class="infoCorso" id="p3_<%=i%>"><%=c.getDescrizione()%></p>
            </div>
            <div class="corsoItem" id="c3_<%=i%>">
                <div class="prezzo"><%=c.getPrezzoAttuale()%> €</div>
                <div class="carrello"><button class="bt">Aggiungi al carrello</button></div>
            </div>
        </div>
        <%  i++;}%>
    </div>


    <% if(request.getParameter("lingua") != null) { %>
    <a id="anchorMostraTuttiCorsi" href="tuttiCorsi">
        <div id="mostraTuttiCorsiContainer">
            <p id="mostraTuttiCorsi">Indeciso su quale lingua apprendere? Vedi tutti i corsi</p>
        </div>
    </a>
    <%}%>
</div>
<%@include file="WEB-INF/jsp/footer.jsp"%>

<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>