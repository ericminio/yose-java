package yose;

import yose.challenges.HelloYose;
import yose.challenges.Ping;
import yose.challenges.PrimeFactors;

import java.util.HashMap;

public class YoseRoutes extends HashMap<String, Endpoint> {

    public YoseRoutes() {
        put( "/primeFactors", new PrimeFactors() );
        put( "/ping", new Ping() );
        put( "/", new HelloYose() );
    }
}
