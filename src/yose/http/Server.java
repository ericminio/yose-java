package yose.http;

import java.util.Map;

public interface Server {

    void serving(Map<HttpRequestMatcher, Endpoint> routes);

    void start();

    void stop();
}
