function showElemById(id) {
    document.getElementById(id).style.display = "block";
}

function hideElemById(id) {
    document.getElementById(id).style.display = "none";
}

function removeError(error) {

    var p = document.getElementById(error);

    if(p) {
        p.style.display = "none";
    }
}