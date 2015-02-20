package http;

import org.junit.Before;
import org.junit.Test;
import support.YoseChallenge;
import yose.http.HttpResponse;
import yose.support.FileContent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class JsTest extends YoseChallenge {

    private HttpResponse response;

    @Before
    public void jsRequest() throws Exception {
        response = get( "http://localhost:8000/astroport/astroport.js" );
    }

    @Test
    public void answers() throws Exception {
        assertThat( response.code, equalTo( 200 ) );
    }

    @Test
    public void answersWithJs() throws Exception {
        assertThat( response.contentType(), equalTo( "application/javascript" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, equalTo( FileContent.of( "src/yose/worlds/astroport/astroport.js" ) ) );
    }
}
