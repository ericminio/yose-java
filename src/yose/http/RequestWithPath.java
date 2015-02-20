package yose.http;

public class RequestWithPath implements HttpRequestMatcher {

    public static HttpRequestMatcher withPathEqualTo(String path) {
        return new RequestWithPath(path);
    }

    private String expected;

    public RequestWithPath(String path) {
        this.expected = path;
    }

    @Override
    public boolean matches(HttpRequest request) {
        return request.path.equals( expected );
    }
}
