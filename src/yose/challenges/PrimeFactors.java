package yose.challenges;

import http.HttpRequest;
import http.HttpResponse;
import http.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactors implements Endpoint {

    private int number;
    private String decomposition;

    @Override
    public HttpResponse handle(HttpRequest request) {
        extractNumberFromQuery(request.query);
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put("content-type", "application/json");
        response.body = buildBody();
        return response;
    }

    private void extractNumberFromQuery(String query) {
        number = Integer.parseInt( query.split( "[=]" )[ 1 ] );
        decomposition = decompose( number ).stream().map( prime -> prime.toString() ).collect( Collectors.joining( "," ) );
    }

    private String buildBody() {
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
