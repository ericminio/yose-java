package yose.http;

public interface Server {

    void useRouter(Router router);

    void start();

    void stop();
}
