import support.SunHttpServer;
import yose.YoseRoutes;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        SunHttpServer server = new SunHttpServer( 7000 );
        server.setRoutes( new YoseRoutes() );
        server.start();
    }
}
