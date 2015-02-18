require('../../../src/yose/worlds/astroport/astroport.js')
var jsdom = require('jsdom').jsdom;

describe('Docker', function() {

    it('can be instantiated', function() {
        expect(new Docker()).not.toEqual(undefined);
    });

    it('docks the given ship at first gate', function() {
        var document = jsdom(
                '<input id="ship" value="Goldorak"/>' +
                '<section id="gate-1" class="free gate">' +
                '<label id="ship-1">None</label>' +
                '</section>' +
                '<label id="info"></label>'
        );
        new Docker(document).dock();

        expect(document.getElementById('ship-1').innerHTML).toEqual('Goldorak');
    });
});