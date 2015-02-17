package challenges;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.HttpResponseForTest;
import support.SunHttpServer;
import yose.Routes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class PingChallenge {

    private SunHttpServer server;
    private HttpResponseForTest response;

    @Before
    public void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.serving(new Routes());
        server.start();
        response = get( "http://localhost:8000/ping" );
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void answersWithJson() throws Exception {
        assertThat( response.contentType, equalTo( "application/json" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, equalTo( "{\"alive\":true}" ) );
    }
}
