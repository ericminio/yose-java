package yose.http;

public class PathEqualTo implements HttpRequestMatcher {

    public static HttpRequestMatcher withPathEqualTo(String path) {
        return new PathEqualTo(path);
    }

    private String expected;

    public PathEqualTo(String path) {
        this.expected = path;
    }

    @Override
    public boolean matches(HttpRequest request) {
        return request.path.equals( expected );
    }
}
