package yose;

import yose.worlds.astroport.Astroport;
import yose.http.Endpoint;
import yose.worlds.start.HelloYose;
import yose.worlds.start.Ping;
import yose.worlds.primefactors.PrimeFactors;

import java.util.HashMap;

public class Routes extends HashMap<String, Endpoint> {

    public Routes() {
        put("/astroport", new Astroport());
        put("/primeFactors", new PrimeFactors());
        put("/ping", new Ping());
        put("/", new HelloYose());
    }
}
