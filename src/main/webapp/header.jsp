<%@ page import="Model.Utente" %>
<%@ page session="true"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/header.css" rel="stylesheet">
</head>
<body>

    <header>
        <ul id="listaHeader">
            <!--<li class="logo"><a class=logo href="index.jsp"><img class=logo src="img/logo.jpg"></a></li>-->
            <li class="dropdown">
                <a href=""><img src="img/utente.png"></a>
                <div class="dropdown-content">
                    <% Utente u = (Utente) session.getAttribute("utente");
                      if(u!=null && !u.isAdmin()){ %>
                        <a id="impostazioni" href="impostazioniUtente.jsp">Impostazioni</a>
                        <a id="logout" href="logout">Logout</a>
                    <%} else { %>
                        <a id="utente" href="loginUtente.jsp">Utente</a>
                        <a id="esperto" href="loginEsperto.jsp">Esperto</a>
                    <%}%>
                </div>
            </li>
            <li id="imgCarrello"><a href=""><img src="img/carrello.png"></a></li>
            <%if(u!=null && !u.isAdmin()){ %>
            <li id="liBenvenuto"><p id="benvenuto">Ciao, <%=u.getNome()%> ! </p></li>
            <%}%>
        </ul>
    </header>
</body>
</html>
