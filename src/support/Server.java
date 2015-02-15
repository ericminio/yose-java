package support;

import java.util.Map;

public interface Server {

    void serving(Map<String, Endpoint> routes);

    void start();

    void stop();
}
