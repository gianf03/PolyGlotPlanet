<%@ page import="Model.Bean.Utente" %>
<%@ page import="Model.Bean.Esperto" %>
<%@ page session="true"%>
<html>
<head>
    <title>Title</title>
    <link title="foglio di stile" type="text/css" href="css/header.css" rel="stylesheet">
</head>
<body>

<header id="header">

    <%
        Utente u = (Utente) session.getAttribute("utente");
        Esperto e = (Esperto) session.getAttribute("esperto");

    %>

    <div id="navBarContainer">
        <nav>
            <ul class="mainMenu">
                <li id="logo">
                    <div id="divLogo">
                        <%if(u != null && u.isAdmin()) {%>
                            <a href="homeAdmin.jsp">PolyGlotPlanet</a>
                        <%} else if (e != null){%>
                            <a href="homeEsperto.jsp">PolyGlotPlanet</a>
                        <%} else {%>
                            <a href="index.jsp">PolyGlotPlanet</a>
                        <%}%>
                    </div>
                </li>

                <%if((u!=null && !u.isAdmin()) || e!=null){ %>
                    <li id="liBenvenuto">
                        <div id="divBenvenuto">
                            <%if(u!=null) {%>
                                <p id="benvenutoUtente">Ciao, <%=u.getNome()%> ! </p>
                            <%} else {%>
                                <p id="benvenutoEsperto">Ciao, <%=e.getNome()%> ! </p>
                            <%}%>
                        </div>
                    </li>
                <%}%>
                <%if (e==null && u==null || (u!=null && !u.isAdmin())) {%>
                    <li>
                        <a href="">
                            <img alt="carrello stilizzato" src="img/carrello.png">
                        </a>
                    </li>
                <%}%>
                <li>
                    <a><img alt="utente stilizzato" src="img/utente.png"></a>
                    <% if(u != null && !u.isAdmin()) {%>
                        <ul class="subMenu">
                            <li><a href="logout">Logout</a></li>
                            <li>
                                <a href="">Impostazioni</a>
                                <ul class="superSubMenu">
                                    <li><a href="areaUtente.jsp">Dati personali</a></li>
                                    <li><a href="mostraOrdiniUtente?IDUtente=<%=u.getID()%>">Mostra ordini</a></li>
                                </ul>
                            </li>
                        </ul>
                    <%} else if(e != null){%>
                        <ul class="subMenu">
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    <%} else if(u!=null && u.isAdmin()) {%>
                        <ul class="subMenu">
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    <%} else {%>
                        <ul class="subMenu">
                        <li><a href="loginUtente.jsp">Utente</a></li>
                        <li><a href="loginEsperto.jsp">Esperto</a></li>
                    </ul>
                    <%}%>
                </li>
            </ul>
        </nav>
    </div>
</header>
</body>
</html>