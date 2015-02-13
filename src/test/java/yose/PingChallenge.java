package yose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.HttpGetRequest;
import support.HttpGetResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PingChallenge {

    private YoseServer server;
    private HttpGetResponse response;

    @Before
    public void startServer() throws Exception {
        server = new YoseServer( 8000 );
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
