function showDropdownContentLingue(){
    let dropdowns = document.getElementsByClassName("dropdown");
    let allCheckboxes = document.getElementsByClassName("dropcheck");
    let checkbox = document.getElementById("dropcheck-lingue");
    if (checkbox.checked){
        let currentDropdown = document.getElementById("dropdown-content-lingue");
        currentDropdown.style.display = "block";

        for (let j = 0; j<dropdowns.length; j++){
            if (dropdowns[j] !== currentDropdown) {
                dropdowns[j].style.display = "none";
                allCheckboxes[j].checked = false;
            }
        }
    } else
        document.getElementById("dropdown-content-lingue").style.display = "none";
}


function showDropdownContentPrezzi() {
    let checkbox = document.getElementById("dropcheck-prezzi");
    let allCheckboxes = document.getElementsByClassName("dropcheck");
    let dropdowns = document.getElementsByClassName("dropdown");
    if (checkbox.checked){
        let currentDropdown = document.getElementById("dropdown-content-prezzi");
        currentDropdown.style.display = "flex";
        currentDropdown.style.flexDirection = "row";

        for (let j = 0; j<dropdowns.length; j++){
            if (dropdowns[j] !== currentDropdown) {
                dropdowns[j].style.display = "none";
                allCheckboxes[j].checked = false;
            }
        }
    } else
        document.getElementById("dropdown-content-prezzi").style.display = "none";
}


function showDropdownContentData() {
    let checkbox = document.getElementById("dropcheck-data");
    let allCheckboxes = document.getElementsByClassName("dropcheck");
    let dropdowns = document.getElementsByClassName("dropdown");
    if (checkbox.checked){
        let currentDropdown = document.getElementById("dropdown-content-data");
        currentDropdown.style.display = "block";

        for (let j = 0; j<dropdowns.length; j++){
            if (dropdowns[j] !== currentDropdown){
                allCheckboxes[j].checked = false;
                dropdowns[j].style.display = "none";
            }
        }
    } else
        document.getElementById("dropdown-content-data").style.display = "none";
}

/*se visualizzo il dropdown-content di un filtro quello degli altri va chiuso*/

function selectDeselectAll() {
    var allCheckboxes = document.getElementsByClassName("div-lingua");
    var all = document.getElementById("all");
    if (all.checked) {
        for (let i = 0; i < allCheckboxes.length; i++) {
            allCheckboxes[i].getElementsByTagName("input")[0].checked = true;
        }
    } else {
        let flag = true;

        //se tutti i checkbox sono checked quando tutte diventa unchecked diventano unchecked anche tutti gli altri checkbox
        //altrimenti, solo tutte diviene unchecked

        //il primo checkbox è "tutte" quindi non va considerato
        for (let j = 1; j<allCheckboxes.length; j++){ //controllo che tutti i checkbox siano checked
            if (!allCheckboxes[j].getElementsByTagName("input")[0].checked) {
                flag = false;
                break;
            }
        }

        if(flag) {
            for (let i = 0; i < allCheckboxes.length; i++) {
                allCheckboxes[i].getElementsByTagName("input")[0].checked = false;
            }
        }
    }
}

//se deseleziono una lingua in particolare dopo averle selezionate tutte, "tutte" diventa per forza unchecked
function deselectTutte(currentElement){  //strano ma vero, se passo il codiceISOLingua e ne faccio la stampa qui mi stampa elemento con quell'id
    let tutte = document.getElementById("all");
    let allCheckboxes = document.getElementsByClassName("div-lingua");

    console.log(currentElement);
    if(!currentElement.checked)
        tutte.checked = false;
    else {
        let flag = true;
        for (let i = 1; i < allCheckboxes.length; i++) {
            if(!allCheckboxes[i].getElementsByTagName("input")[0].checked)
                flag = false;
        }

        if (flag)
            tutte.checked = true;
    }
}