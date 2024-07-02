function checkSelection(max) {
    var x = document.getElementById("prezzoMin");
    var y = document.getElementById("prezzoMax");
    while(y.firstChild)
        y.removeChild(y.firstChild);
    if (x.value !== "niente") {
        y.disabled = false;

        for (var i = parseInt(x.value)+10; i<=max; i=i+10){
            var option = document.createElement("option");
            option.value = i;
            option.innerHTML = i;
            y.appendChild(option);
            console.log(option);
        }
    } else
        y.disabled = true;
}