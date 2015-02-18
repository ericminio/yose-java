package worlds.start;

import org.junit.Before;
import org.junit.Test;
import support.YoseChallenge;
import yose.http.HttpResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class PingChallenge extends YoseChallenge {

    private HttpResponse response;

    @Before
    public void pingRequest() throws Exception {
        response = get( "http://localhost:8000/ping" );
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
