/* problema che risolve questa funzione : apro sceltaLingua.jsp con 3 stati per riga, premo sul +. Dopodiché rimpicciolisco
la finestra fino a 2 stati per riga. Senza questa funzione l'altezza del flex-container non risulterebbe sufficiente.
apro sceltaLingua.jsp con 1 stato per riga, premo sul +. Dopodiché ingrnadisco la finestra fino a 2 stati per riga.
Senza questa funzione l'altezza del flex-container sarebbe eccessiva perché uguale al caso in cui ho 1 stato per riga
sebbene ora ce ne siano 2.
 */
function resizeContainerStati(){
    let minus = document.getElementById("linkMinus");
    let container = document.getElementById("flex-container");

    if (minus !== null) {
        let array = document.getElementsByClassName("flex-item");
        let flexItem = document.getElementsByClassName("flex-item")[0];
        let heightFlexItem = window.getComputedStyle(flexItem).getPropertyValue("height");
        let marginFlexItem = window.getComputedStyle(flexItem).getPropertyValue("margin");
        let container = document.getElementById("flex-container");
        let heightContainer = (parseInt(heightFlexItem) + parseInt(marginFlexItem) * 2);

        console.log("Height : " + window.getComputedStyle(container).height);


        if (window.innerWidth > 650 && window.innerWidth<=900) {
            if (array.length % 2 === 0) heightContainer *= (array.length / 2 + 1);
            else heightContainer *= (array.length / 2 + 2);

            container.style.height = heightContainer + "px";
        } else if (window.innerWidth >900) {
            if (array.length % 3 === 0) heightContainer *= (array.length / 3 + 1);
            else heightContainer *= (array.length / 3 + 2);

            container.style.height = heightContainer + "px";
        } else {
            heightContainer *= array.length+1;

            container.style.height = heightContainer + "px";
        }
    }
}

window.onresize = resizeContainerStati;