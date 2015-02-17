import yose.Routes;
import yose.http.Server;
import support.SunHttpServer;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        Server server = new SunHttpServer(port);
        server.serving(new Routes());
        server.start();
    }
}
