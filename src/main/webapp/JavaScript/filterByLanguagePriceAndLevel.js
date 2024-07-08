function filterByLanguagePriceAndLevel(){

    event.preventDefault(); //Questa riga previene l'invio predefinito del form e il conseguente ricaricamento della pagina

    url = "mostraCorsiAjax?";

    let languageCheckboxes = document.getElementsByClassName("div-lingua");
    let prezzoMin = document.getElementById("prezzoMin");
    let prezzoMax = document.getElementById("prezzoMax");
    let levelCheckboxes = document.getElementById("filtroLivello").getElementsByTagName("input");

    for (var i = 1; i < languageCheckboxes.length; i++) {
        if (languageCheckboxes[i].getElementsByTagName("input")[0].checked) {
            url += "codLingua=" + languageCheckboxes[i].getElementsByTagName("input")[0].id + "&";
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
    url = url.substring(0, url.length - 1);


    console.log(url);

    var divPadre = document.getElementById("fatherOfCoursesDivs");

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            const corsi = JSON.parse(xhr.responseText);
            console.log(corsi);

            if (corsi.filtro === "incompleto"){
                /*var f = document.getElementById("f");

                var filtroIncompleto = document.createElement("div");
                f.appendChild(filtroIncompleto);
                filtroIncompleto.setAttribute("id", "filtroIncompleto");

                var p = document.createElement("p");
                filtroIncompleto.appendChild(p);
                p.innerHTML = "Filtro incompleto, riprova.";*/

                alert("Filtro incompleto, riprova!");
            }
            else {
                while (divPadre.lastChild) {
                    divPadre.removeChild(divPadre.lastChild);
                }

                if (!corsi.length) {
                    var nothing = document.createElement("div");
                    divPadre.appendChild(nothing);
                    nothing.setAttribute("id", "containerNothing");

                    var par = document.createElement("p");
                    nothing.appendChild(par);
                    par.setAttribute("id", "nessunRisultato");
                    par.innerHTML = "Nessun risultato";
                } else {

                    for (var i = 0; i < corsi.length; i++) {
                        let containerCorso = document.createElement("div");
                        divPadre.appendChild(containerCorso);
                        containerCorso.setAttribute("class", "containerCorso");

                        let c1 = document.createElement("div");
                        let c2 = document.createElement("div");
                        let c3 = document.createElement("div");

                        c1.setAttribute("class", "corsoItem");
                        c1.setAttribute("id", "c1_" + (i + 1));
                        c2.setAttribute("class", "corsoItem");
                        c2.setAttribute("id", "c2_" + (i + 1));
                        c3.setAttribute("class", "corsoItem");
                        c3.setAttribute("id", "c3_" + (i + 1));


                        containerCorso.appendChild(c1);
                        containerCorso.appendChild(c2);
                        containerCorso.appendChild(c3);

                        let img = document.createElement("img");
                        img.setAttribute("class", "imgLinguaCorso");
                        c1.appendChild(img); //prima appendere e poi cercare per id perché finché non appendo elemento non visibile nel DOM
                        img.setAttribute("src", corsi[i].foto);


                        let p1 = document.createElement("p");
                        let p2 = document.createElement("p");
                        let p3 = document.createElement("p");

                        c2.appendChild(p1);
                        c2.appendChild(p2);
                        c2.appendChild(p3);

                        p1.setAttribute("id", "p1_" + (i + 1));
                        p1.setAttribute("class", "infoCorso");
                        p2.setAttribute("id", "p2_" + (i + 1));
                        p2.setAttribute("class", "infoCorso");
                        p3.setAttribute("id", "p3_" + (i + 1));
                        p3.setAttribute("class", "infoCorso");

                        document.getElementById("p1_" + (i + 1)).innerHTML = "Livello : " + corsi[i].livello;
                        document.getElementById("p2_" + (i + 1)).innerHTML = "Numero unità : " + corsi[i].numeroUnita;
                        document.getElementById("p3_" + (i + 1)).innerHTML = corsi[i].descrizione;

                        let prezzo = document.createElement("div");
                        let carrello = document.createElement("div");

                        prezzo.setAttribute("class", "prezzo");
                        carrello.setAttribute("class", "carrello");

                        c3.appendChild(prezzo);
                        c3.appendChild(carrello);

                        document.getElementsByClassName("prezzo")[i].innerHTML = corsi[i].prezzo + " €";

                        let button = document.createElement("button");
                        button.setAttribute("class", "bt");
                        carrello.appendChild(button);
                        document.getElementsByClassName("bt")[i].innerHTML = "Aggiungi al carrello";
                    }
                }
            }
        }
    };


    xhr.open("GET", url, true);
    xhr.send();
}