function showElemById(id) {
    document.getElementById(id).style.display = "block";
}

function hideElemById(id) {

    let elem = document.getElementById(id);

    if(elem)
        elem.style.display = "none";
}