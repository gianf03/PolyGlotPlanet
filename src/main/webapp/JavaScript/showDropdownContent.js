function showDropdownContent(){
    var checkbox = document.getElementById("dropcheck-lingue");
    if (checkbox.checked){
        document.getElementsByClassName("dropdown-content-lingue")[0].style = "display:block;";
    } else
        document.getElementsByClassName("dropdown-content-lingue")[0].style = "display:none;";
}

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