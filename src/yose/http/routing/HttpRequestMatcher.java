package yose.http.routing;

import yose.http.HttpRequest;

public interface HttpRequestMatcher {

    boolean matches(HttpRequest request);
}

