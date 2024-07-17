function chargeColloqui() {


    //history.replaceState({}, '', urlOriginale); /*request.getURL restituisce URL senza queryString*/

    let urlAndQuery = window.location.href;

    let url = "mostraColloquiAjax?";

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

    console.log(url);

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const colloqui = JSON.parse(xhr.responseText);
            console.log(colloqui);


            console.log("Ecco  : " + colloqui.data);
            if (colloqui.filtro === "incompleto") {
                alert("Filtro incompleto, riprova!");
            } else if (colloqui.data !== undefined) {
                if(colloqui.data === "sbagliata")
                    alert("Quella che hai inserito non è una data oppure è incompleta");
                else
                    alert("Data antecedente ad ora");
            } else {

                let containerColloqui = document.getElementById("containerColloqui");

                while (containerColloqui.lastChild) {
                    containerColloqui.removeChild(containerColloqui.lastChild);
                }

                if(colloqui.length === 0){
                    let nessunRisultato = document.createElement("p");
                    containerColloqui.appendChild(nessunRisultato);
                    nessunRisultato.id = "nessunRisultato";
                    nessunRisultato.innerHTML = "Non ci sono colloqui che soddisfano i tuoi criteri di ricerca";

                    containerColloqui.style.textAlign = "center";
                    containerColloqui.style.justifyContent = "center";
                    containerColloqui.style.width = "100%";
                    containerColloqui.style.height = "300px";
                } else {

                    containerColloqui.style.textAlign = "";
                    containerColloqui.style.justifyContent = "";
                    containerColloqui.style.width = "";
                    containerColloqui.style.height = "";


                    for (let i = 0; i < colloqui.length; i++) {
                        let colloquioItem = document.createElement("div");
                        containerColloqui.appendChild(colloquioItem);
                        colloquioItem.id = "colloquio" + (i + 1);
                        colloquioItem.setAttribute("class", "colloquioItem");

                        let containerFoto = document.createElement("div");
                        colloquioItem.appendChild(containerFoto);
                        containerFoto.className = "containerFotoEsperto";

                        let fotoEsperto = document.createElement("img");
                        containerFoto.appendChild(fotoEsperto);
                        fotoEsperto.id = "foto" + colloqui[i].ID;
                        fotoEsperto.className = "fotoEsperto";
                        fotoEsperto.src = colloqui[i].fotoEsperto;

                        let containerInfo = document.createElement("div");
                        colloquioItem.appendChild(containerInfo);
                        containerInfo.id = "info" + colloqui[i].ID;
                        containerInfo.className = "containerInfo";

                        /*nome completo esperto*/
                        let nomeCompleto = document.createElement("p");
                        containerInfo.appendChild(nomeCompleto);
                        nomeCompleto.className = "nomeCompleto info";
                        nomeCompleto.innerHTML = colloqui[i].nomeEsperto + " " + colloqui[i].cognomeEsperto;

                        /*nome lingua*/
                        let nomeLingua = document.createElement("p");
                        containerInfo.appendChild(nomeLingua);
                        nomeLingua.className = "nomeLingua info";

                        let spanLingua = document.createElement("span");
                        spanLingua.innerHTML = "Lingua : ";

                        nomeLingua.appendChild(spanLingua);
                        spanLingua.className = "firstWord";
                        nomeLingua.appendChild(document.createTextNode(colloqui[i].nomeLingua));

                        /*lingue conosciute dall' esperto*/
                        let lingueConosciute = document.createElement("p");
                        containerInfo.appendChild(lingueConosciute);
                        lingueConosciute.className = "lingueConosciute info";

                        let spanLingueConosciute = document.createElement("span");
                        spanLingueConosciute.innerHTML = "Parla : ";

                        lingueConosciute.appendChild(spanLingueConosciute);
                        spanLingueConosciute.className = "firstWord";
                        lingueConosciute.appendChild(document.createTextNode(colloqui[i].lingueConosciute));

                        /*data e ora*/
                        let dataOra = document.createElement("p");
                        containerInfo.appendChild(dataOra);
                        dataOra.className = "dataOra info";

                        let spanDataOra = document.createElement("span");
                        spanDataOra.innerHTML = "Data e ora : ";

                        dataOra.appendChild(spanDataOra);
                        spanDataOra.className = "firstWord";
                        let dataOraStringa;
                        dataOraStringa = colloqui[i].dataOra.replace(/[-T]/g, function (match) {
                            if (match === '-') return '/';
                            if (match === 'T') return ' ';
                        });
                        dataOra.appendChild(document.createTextNode(dataOraStringa));

                        let containerPrezzoCarrello = document.createElement("div");
                        colloquioItem.appendChild(containerPrezzoCarrello);
                        containerPrezzoCarrello.className = "containerPrezzoCarrello";

                        let prezzo = document.createElement("p");
                        containerPrezzoCarrello.appendChild(prezzo);
                        prezzo.className = "prezzoOrario";
                        prezzo.innerHTML = colloqui[i].prezzoOrario + " €/ora";



                        let hiddenForm = document.createElement("form");
                        containerPrezzoCarrello.appendChild(hiddenForm);
                        hiddenForm.method = "GET";
                        hiddenForm.action = "aggiungiProdottoCarrello";
                        hiddenForm.target = "frameCarrello";

                        let hiddenInputType = document.createElement("input");
                        hiddenForm.appendChild(hiddenInputType);
                        hiddenInputType.type = "text";
                        hiddenInputType.name = "ID"
                        hiddenInputType.value = colloqui[i].id;
                        hiddenInputType.style.display = "none";

                        let button = document.createElement("button");
                        hiddenForm.appendChild(button);
                        button.type = "submit";
                        button.className = "buttonCarrello";


                        let divCarrello = document.createElement("div");
                        button.appendChild(divCarrello);
                        divCarrello.className = "divCarrello";

                        let carrello = document.createElement("img");
                        divCarrello.appendChild(carrello);
                        carrello.className = "fotoCarrello";
                        carrello.src = "img/carrello.png";

                        /*let divCarrello = document.createElement("div");
                        containerPrezzoCarrello.appendChild(divCarrello);
                        divCarrello.className = "divCarrello";

                        let carrello = document.createElement("img");
                        divCarrello.appendChild(carrello);
                        carrello.className = "fotoCarrello";
                        carrello.src = "img/carrello.png";*/
                    }
                }
            }
        }
    };

    xhr.open("GET", url, true);
    xhr.send();
}

window.addEventListener('DOMContentLoaded', chargeColloqui); /*se più funzioni hanno window.onload viene eseguita solo l'ultima*/
/*con l'evento DOMContentLoadede posso eseguire più cose*/