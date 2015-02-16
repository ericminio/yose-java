package yose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.HttpResponse;
import support.SunHttpServer;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class HelloYoseChallenge {

    private YoseServer server;
    private HttpResponse response;

    @Before
    public void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.setRoutes(new YoseRoutes());
        server.start();
        response = get( "http://localhost:8000/" );
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void answersWithHtml() throws Exception {
        assertThat( response.contentType, equalTo( "text/html" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, containsString( "Hello Yose" ) );
    }
}