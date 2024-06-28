<%@ page import="Model.Utente" %>
<%@ page session="true"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/header.css" rel="stylesheet">
</head>
<body>

    <header>
        <ul>
            <!--<li class="logo"><a class=logo href="index.jsp"><img class=logo src="img/logo.jpg"></a></li>-->
            <li class="dropdown">
                <a href=""><img src="img/utente.png"></a>
                <div class="dropdown-content">
<<<<<<< HEAD
                    <%!  Utente u = (Utente) session.getAttribute("utente"); %>
                    <%    if(u!=null && !u.isAdmin()){ %>
                        <a id="impostazioni" href="">Impostazioni</a>
=======
                    <%  Utente u = (Utente) session.getAttribute("utente");
                        if(u!=null && !u.isAdmin()){ %>
                        <a id="impostazioni" href="impostazioniUtente.jsp">Impostazioni</a>
>>>>>>> 1853fc7a86fd6b72356b16b29e1c65962b6947f0
                        <a id="logout" href="logout">Logout</a>
                    <%} else { %>
                        <a id="utente" href="loginUtente.jsp">Utente</a>
                        <a id="esperto" href="loginEsperto.jsp">Esperto</a>
                    <%}%>
                </div>
            </li>
            <li><a href=""><img src="img/carrello.png"></a></li>
            <%if(u!=null && !u.isAdmin()){ %>
            <li><p id="benvenuto">Ciao, <%=u.getNome()%> ! </p></li>
            <%}%>
        </ul>
    </header>
</body>
</html>
