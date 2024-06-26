function filterByLanguage(){

    var value = document.getElementById("selectLingua").value;

    var containerCorsi = document.getElementsByClassName("containerCorso");


    if(value != null) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "mostraCorsiAjax?lingua=" + value, true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const corsi = JSON.parse(xhr.responseText).corsi;

                for(let i = 0; i < containerCorsi.length; i++) {
                    containerCorsi[i].remove();
                }

                var container = document.createElement("div");
                container.setAttribute("class", "containerCorso");

                document.getElementsByName("body")[0].appendChild(container);
            }
        };
        xhr.send();
    }
}