<%@ page import="Model.Utente" %>
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
    %>

    <div id="navBarContainer">
        <nav>
            <ul class="mainMenu">
                <li id="logo">
                    <div>
                        <a href="index.jsp">PolyGlotPlanet</a>
                    </div>
                </li>

                <%if(u!=null && !u.isAdmin()){ %>
                <li id="liBenvenuto"><p id="benvenuto">Ciao, <%=u.getNome()%> ! </p></li>
                <%}%>
                <li><a href=""><img alt="carrello stilizzato" src="img/carrello.png"></a></li>
                <li>
                    <a><img alt="utente stilizzato" src="img/utente.png"></a>
                    <% if(u != null && !u.isAdmin()) {%>
                    <ul class="subMenu">
                        <li><a href="logout">Logout</a></li>
                        <li>
                            <a href="">Impostazioni</a>
                            <ul class="superSubMenu">
                                <li><a href="areaUtente.jsp">Dati personali</a></li>
                                <li><a href="">Mostra ordini</a></li>
                            </ul>
                        </li>
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