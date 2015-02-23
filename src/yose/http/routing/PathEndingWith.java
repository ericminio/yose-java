package yose.http.routing;

import yose.http.HttpRequest;

public class PathEndingWith implements HttpRequestMatcher {

    public static HttpRequestMatcher withPathEndingWith(String path) {
        return new PathEndingWith(path);
    }

    private String expected;

    public PathEndingWith(String path) {
        this.expected = path;
    }

    @Override
    public boolean matches(HttpRequest request) {
        return request.path.endsWith( expected );
    }
}
