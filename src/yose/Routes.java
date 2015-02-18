package yose;

import yose.http.CssProvider;
import yose.http.Endpoint;
import yose.worlds.astroport.Astroport;
import yose.worlds.primefactors.PrimeFactors;
import yose.worlds.start.HelloYose;
import yose.worlds.start.Ping;

import java.util.HashMap;

public class Routes extends HashMap<String, Endpoint> {

    public Routes() {
        put( "/astroport.css", new CssProvider( "src/yose/worlds/astroport/astroport.css" ) );
        put( "/astroport", new Astroport() );
        put( "/primeFactors", new PrimeFactors() );
        put( "/ping", new Ping() );
        put( "/", new HelloYose() );
    }
}
