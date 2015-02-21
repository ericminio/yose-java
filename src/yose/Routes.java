package yose;

import yose.http.Endpoint;
import yose.http.endpoints.CssProvider;
import yose.http.endpoints.JsProvider;
import yose.http.routing.Route;
import yose.worlds.astroport.Astroport;
import yose.worlds.primefactors.PrimeFactors;
import yose.worlds.start.Home;
import yose.worlds.start.Ping;

import java.util.HashMap;

import static yose.http.routing.Route.withPathEqualTo;

public class Routes extends HashMap<Route, Endpoint> {

    public Routes() {
        put( withPathEqualTo("/astroport.js"), new JsProvider( "src/yose/worlds/astroport/astroport.js" ) );
        put( withPathEqualTo("/astroport.css"), new CssProvider( "src/yose/worlds/astroport/astroport.css" ) );
        put( withPathEqualTo("/astroport"), new Astroport() );
        put( withPathEqualTo("/primeFactors"), new PrimeFactors() );
        put( withPathEqualTo("/ping"), new Ping() );
        put( withPathEqualTo("/"), new Home() );
    }

}
