function chargeAllStates(numLingue, categoria) {

    for (let i = 6; i <= 45; i++) {
        document.getElementById(i).style.display = "";
    }


    //ottengo la larghezza corrente della finestra del browser
    let w = window.innerWidth;  //uso il BOM

    //calcolo l'altezza del flex-container in base al numero di lingue contenute
    let flexItem = document.getElementsByClassName("flex-item")[0];
    let heightFlexItem = window.getComputedStyle(flexItem).getPropertyValue("height");
    let marginFlexItem = window.getComputedStyle(flexItem).getPropertyValue("margin");

    //elimino l'unita di misura px dalla stringa per usare il valore nella moltiplicazione
    heightFlexItem = heightFlexItem.replace("px","");
    marginFlexItem = marginFlexItem.replace("px","");

    let heightFlexContainer = (parseInt(heightFlexItem) + parseInt(marginFlexItem) * 2);
    console.log(w);

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


    newAnchor = document.createElement("a");
    newAnchor.setAttribute("id", "linkMinus");
    newAnchor.setAttribute("href", "sceltaLingua.jsp?categoria="+categoria);   //creo anchor che conterrà un img

    minus = document.createElement("img");
    minus.setAttribute("id", "imgMinus");
    minus.setAttribute("src", "img/meno_1.png");

    newAnchor.appendChild(minus);

    document.getElementById("plus").remove();  //rimuovo button
    document.getElementById("divPlus").appendChild(newAnchor);  //al posto di button metto un anchor che contiene un img
}