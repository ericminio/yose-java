import support.Server;
import support.SunHttpServer;
import yose.YoseRoutes;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        Server server = new SunHttpServer(7000);
        server.serving(new YoseRoutes());
        server.start();
    }
}
