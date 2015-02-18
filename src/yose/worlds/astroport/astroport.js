Docker = function(document) {
    this.document = document;
};

Docker.prototype.dock = function() {
    this.document.getElementById('ship-1').innerHTML = this.document.getElementById('ship').value;
};