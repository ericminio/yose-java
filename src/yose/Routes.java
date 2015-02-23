package yose;

import yose.http.endpoints.CssProvider;
import yose.http.Endpoint;
import yose.http.routing.HttpRequestMatcher;
import yose.http.endpoints.JsProvider;
import yose.worlds.astroport.Astroport;
import yose.worlds.primefactors.PrimeFactors;
import yose.worlds.start.Home;
import yose.worlds.start.Ping;

import java.util.HashMap;

import static yose.http.routing.PathEndingWith.withPathEndingWith;
import static yose.http.routing.PathEqualTo.withPathEqualTo;

public class Routes extends HashMap<HttpRequestMatcher, Endpoint> {

    public Routes() {
        put( withPathEndingWith( ".css" ), new CssProvider() );
        put( withPathEndingWith( ".js" ), new JsProvider() );
        put( withPathEqualTo( "/astroport" ), new Astroport() );
        put( withPathEqualTo( "/primeFactors" ), new PrimeFactors() );
        put( withPathEqualTo( "/ping" ), new Ping() );
        put( withPathEqualTo( "/" ), new Home() );
    }

}
