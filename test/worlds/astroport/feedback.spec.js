require('../../../src/yose/worlds/astroport/astroport.js')
var jsdom = require('jsdom').jsdom;

describe('Feedback', function() {

    var document;

    beforeEach(function() {
        document = jsdom(
                '<input id="ship" value="Goldorak"/>' +
                '<section id="gate-1" class="free gate">' +
                '<label id="ship-1">None</label>' +
                '</section>' +
                '<label id="info" class="hidden box"></label>'
        );
        new Docker(document).dock();
    });

    it('is visible on gate', function() {
        expect(document.getElementById('gate-1').className).toEqual('occupied gate');
    });

    it('is visible on info', function() {
        expect(document.getElementById('info').className).toEqual('box');
    });

    it('can be hidden again', function() {
        hideInfo(document);

        expect(document.getElementById('info').className).toEqual('hidden box');
    });

    it('does not hiden twice', function() {
        hideInfo(document);
        hideInfo(document);

        expect(document.getElementById('info').className).toEqual('hidden box');

    });
});