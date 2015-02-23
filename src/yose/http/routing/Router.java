package yose.http.routing;

import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.endpoints.NotFound;

import java.util.Map;
import java.util.stream.Stream;

public class Router {

    public static Router routing(Map<HttpRequestMatcher, Endpoint> routes) {
        return new Router( routes );
    }

    private Map<HttpRequestMatcher, Endpoint> routes;

    public Router(Map<HttpRequestMatcher, Endpoint> routes) {
        this.routes = routes;
    }

    public Endpoint firstEndpointMatching(HttpRequest request) {
        if (routes.entrySet().stream().filter( r -> r.getKey().matches( request ) ).count() == 0) {
            return new NotFound();
        }
        return routes.entrySet().stream().filter( r -> r.getKey().matches( request ) ).findFirst().get().getValue();
    }
}
