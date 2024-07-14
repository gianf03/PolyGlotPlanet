function chargeIncontri() {
    let urlAndQuery = window.location.href;
    let url = "mostraIncontriAjax?";

    if(!urlAndQuery.includes("filtro=false")) {
        let languageCheckboxes = document.getElementsByClassName("div-lingua");
        let prezzoMin = document.getElementById("prezzoMin").value;
        let prezzoMax = document.getElementById("prezzoMax").value;
        let dataOra = document.getElementById("dataOra").value;

        if (languageCheckboxes[0].getElementsByTagName("input")[0].checked === true) {
            url += "codLingua=all&";
        } else {
            for (let i = 1; i < languageCheckboxes.length; i++) {
                let input = languageCheckboxes[i].getElementsByTagName("input")[0];
                if (input.checked && input.value.length === 2) {
                    url += "codLingua=" + languageCheckboxes[i].getElementsByTagName("input")[0].id + "&";
                }
            }
        }

        if (prezzoMin !== "niente" && prezzoMax !== '') {
            url += "prezzoMin=" + prezzoMin + "&prezzoMax=" + prezzoMax + "&";
        }

        if (dataOra.value !== '') {
            url += "dataOra=" + dataOra + "&";
        }

        url += "filtro=true";
        console.log("caso1");
    } else {
        let parti = urlAndQuery.split("?");
        url += parti[1];

        window.history.replaceState(null, '', parti[0]); //elimino la queryString dall'URL
        console.log("caso2");
    }

    console.log("Url : " + url);

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const incontri = JSON.parse(xhr.responseText);
            console.log(incontri);


            console.log("Ecco  : " + incontri.data);
            if (incontri.filtro === "incompleto") {
                alert("Filtro incompleto, riprova!");
            } else if (incontri.data !== undefined) {
                if(incontri.data === "sbagliata")
                    alert("Quella che hai inserito non è una data oppure è incompleta");
                else
                    alert("Data antecedente ad ora");
            } else {

                let containerIncontri = document.getElementById("containerIncontri");

                while (containerIncontri.lastChild) {
                    containerIncontri.removeChild(containerIncontri.lastChild);
                }

                if (incontri.length === 0){
                    ;
                } else {

                    for (let i = 0; i < incontri.length; i++) {
                        let incontroItem = document.createElement("div");
                        containerIncontri.appendChild(incontroItem);
                        incontroItem.id = "incontro" + (i + 1);
                        incontroItem.className = "incontroItem";

                        let containerFoto = document.createElement("div");
                        incontroItem.appendChild(containerFoto);
                        containerFoto.className = "containerFotoEsperto";

                        let fotoEsperto = document.createElement("img");
                        containerFoto.appendChild(fotoEsperto);
                        fotoEsperto.id = "foto" + incontri[i].ID;
                        fotoEsperto.className = "fotoEsperto";
                        fotoEsperto.src = incontri[i].fotoEsperto;

                        let containerInfo = document.createElement("div");
                        incontroItem.appendChild(containerInfo);
                        containerInfo.id = "info" + incontri[i].ID;
                        containerInfo.className = "containerInfo";

                        let nomeCompleto = document.createElement("h1");
                        containerInfo.appendChild(nomeCompleto);
                        nomeCompleto.className = "nomeCompleto";
                        nomeCompleto.innerHTML = incontri[i].nomeEsperto + " " + incontri[i].cognomeEsperto;

                        /*indirizzo*/
                        /*data e ora*/

                        let containerPrezzoCarrello = document.createElement("div");
                        incontroItem.appendChild(containerPrezzoCarrello);
                        containerPrezzoCarrello.className = "containerPrezzoCarrello";

                        let prezzo = document.createElement("p");
                        containerPrezzoCarrello.appendChild(prezzo);
                        prezzo.className = "prezzoOrario";
                        prezzo.innerHTML = incontri[i].prezzoOrario + " €/ora";

                        let divCarrello = document.createElement("div");
                        containerPrezzoCarrello.appendChild(divCarrello);
                        divCarrello.className = "divCarrello";

                        let carrello = document.createElement("img");
                        divCarrello.appendChild(carrello);
                        carrello.className = "fotoCarrello";
                        carrello.src = "img/carrello2.png";

                        console.log(incontroItem);
                    }
                }
            }
        }
    };

    xhr.open("GET", url, true);
    xhr.send();
}

window.addEventListener('DOMContentLoaded', chargeIncontri); /*se più funzioni hanno window.onload viene eseguita solo l'ultima*/
/*con l'evento DOMContentLoadede posso eseguire più cose*/