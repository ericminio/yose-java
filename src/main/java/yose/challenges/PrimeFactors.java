package yose.challenges;

import yose.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactors implements Endpoint {

    private int number;
    private String decomposition;

    @Override
    public void setQuery(String query) {
        number = Integer.parseInt( query.split( "[=]" )[ 1 ] );
        decomposition = decompose( number ).stream().map( prime -> prime.toString() ).collect( Collectors.joining( "," ) );
    }

    @Override
    public String contentType() {
        return "application/json";
    }

    @Override
    public String body() {
        return "{\"number\":" + number + ",\"decomposition\":[" + decomposition + "]}";
    }

    private List<Integer> decompose(int number) {
        ArrayList<Integer> primes = new ArrayList<>();
        while (number > 1) {
            int prime = 2;
            while (number % prime == 0) {
                primes.add( prime );
                number /= prime;
            }
        }
        return primes;
    }
}
