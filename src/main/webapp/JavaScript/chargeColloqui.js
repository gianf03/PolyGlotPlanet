function chargeColloqui() {
    let paginaPrecedente = document.referrer;
    console.log(paginaPrecedente);

    /*qui inizia parte buona*/

    let url = "mostraColloquiAjax?";

    let languageCheckboxes = document.getElementsByClassName("div-lingua");
    let prezzoMin = document.getElementById("prezzoMin").value;
    let prezzoMax = document.getElementById("prezzoMax").value;
    let dataOra = document.getElementById("dataOra").value;

    for (let i = 1; i < languageCheckboxes.length; i++) {
        let input = languageCheckboxes[i].getElementsByTagName("input")[0];
        if (input.checked && input.value.length === 2) {
                url += "codLingua=" + languageCheckboxes[i].getElementsByTagName("input")[0].id + "&";
        }
    }

    if (prezzoMin !== "niente" && prezzoMax !== '') {
        url += "prezzoMin=" + prezzoMin + "&prezzoMax=" + prezzoMax + "&";
    }

    if (dataOra.value !== ''){
        url += "dataOra=" + dataOra + "&";
    }

    url = url.substring(0, url.length - 1);
    console.log(url);




    /*if (paginaPrecedente.includes("mostraCategorie")) {
        url = url.substring(0, url.length-1);
        url += window.location.search;
        console.log(url);
    } else if (paginaPrecedente.includes("colloqui.jsp")){
        url += "codLingua=all&page=1";
    }*/

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const colloqui = JSON.parse(xhr.responseText);
            console.log(colloqui);

            let containerColloqui = document.getElementById("containerColloqui");

            while (containerColloqui.lastChild) {
                containerColloqui.removeChild(containerColloqui.lastChild);
            }

            for (i = 0; i<colloqui.length; i++){
                let colloquioItem = document.createElement("div");
                containerColloqui.appendChild(colloquioItem);
                colloquioItem.id = "colloquio"+ (i+1);
                colloquioItem.setAttribute("class", "colloquioItem");

                let containerFoto = document.createElement("div");
                colloquioItem.appendChild(containerFoto);
                containerFoto.className = "containerFotoEsperto";

                let fotoEsperto = document.createElement("img");
                containerFoto.appendChild(fotoEsperto);
                fotoEsperto.id = "foto"+colloqui[i].ID;
                fotoEsperto.className = "fotoEsperto";
                fotoEsperto.src = colloqui[i].fotoEsperto;

                let containerInfo = document.createElement("div");
                colloquioItem.appendChild(containerInfo);
                containerInfo.id = "info"+colloqui[i].ID;
                containerInfo.className = "containerInfo";

                let nomeCompleto = document.createElement("h1");
                containerInfo.appendChild(nomeCompleto);
                nomeCompleto.className = "nomeCompleto";
                nomeCompleto.innerHTML = colloqui[i].nomeEsperto + " " + colloqui[i].cognomeEsperto;

                let containerPrezzoCarrello = document.createElement("div");
                colloquioItem.appendChild(containerPrezzoCarrello);
                containerPrezzoCarrello.className = "containerPrezzoCarrello";

                let prezzo = document.createElement("p");
                containerPrezzoCarrello.appendChild(prezzo);
                prezzo.className = "prezzoOrario";
                prezzo.innerHTML = colloqui[i].prezzoOrario + " €/ora";

                let divCarrello = document.createElement("div");
                containerPrezzoCarrello.appendChild(divCarrello);
                divCarrello.className = "divCarrello";

                let carrello = document.createElement("img");
                divCarrello.appendChild(carrello);
                carrello.className = "fotoCarrello";
                carrello.src = "img/carrello2.png";
            }
        }
    };

    xhr.open("GET", url, true);
    xhr.send();
}

window.addEventListener('DOMContentLoaded', chargeColloqui); /*se più funzioni hanno window.onload viene eseguita solo l'ultima*/
/*con l'evento DOMContentLoadede posso eseguire più cose*/