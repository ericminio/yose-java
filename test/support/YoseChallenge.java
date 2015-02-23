package support;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import yose.Routes;
import yose.http.routing.Router;

public class YoseChallenge {

    private static SunHttpServer server;

    @BeforeClass
    public static void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.useRouter( Router.routing( new Routes() ) );
        server.start();
    }

    @AfterClass
    public static void stopServer() {
        server.stop();
    }
}
