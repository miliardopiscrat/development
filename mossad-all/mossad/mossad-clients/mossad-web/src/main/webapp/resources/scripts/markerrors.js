function setFocus(id) {
    var element = document.getElementById(id);
    if (element && element.focus) {
        element.focus();
    }
}

function setHighlight(ids, className) {
    var idsArray = ids.split(",");
    for (var i = 0; i < idsArray.length; i++) {
        var element = document.getElementById(idsArray[i]);
        if (element && element.className == 'loginInput') {
            element.className = className;
        }
    }
}