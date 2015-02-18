package worlds.primefactors;

import org.junit.Before;
import org.junit.Test;
import support.YoseChallenge;
import yose.http.HttpResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static support.HttpGetRequest.get;

public class PowerOfTwoChallenge extends YoseChallenge {

    private HttpResponse response;

    @Before
    public void decompositionRequest() throws Exception {
        response = get( "http://localhost:8000/primeFactors?number=8" );
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
        assertThat( response.body, equalTo( "{\"number\":8,\"decomposition\":[2,2,2]}" ) );
    }
}
