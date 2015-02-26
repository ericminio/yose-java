package yose.http;

import yose.http.routing.Router;

public interface YoseServer {

    void useRouter(Router router);

    void start() throws Exception;

    void stop() throws Exception;
}
