import support.JettyServer;
import yose.Routes;
import yose.http.YoseServer;
import yose.http.routing.Router;

public class Launcher {

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt( args[ 0 ] );
        YoseServer yoseServer = new JettyServer( port );
        yoseServer.useRouter( Router.routing( new Routes() ) );
        yoseServer.start();
    }
}
