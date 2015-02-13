package yose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.HttpGetRequest;
import support.HttpGetResponse;
import support.SunHttpServer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PingChallenge {

    private SunHttpServer server;
    private HttpGetResponse response;

    @Before
    public void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.setRoutes( new YoseRoutes() );
        server.start();
        response = new HttpGetRequest( "http://localhost:8000/ping" ).open();
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void answersWithJson() throws Exception {
        assertThat( response.contentType(), equalTo( "application/json" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body(), equalTo( "{\"alive\":true}" ) );
    }
}
