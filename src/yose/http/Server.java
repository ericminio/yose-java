package yose.http;

import yose.http.routing.Router;

public interface Server {

    void useRouter(Router router);

    void start();

    void stop();
}
