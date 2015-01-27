package yose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PingChallenge {

    private YoseServer server;

    @Before
    public void startServer() throws Exception {
        server = new YoseServer( 8000 );
        server.start();
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void answersWithJson() throws Exception {
        URL url = new URL( "http://localhost:8000/ping" );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        assertThat( connection.getHeaderField( "content-type" ), equalTo( "application/json" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        URL url = new URL( "http://localhost:8000/ping" );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader( new InputStreamReader( (connection.getInputStream()) ) );
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append( output );
        }
        String body = sb.toString();

        assertThat( body, equalTo( "{\"alive\":true}" ) );
    }
}
