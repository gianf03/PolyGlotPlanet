<%@ page import="Model.Bean.Colloquio" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %><%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 07/07/2024
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colloqui</title>
    <link type="text/css" href="css/corsiColloquiIncontri.css" rel="stylesheet">

    <script src="JavaScript/checkSelection.js"></script>
    <script src="JavaScript/showDropdownContent.js"></script>
    <script src="JavaScript/chargeColloqui.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
    <div id="colloqui" class="containerOfAll">
        <%List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");
        if(request.getParameter("filtro") != null && request.getParameter("filtro").equals("true")) { %>
            <div id="f">
                <form onsubmit="event.preventDefault(); chargeColloqui()">
                    <div class="filtro" id="filtroLingua">
                        <input type="checkbox" id="dropcheck-lingue" class="dropcheck" onchange="showDropdownContentLingue()">
                        <label id="droplabel-lingue" for="dropcheck-lingue">Scegli lingue</label>

                        <div id="dropdown-content-lingue" class="dropdown">

                            <div class="div-lingua">
                                <input type="checkbox" id="all" onchange="selectDeselectAll()">
                                <label for="all">tutte</label>
                            </div>

                            <%for(Lingua l : lingue) {%>
                            <div class="div-lingua">
                                <input type="checkbox" id="<%=l.getCodISOLingua()%>" onclick="deselectTutte(<%=l.getCodISOLingua()%>)">
                                <label for="<%=l.getCodISOLingua()%>" style="cursor: pointer"><%=l.getNome()%></label>
                            </div>
                            <%}%>

                            <div class="div-lingua">

                                <input type="checkbox" id="closeLingue" style="display: none">
                                <label for="closeLingue" style="text-align: center; cursor: pointer;"
                                       onclick="document.getElementsByClassName('dropdown-content-lingue')[0].style.display = 'none';
                                       document.getElementById('dropcheck-lingue').checked = false;"> chiudi </label>

                            </div>
                        </div>
                    </div>

                    <div class="filtro" id="filtroPrezzo">
                        <%
                            List<Integer> prezziColloqui = (List<Integer>) application.getAttribute("prezziColloqui");
                        %>

                        <input type="checkbox" id="dropcheck-prezzi" class="dropcheck" onchange="showDropdownContentPrezzi()">
                        <label id="droplabel-prezzi" for="dropcheck-prezzi">Scegli prezzo (€)</label>

                        <div id="dropdown-content-prezzi" class="dropdown">
                            <div class="div-prezzo">
                                <p>da </p>
                                <select id="prezzoMin" onchange="checkSelection(<%=prezziColloqui.get(1)%>)">
                                    <option value="niente"> </option>
                                    <%for(int i=prezziColloqui.get(0); i<= prezziColloqui.get(1)-10; i=i+10) { %>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </div>

                            <div class="div-prezzo">
                                <p>a </p>
                                <select id="prezzoMax" disabled></select>
                            </div>
                        </div>
                    </div>

                    <div class="filtro" id="filtroDataOra">
                        <input type="checkbox" id="dropcheck-data" class="dropcheck" onchange="showDropdownContentData()">
                        <label id="droplabel-data" for="dropcheck-data">Scegli data e ora</label>

                        <div id="dropdown-content-data" class="dropdown">

                            <div class="div-data">
                                <input type="datetime-local" id="dataOra" required>
                            </div>
                        </div>

                    </div>
                        <script>
                            // Funzione per ottenere l'ora successiva a quella attuale
                            function minDate() {
                                let today = new Date();
                                let year = today.getFullYear();
                                let month = today.getMonth()+1; //i mesi partono da 0
                                let day = today.getDate();
                                let hour = today.getHours() + 1;

                                if(month<10) month = '0' + month;
                                if(day<10) day = '0' + day;
                                if(hour<10) hour = '0' + hour;

                                let date = year + '-' + month + '-' + day + 'T' + hour + ':00';
                                return date;
                            }

                            document.getElementById("dataOra").min = minDate();
                        </script>
                    <div class="filtro" id="submit">
                        <input id="submitFiltro" type="submit" value="Cerca">
                    </div>
                </form>
            </div>
        <%}%>

        <div id="containerColloqui">

        </div>

        <div id="pagesContainer">

        </div>

        <% if(request.getParameter("filtro") == null || !request.getParameter("filtro").equals("true")) { %>
        <a id="anchorMostraTuttiColloqui" href="colloqui.jsp?filtro=true">
            <div id="mostraTuttiColloquiContainer">
                <p id="mostraTuttiColloqui">Indeciso su quale lingua apprendere? Vedi tutti i colloqui</p>
            </div>
        </a>
        <%}%>


    </div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
