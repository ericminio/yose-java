package yose.app;

import http.Endpoint;
import yose.challenges.HelloYose;
import yose.challenges.Ping;
import yose.challenges.PrimeFactors;

import java.util.HashMap;

public class Routes extends HashMap<String, Endpoint> {

    public Routes() {
        put("/primeFactors", new PrimeFactors());
        put("/ping", new Ping());
        put("/", new HelloYose());
    }
}
