import support.SunHttpServer;
import yose.Routes;
import yose.http.Server;
import yose.http.routing.Router;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt( args[ 0 ] );
        Server server = new SunHttpServer( port );
        server.useRouter(Router.routing(new Routes()));
        server.start();
    }
}
