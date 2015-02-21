package yose.http.routing;

import yose.http.Endpoint;
import yose.http.HttpRequest;

import java.util.Map;

public class Router {

    public static Router routing(Map<Route, Endpoint> routes) {
        return new Router(routes);
    }

    private Map<Route, Endpoint> routes;

    public Router(Map<Route, Endpoint> routes) {
        this.routes = routes;
    }

    public Endpoint firstEndpointMatching(HttpRequest request) {
        return routes.entrySet().stream().filter(r -> r.getKey().matches(request))
                .findFirst().get().getValue();
    }
}
