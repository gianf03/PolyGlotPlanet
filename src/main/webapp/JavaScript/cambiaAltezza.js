function minHeight(){
    let container = document.getElementById("containerOfAll");
    let footer = document.getElementById("footer");
    let header = document.getElementById("header");

    if (header === null && footer !== null)
        container.style.minHeight = (window.innerHeight-footer.offsetHeight) + "px";
    else if (footer === null && header !== null)
        container.style.minHeight = (window.innerHeight-header.offsetHeight) + "px";
    else if (footer === null && header === null)
        container.style.minHeight = window.innerHeight + "px";
    else
        container.style.minHeight = (window.innerHeight-footer.offsetHeight-header.offsetHeight) + "px";

    //console.log("Min height : "+window.getComputedStyle(container).minHeight);
}

window.onload = minHeight;
window.onresize = minHeight;
