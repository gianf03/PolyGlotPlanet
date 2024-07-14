function modificaCorso(idProd, prezzoBase, sconto) {

    let divModifica = document.getElementById("divModifica");

    divModifica.style.display = "block";

    let prBase = document.getElementById("prBase");
    prBase.setAttribute("value", prezzoBase);

    let scontoPercentuale = document.getElementById("sconto");
    scontoPercentuale.setAttribute("value", sconto);

    let idProdotto = document.getElementById("idProd");
    idProdotto.setAttribute("value", idProd);
}

function mostraDivAggiungi(divId) {

    let divAggiungi = document.getElementById(divId);

    divAggiungi.style.display = "block";
}


function chiudiDivAggiungi(divId) {

    let divAggiungi = document.getElementById(divId);

    divAggiungi.style.display = "none";
}
