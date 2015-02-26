package support;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import yose.Routes;
import yose.http.YoseServer;
import yose.http.routing.Router;

public class YoseChallenge {

    private static YoseServer yoseServer;

    @BeforeClass
    public static void startServer() throws Exception {
        yoseServer = new JettyServer( 8000 );
        yoseServer.useRouter( Router.routing( new Routes() ) );
        yoseServer.start();
    }

    @AfterClass
    public static void stopServer() throws Exception {
        yoseServer.stop();
    }
}
