package yose;

import yose.http.HttpRequestMatcher;
import yose.http.Endpoint;
import yose.http.CssProvider;
import yose.http.JsProvider;
import yose.worlds.astroport.Astroport;
import yose.worlds.primefactors.PrimeFactors;
import yose.worlds.start.Home;
import yose.worlds.start.Ping;

import java.util.HashMap;

import static yose.http.RequestWithPath.withPathEqualTo;

public class Routes extends HashMap<HttpRequestMatcher, Endpoint> {

    public Routes() {
        put( withPathEqualTo( "/astroport.js" ), new JsProvider( "src/yose/worlds/astroport/astroport.js" ) );
        put( withPathEqualTo( "/astroport.css" ), new CssProvider( "src/yose/worlds/astroport/astroport.css" ) );
        put( withPathEqualTo( "/astroport" ), new Astroport() );
        put( withPathEqualTo( "/primeFactors" ), new PrimeFactors() );
        put( withPathEqualTo( "/ping" ), new Ping() );
        put( withPathEqualTo( "/" ), new Home() );
    }
}
