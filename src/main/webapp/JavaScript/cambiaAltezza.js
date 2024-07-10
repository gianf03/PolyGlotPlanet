/*function cambiaAltezza() {
    var container = document.getElementsByClassName("containerOfAll")[0];
    var footer = document.getElementById("footer");
    console.log("Altezza container : " + container.offsetHeight);
    console.log("Altezza finestra : " + window.innerHeight);
    console.log("Altezza marginTop footer prima : " + window.getComputedStyle(footer).marginTop);
    //console.log("finestra window : " +window.innerHeight); //window.innerHeight è sempre costante su qualsiasi pagina

    if (container.offsetHeight < window.innerHeight) {
        console.log((window.innerHeight - container.offsetHeight) + "px");
        footer.style.marginTop = (window.innerHeight - container.offsetHeight) + "px";
    }

    console.log("Altezza marginTop footer dopo : " + window.getComputedStyle(footer).marginTop);
    console.log("Altezza container dopo : "+container.offsetHeight);
}

window.onload = cambiaAltezza;
window.onresize = cambiaAltezza;*/

function minHeight(){
    let container = document.getElementsByClassName("containerOfAll")[0];
    let footer = document.getElementById("footer");
    let header = document.getElementById("header");

    if (header === null && footer !== null)
        container.style.minHeight = (window.innerHeight-footer.offsetHeight) + "px";
    else if (footer === null && header !== null)
        container.style.minHeight = (window.innerHeight-header.offsetHeight) + "px";
    else if (footer === null && header === null)
        container.style.minHeight = window.innerHeight + "px";
    else
        container.style.minHeight = (window.innerHeight-footer.offsetHeight-header.offsetHeight) + "px";

    console.log("Min height : "+window.getComputedStyle(container).minHeight);
}

window.onload = minHeight;
window.onresize = minHeight;

/*funzione per evitare caricamento delle pagine dalla cache*/
window.addEventListener('pageshow', function(event) {
    if (event.persisted) {
        // La pagina è stata ricaricata da una cache del browser (es. pulsante "back")
        window.location.reload(); // Ricarica la pagina per garantire che non provenga dalla cache
    }
});