function chargeAllStates(categoria) {

    for (let i = 6; i <= 45; i++) {
        document.getElementById(i).style.display = ""; //prendo i flex-item non mostrati e li mostro
    }

    document.getElementById("flex-container").style.height = "inherit"; //indispesabile


    document.getElementById("plus").remove();  //rimuovo button
    newAnchor = document.createElement("a");
    document.getElementById("divPlus").appendChild(newAnchor);  //al posto di button metto un anchor che contiene un img

    newAnchor.setAttribute("id", "linkMinus");
    newAnchor.setAttribute("href", "sceltaLingua.jsp?categoria="+categoria);   //creo anchor che conterrà un img
    newAnchor.setAttribute("title", "mostra meno lingue");

    minus = document.createElement("img");
    newAnchor.appendChild(minus);

    minus.setAttribute("id", "imgMinus");
    minus.setAttribute("src", "img/meno_1.png");
    minus.setAttribute("alt", "mostra meno lingue");
}