function chargeCorsi(){
    let urlAndQuery = window.location.href;
    url = "mostraCorsiAjax?";


    if(!urlAndQuery.includes("filtro=false")) {  //non posso controllare filtro=true perché lo aggiungo all'url dopo
        let languageCheckboxes = document.getElementsByClassName("div-lingua");
        let prezzoMin = document.getElementById("prezzoMin");
        let prezzoMax = document.getElementById("prezzoMax");
        let levelCheckboxes = document.getElementById("filtroLivello").getElementsByTagName("input");


        if (languageCheckboxes[0].getElementsByTagName("input")[0].checked === true) {
            url += "codLingua=all&";
        } else {
            for (var i = 1; i < languageCheckboxes.length; i++) {
                if (languageCheckboxes[i].getElementsByTagName("input")[0].checked) {
                    url += "codLingua=" + languageCheckboxes[i].getElementsByTagName("input")[0].id + "&";
                }
            }
        }

        if (prezzoMin.value !== "niente") {
            url += "prezzoMin=" + prezzoMin.value + "&prezzoMax=" + prezzoMax.value + "&";
        }


        for (let j = 0; j < levelCheckboxes.length; j++) {
            if (levelCheckboxes[j].checked) {
                url += levelCheckboxes[j].name + "=" + levelCheckboxes[j].value + "&";
            }
        }

        url += "filtro=true";

    } else {
        let parti = urlAndQuery.split("?");
        url += parti[1];

        window.history.replaceState(null, '', parti[0]); //elimino la queryString dall'URL
    }

    console.log(url);

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            const corsi = JSON.parse(xhr.responseText);
            console.log(corsi);

            if (corsi.filtro === "incompleto") {
                alert("Filtro incompleto, riprova!");
            } else if (corsi.data !== undefined) {
                if(corsi.data === "sbagliata")
                    alert("Quella che hai inserito non è una data oppure è incompleta");
                else
                    alert("Data antecedente ad ora");
            } else {

                let containerCorsi = document.getElementById("containerCorsi");

                while (containerCorsi.lastChild) {
                    containerCorsi.removeChild(containerCorsi.lastChild);
                }

                if (!corsi.length) {
                    ;
                } else {

                    for (var i = 0; i < corsi.length; i++) {
                        let corsoItem = document.createElement("div");
                        containerCorsi.appendChild(corsoItem);
                        corsoItem.className = "corsoItem";
                        corsoItem.id = "corso"+(i+1);

                        let containerFoto = document.createElement("div");
                        corsoItem.appendChild(containerFoto);
                        containerFoto.className = "containerFotoLingua";

                        let fotoLingua = document.createElement("img");
                        containerFoto.appendChild(fotoLingua);
                        fotoLingua.id = "fotoLingua" + corsi[i].id;
                        fotoLingua.className = "fotoLingua";
                        fotoLingua.src = corsi[i].fotoLingua;

                        let containerInfo = document.createElement("div");
                        corsoItem.appendChild(containerInfo);
                        containerInfo.id = "info" + corsi[i].id;
                        containerInfo.className = "containerInfo";

                        /*nome lingua*/
                        let nomeLingua = document.createElement("p");
                        containerInfo.appendChild(nomeLingua);
                        nomeLingua.className = "nomeLingua info";
                        nomeLingua.innerHTML = "Lingua : " + corsi[i].nomeLingua;


                        /*numero unita*/
                        let numeroUnita = document.createElement("p");
                        containerInfo.appendChild(numeroUnita);
                        numeroUnita.className = "numeroUnita info";
                        numeroUnita.innerHTML = "Unità : " + corsi[i].numeroUnita;

                        /*livello del corso*/
                        let livello = document.createElement("p");
                        containerInfo.appendChild(livello);
                        livello.className = "livelloCorso info";
                        livello.innerHTML = "Livello : " + corsi[i].livello;

                        /*descrizione */
                        let descrizione = document.createElement("p");
                        containerInfo.appendChild(descrizione);
                        descrizione.className = "descrizione info";
                        descrizione.innerHTML = "Descrizione : " + corsi[i].descrizione;

                        let containerPrezzoCarrello = document.createElement("div");
                        corsoItem.appendChild(containerPrezzoCarrello);
                        containerPrezzoCarrello.className = "containerPrezzoCarrello";

                        let prezzo = document.createElement("p");
                        containerPrezzoCarrello.appendChild(prezzo);
                        prezzo.className = "prezzo";
                        prezzo.innerHTML = corsi[i].prezzo + " €";

                        let divCarrello = document.createElement("div");
                        containerPrezzoCarrello.appendChild(divCarrello);
                        divCarrello.className = "divCarrello";

                        let carrello = document.createElement("img");
                        divCarrello.appendChild(carrello);
                        carrello.className = "fotoCarrello";
                        carrello.src = "img/carrello2.png";
                    }
                }
            }
        }
    };


    xhr.open("GET", url, true);
    xhr.send();
}

window.addEventListener('DOMContentLoaded', chargeCorsi); /*se più funzioni hanno window.onload viene eseguita solo l'ultima*/
/*con l'evento DOMContentLoadede posso eseguire più cose*/