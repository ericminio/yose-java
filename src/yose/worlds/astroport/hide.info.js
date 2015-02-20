hideInfo = function(document) {
    var info = document.getElementById("info");

    if (info.className.indexOf('hidden') === -1) {
        info.className = 'hidden ' + info.className;
    }
};