package challenges;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.SunHttpServer;
import yose.Routes;
import yose.http.HttpResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class PingChallenge {

    private SunHttpServer server;
    private HttpResponse response;

    @Before
    public void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.serving( new Routes() );
        server.start();
        response = get( "http://localhost:8000/ping" );
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void answers() throws Exception {
        assertThat( response.code, equalTo( 200 ) );
    }

    @Test
    public void answersWithJson() throws Exception {
        assertThat( response.contentType(), equalTo( "application/json" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, equalTo( "{\"alive\":true}" ) );
    }
}
