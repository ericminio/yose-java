package yose;

import java.util.Map;

public interface YoseServer {

    void setRoutes(Map<String, Endpoint> routes);

    void start();

    void stop();
}
