Docker = function (document) {
    this.document = document;
};

Docker.prototype.dock = function () {
    this.document.getElementById('ship-1').innerHTML = this.document.getElementById('ship').value;
    this.document.getElementById('gate-1').className = 'occupied gate';
    this.document.getElementById('info').className = this.document.getElementById('info').className.replace('hidden', '').trim();
};

hideInfo = function(document) {
    var info = document.getElementById("info");

    if (info.className.indexOf('hidden') === -1) {
        info.className = 'hidden ' + info.className;
    }
};