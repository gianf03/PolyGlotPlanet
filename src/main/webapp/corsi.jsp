<%@ page import="Model.Bean.Corso" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Corsi</title>

    <!-- da dividere i css -->
    <link type="text/css" href="css/corsiColloquiIncontri.css" rel="stylesheet">


    <script src="JavaScript/chargeCorsi.js"></script>
    <script src="JavaScript/checkSelection.js"></script>
    <script src="JavaScript/showDropdownContent.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
<div id="containerOfAll">

    <%
        List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
        List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue"); %>

    <div id="f">
        <form onsubmit="event.preventDefault(); chargeCorsi()">

            <div id="containerFiltri">
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
                            <label for="<%=l.getCodISOLingua()%>"><%=l.getNome()%></label>
                        </div>
                        <%}%>
                    </div>
                </div>

                <div class="filtro" id="filtroPrezzo">
                    <%List<Integer> prezziCorsi = (List<Integer>) application.getAttribute("prezziCorsi");%>

                    <input type="checkbox" id="dropcheck-prezzi" class="dropcheck" onchange="showDropdownContentPrezzi()">
                    <label id="droplabel-prezzi" for="dropcheck-prezzi">Scegli prezzo (€)</label>

                    <div id="dropdown-content-prezzi" class="dropdown">
                        <div class="div-prezzo">
                            <p>da </p>
                            <select id="prezzoMin" onchange="checkSelection(<%=prezziCorsi.get(1)%>)">
                                <option value="niente"> </option>
                                <%for(int i=prezziCorsi.get(0); i<= prezziCorsi.get(1)-10; i=i+10) { %>
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

                <div class="filtro" id="filtroLivello">
                    <input type="checkbox" id="dropcheck-livelli" class="dropcheck" onchange="showDropdownContentLivelli()">
                    <label id="droplabel-livelli" for="dropcheck-livelli">Scegli livello</label>

                    <div id="dropdown-content-livelli" class="dropdown">

                        <div class="div-livello">
                            <input type="checkbox" id="livello1" name="livello" value="A1-A2">
                            <label for="livello1">A1-A2</label>
                        </div>
                        <div class="div-livello">
                            <input type="checkbox" id="livello2" name="livello" value="B1-B2">
                            <label for="livello2">B1-B2</label>
                        </div>
                        <div class="div-livello">
                            <input type="checkbox" id="livello3" name="livello" value="C1-C2">
                            <label for="livello3">C1-C2</label>
                        </div>

                    </div>
                </div>
            </div>

            <div class="filtro" id="submit">
                <input id="submitFiltro" type="submit" value="Cerca" onclick="closeAllDropdowns()">
            </div>

        </form>
    </div>

    <div id="containerCorsi">

    </div>

</div>
<%@include file="WEB-INF/jsp/footer.jsp"%>
<script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>