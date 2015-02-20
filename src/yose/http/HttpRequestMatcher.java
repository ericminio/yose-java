package yose.http;

public interface HttpRequestMatcher {

    boolean matches(HttpRequest request);
}

