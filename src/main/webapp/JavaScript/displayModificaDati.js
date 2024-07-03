function mostraModificaDati() {
    document.getElementById("containerModificaDati").style.display = "block";
}

function removeError(error) {

    var p = document.getElementById(error);

    if(p) {
        p.style.display = "none";
    }
}

