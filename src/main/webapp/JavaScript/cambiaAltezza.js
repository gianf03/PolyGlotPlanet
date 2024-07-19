function minHeight(){
    let container = document.getElementById("containerOfAll");
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