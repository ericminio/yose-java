package worlds.start;

import org.junit.Before;
import org.junit.Test;
import support.YoseChallenge;
import yose.http.HttpResponse;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class HelloYoseChallenge extends YoseChallenge {

    private HttpResponse response;

    @Before
    public void homeRequest() throws Exception {
        response = get( "http://localhost:8000/" );
    }

    @Test
    public void answers() throws Exception {
        assertThat( response.code, equalTo( 200 ) );
    }

    @Test
    public void answersWithHtml() throws Exception {
        assertThat( response.contentType(), containsString( "text/html" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, containsString( "Hello Yose" ) );
    }
}
