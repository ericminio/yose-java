package http;

import org.junit.Before;
import org.junit.Test;
import support.YoseChallenge;
import yose.http.HttpResponse;
import yose.support.FileContent;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class CssTest extends YoseChallenge {

    private HttpResponse response;

    @Before
    public void cssRequest() throws Exception {
        response = get( "http://localhost:8000/astroport/astroport.css" );
    }

    @Test
    public void answers() throws Exception {
        assertThat( response.code, equalTo( 200 ) );
    }

    @Test
    public void answersWithCss() throws Exception {
        assertThat( response.contentType(), containsString( "text/css" ) );
    }

    @Test
    public void answersWithExpectedResponse() throws Exception {
        assertThat( response.body, equalTo( FileContent.of( "src/yose/worlds/astroport/astroport.css" ) ) );
    }
}
