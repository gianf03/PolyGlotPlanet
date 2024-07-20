<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Lingua" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Scegli lingua</title>
    <link type="text/css" href="css/sceltaLingua.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="JavaScript/chargeAllStates.js"></script>

    <!--anche se sottolineato giallo non modificare-->
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp"%>
    <div id="containerOfAll">

        <h1 id="sceltaLingua">Seleziona una lingua :</h1>

        <%String categoria = request.getParameter("categoria"); %>
        <section id="outer-container">
            <div id="flex-container">
                <%
                    List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                    for(int i = 0; i < 45; i++) {
                        String address;
                        if (request.getParameter("categoria").equals("corso"))
                            address = "corsi.jsp";
                        else if (request.getParameter("categoria").equals("incontro"))
                            address = "incontri.jsp";
                        else
                            address = "colloqui.jsp";
                    %>
                        <div class="flex-item" id="<%=i+1%>">
                            <a class="linkLingua" href='<%=address%>?codLingua=<%=lingue.get(i).getCodISOLingua()%>&filtro=false'>
                                <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>" alt="<%=lingue.get(i).getNome()%>">
                                <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                            </a>
                        </div>

                        <% if(i >= 6) {%> <!--parentesi graffa obbligatoria altrimenti è come se l'if non ci fosse-->
                            <script>
                                document.getElementById("<%=i+1%>").style.display = "none";
                            </script>
                        <%}%>

                <%}%>

                <div id="divPlus">
                    <label for="plus"></label>
                    <button id="plus" onclick="chargeAllStates(<%=lingue.size()%>, '<%=request.getParameter("categoria")%>')">
                        <img id="imgPlus" src="img/plus_1.png" alt="mostra più lingue">
                    </button>
                </div>
            </div>
        </section>

        <div id="fondoPagina">

            <p id="indeciso">Indeciso su quale lingua apprendere?</p>

            <% if (categoria.equals("corso")){ %>
                <a class="mostraTutto" href='corsi.jsp?codLingua=all&filtro=false'>Vedi tutti i corsi</a>
            <%} else if (categoria.equals("colloquio")){ %>
                <a class="mostraTutto" href='colloqui.jsp?codLingua=all&filtro=false'>Vedi tutti i colloqui</a>
            <%} else { %>
                <a class="mostraTutto" href='incontri.jsp?codLingua=all&filtro=false'>Vedi tutti gli incontri</a>
            <%}%>

        </div>
    </div>
<%@ include file="WEB-INF/jsp/footer.jsp"%>
    <!--anche se sottolineato giallo non modificare-->
    <script src="JavaScript/cambiaAltezza.js"></script>
    <script src="JavaScript/resizeContainer.js"></script>
</body>
</html>