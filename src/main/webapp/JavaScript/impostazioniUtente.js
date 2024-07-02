var contenutoBottomContainer;

function modificaDati(index) {
    //ripristina il contenuto del bottomContainer

    if(contenutoBottomContainer != null)
        document.getElementById("bottomContainer").innerHTML = contenutoBottomContainer;

    animazioneButton(index);
}


function mostraOrdini(index) {

    var bottomContainer = document.getElementById("bottomContainer");

    if(bottomContainer.innerHTML !== "")
        contenutoBottomContainer = bottomContainer.innerHTML;

    bottomContainer.innerHTML = "";

    animazioneButton(index);

    var xhr = new XMLHttpRequest();

    xhr.open("GET", "mostraOrdiniAjax", true);

    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200) {

        }
    };
}


function animazioneButton(index) {
    var buttons = document.getElementsByClassName("item");


    for(let i = 0; i < buttons.length; i++) {

        if(i === index) {
            buttons[i].style.backgroundColor = "#80B918";
        } else {
            buttons[i].style.backgroundColor = "#006400";
        }
    }
}