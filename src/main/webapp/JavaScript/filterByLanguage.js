function filterByLanguage(){
    event.preventDefault(); //Questa riga previene l'invio predefinito del form e il conseguente ricaricamento della pagina

    var value = document.getElementById("selectLingua").value;
    let url = "mostraCorsiAjax?";

    let select = document.getElementById("selectLingua");

    for (var i = 0; i < select.options.length; i++) {
        if (select.options[i].selected) {
            url += "codLingua=" + select.options[i].value + "&";
        }
    }
    url = url.substring(0, url.length-1); //rimuoviamo l'ultimo & o il ? in assenza di parametri da passare alla servlet
    console.log(url);

    console.log(value);

    var divPadre = document.getElementById("fatherOfCoursesDivs");

    if(value != null) {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {

                while (divPadre.lastChild) {
                    divPadre.removeChild(divPadre.lastChild);
                }

                const obj = JSON.parse(xhr.responseText);
                console.log(obj);

                //foto = obj.foto;
                corsi = obj;

                //console.log(foto);

                for(var i = 0; i<corsi.length; i++){
                    console.log(i);
                    let containerCorso = document.createElement("div");
                    divPadre.appendChild(containerCorso);
                    containerCorso.setAttribute("class", "containerCorso");

                    let c1 = document.createElement("div");
                    let c2 = document.createElement("div");
                    let c3 = document.createElement("div");

                    c1.setAttribute("class", "corsoItem");
                    c1.setAttribute("id", "c1_"+(i+1));
                    c2.setAttribute("class", "corsoItem");
                    c2.setAttribute("id", "c2_"+(i+1));
                    c3.setAttribute("class", "corsoItem");
                    c3.setAttribute("id", "c3_"+(i+1));


                    containerCorso.appendChild(c1);
                    containerCorso.appendChild(c2);
                    containerCorso.appendChild(c3);

                    let img = document.createElement("img");
                    img.setAttribute("class", "imgLinguaCorso");
                    c1.appendChild(img); //prima appendere e poi cercare per id perché finché non appendo elemento non visibile nel DOM
                    img.setAttribute("src", "");


                    let p1 = document.createElement("p");
                    let p2 = document.createElement("p");
                    let p3 = document.createElement("p");

                    c2.appendChild(p1);
                    c2.appendChild(p2);
                    c2.appendChild(p3);

                    p1.setAttribute("id", "p1_"+(i+1));
                    p1.setAttribute("class", "infoCorso");
                    p2.setAttribute("id", "p2_"+(i+1));
                    p2.setAttribute("class", "infoCorso");
                    p3.setAttribute("id", "p3_"+(i+1));
                    p3.setAttribute("class", "infoCorso");

                    document.getElementById("p1_"+(i+1)).innerHTML = "Livello : " + corsi[i].livello;
                    document.getElementById("p2_"+(i+1)).innerHTML = "Numero unità : " + corsi[i].numeroUnita;
                    document.getElementById("p3_"+(i+1)).innerHTML = corsi[i].descrizione;

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
        };



        xhr.open("GET", url, true);
        xhr.send();
    }
}