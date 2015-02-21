package yose.http.routing;

import yose.http.HttpRequest;

public class Route {

    public static Route withPathEqualTo(String path) {
        return new Route(path);
    }

    private String expected;

    public Route(String path) {
        this.expected = path;
    }

    public boolean matches(HttpRequest request) {
        return request.path.equals( expected );
    }
}
