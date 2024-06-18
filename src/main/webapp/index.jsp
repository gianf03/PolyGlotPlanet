<%@ page import="java.util.List" %>
<%@ page import="Model.Lingua" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Home</title>
    <link type="text/css" href="css/homeCSS.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

    <%@ include file="header.jsp"%>

    <section id="outer-container">
        <div id="flex-container">

            <%
                List<Lingua> lingue = (List<Lingua>) application.getAttribute("lingue");

                for(int i = 0; i < 45; i++) { %>

                    <a class="linkLingua" href=""><div class="flex-item" id="<%=i+1%>">
                        <img class="foto-lingue" src="<%=lingue.get(i).getFotoStatoOrigine()%>">
                        <p class="nomeLingua"><%= lingue.get(i).getNome()%></p>
                    </div></a>

                    <% if(i >= 6) {%> <!--parentesi graffa obbligatoria altrimenti è come se l'if non ci fosse-->
                        <script>
                            document.getElementById("<%=i+1%>").style.display = "none";
                        </script>
                    <%}%>

            <%}%>

            <div id="divPlus"><button id="plus" onclick="chargeAllStates()"><img id="imgPlus" src="img/plus.png"></button></div>
        </div>
    </section>

    <script>
        function chargeAllStates() {
            for (let i = 6; i <= 45; i++) {
                document.getElementById(i).style.display = "";
            }


            //ottengo la larghezza corrente della finestra del browser
            let w = screen.width;


            let numLingue = <%=lingue.size()%>;

            //calcolo l'altezza del flex-container in base al numero di lingue contenute
            let flexItem = document.getElementsByClassName("flex-item")[0];
            let heightFlexItem = window.getComputedStyle(flexItem).getPropertyValue("height");
            let marginFlexItem = window.getComputedStyle(flexItem).getPropertyValue("margin");

            //elimino l'unita di misura px dalla stringa per usare il valore nella moltiplicazione
            heightFlexItem = heightFlexItem.replace("px","");
            marginFlexItem = marginFlexItem.replace("px","");

            let heightFlexContainer = (parseInt(heightFlexItem) + parseInt(marginFlexItem) * 2);

            console.log(numLingue);

            if(w > 900) {
                if(numLingue % 3 === 0) heightFlexContainer *= (numLingue / 3 + 1);
                else heightFlexContainer *= (numLingue / 3 + 2);
                document.getElementById("flex-container").style.height = heightFlexContainer+"px";
            } else if(w >=650 && w <= 900) {
                if(numLingue % 2 === 0) heightFlexContainer *= (numLingue / 2 + 1);
                else heightFlexContainer *= (numLingue / 2 + 2);
                document.getElementById("flex-container").style.height = heightFlexContainer+"px";
            } else {
                heightFlexContainer *= numLingue + 1;
                document.getElementById("flex-container").style.height = heightFlexContainer+"px";
                console.log(heightFlexContainer);
            }

            document.getElementById("imgPlus").setAttribute("src","img/meno.png");
        }
    </script>


    <%@ include file="footer.jsp"%>
</body>
</html>