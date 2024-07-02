function cambiaAltezza() {
    var container = document.getElementsByClassName("containerOfAll")[0];
    var footer = document.getElementById("footer");
    console.log("Altezza container : " + container.offsetHeight);
    //console.log("finestra window : " +window.innerHeight); //window.innerHeight è sempre costante su qualsiasi pagina

    if (container.offsetHeight < window.innerHeight) {
        footer.style.marginTop = window.innerHeight - container.offsetHeight;
    }
}

window.onload = cambiaAltezza;
window.onresize = cambiaAltezza;