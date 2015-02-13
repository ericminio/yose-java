package yose;

import java.util.Map;

public interface YoseServer {

    void start();

    void stop();

    void setRoutes(Map<String, Endpoint> routes);
}
