require('../../../src/yose/worlds/astroport/docker.js');
require('../../../src/yose/worlds/astroport/hide.info.js');
var astroport = require('./common.js');
var jsdom = require('jsdom').jsdom;

describe('Feedback', function() {

    var document;

    beforeEach(function() {
        document = jsdom(astroport.withOneGate);
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