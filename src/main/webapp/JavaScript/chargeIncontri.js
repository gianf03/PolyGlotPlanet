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
                    let nessunRisultato = document.createElement("p");
                    containerIncontri.appendChild(nessunRisultato);
                    nessunRisultato.id = "nessunRisultato";
                    nessunRisultato.innerHTML = "Non ci sono incontri che soddisfano i tuoi criteri di ricerca";

                    containerIncontri.style.textAlign = "center";
                    containerIncontri.style.justifyContent = "center";
                    containerIncontri.style.width = "100%";
                    containerIncontri.style.height = "300px";
                } else {

                    containerIncontri.style.textAlign = "";
                    containerIncontri.style.justifyContent = "";
                    containerIncontri.style.width = "";
                    containerIncontri.style.height = "";

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
                        fotoEsperto.id = "foto" + incontri[i].id;
                        fotoEsperto.className = "fotoEsperto";
                        fotoEsperto.src = incontri[i].fotoEsperto;
                        fotoEsperto.alt = incontri[i].nomeEsperto + " " + incontri[i].cognomeEsperto;

                        let containerInfo = document.createElement("div");
                        incontroItem.appendChild(containerInfo);
                        containerInfo.id = "info" + incontri[i].id;
                        containerInfo.className = "containerInfo";

                        let nomeCompleto = document.createElement("p");
                        containerInfo.appendChild(nomeCompleto);
                        nomeCompleto.className = "nomeCompleto";
                        nomeCompleto.innerHTML = incontri[i].nomeEsperto + " " + incontri[i].cognomeEsperto;

                        let nomeLingua = document.createElement("p");
                        containerInfo.appendChild(nomeLingua);
                        nomeLingua.className = "nomeLingua info";

                        let spanLingua = document.createElement("span");
                        spanLingua.innerHTML = "Lingua : ";

                        nomeLingua.appendChild(spanLingua);
                        spanLingua.className = "firstWord";
                        nomeLingua.appendChild(document.createTextNode(incontri[i].nomeLingua));

                        /*lingue conosciute dall' esperto*/
                        let lingueConosciute = document.createElement("p");
                        containerInfo.appendChild(lingueConosciute);
                        lingueConosciute.className = "lingueConosciute info";

                        let spanLingueConosciute = document.createElement("span");
                        spanLingueConosciute.innerHTML = "Parla : ";

                        lingueConosciute.appendChild(spanLingueConosciute);
                        spanLingueConosciute.className = "firstWord";
                        lingueConosciute.appendChild(document.createTextNode(incontri[i].lingueConosciute));

                        /*data e ora*/
                        let dataOra = document.createElement("p");
                        containerInfo.appendChild(dataOra);
                        dataOra.className = "dataOra info";

                        let spanDataOra = document.createElement("span");
                        spanDataOra.innerHTML = "Data e ora : ";

                        dataOra.appendChild(spanDataOra);
                        spanDataOra.className = "firstWord";
                        let dataOraStringa;
                        dataOraStringa = incontri[i].dataOra.replace(/[-T]/g, function(match) {
                            if (match === '-') return '/';
                            if (match === 'T') return ' ';
                        });
                        dataOra.appendChild(document.createTextNode(dataOraStringa));

                        /*indirizzo*/
                        let indirizzo = document.createElement("p");
                        containerInfo.appendChild(indirizzo);
                        indirizzo.className = "indirizzo info";

                        let spanIndirizzo = document.createElement("span");
                        spanIndirizzo.innerHTML = "Indirizzo : ";

                        indirizzo.appendChild(spanIndirizzo);
                        spanIndirizzo.className = "firstWord";
                        indirizzo.appendChild(document.createTextNode(incontri[i].indirizzo));

                        let containerPrezzoCarrello = document.createElement("div");
                        incontroItem.appendChild(containerPrezzoCarrello);
                        containerPrezzoCarrello.className = "containerPrezzoCarrello";

                        let prezzo = document.createElement("p");
                        containerPrezzoCarrello.appendChild(prezzo);
                        prezzo.className = "prezzoOrario";
                        prezzo.innerHTML = incontri[i].prezzoOrario + " €/ora";


                        let hiddenForm = document.createElement("form");
                        containerPrezzoCarrello.appendChild(hiddenForm);
                        hiddenForm.method = "GET";
                        hiddenForm.action = "aggiungiProdottoCarrello";
                        hiddenForm.className = "hiddenForm";
                        //hiddenForm.target = "frameCarrello";

                        let hiddenInputType = document.createElement("input");
                        hiddenForm.appendChild(hiddenInputType);
                        hiddenInputType.type = "text";
                        hiddenInputType.name = "ID"
                        hiddenInputType.value = incontri[i].id;
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
                        carrello.alt = "carrello";

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