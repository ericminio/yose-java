package http;

import org.junit.Before;
import org.junit.Test;
import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.endpoints.NotFound;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NotFoundTest {

    Endpoint notFound = new NotFound();
    private HttpResponse response;

    @Before
    public void thisEndpoint() {
        response = notFound.handle( new HttpRequest() );
    }

    @Test
    public void returns404() {
        assertThat( response.code, equalTo( 404 ) );
    }

    @Test
    public void returnsEmptyBody() {
        assertThat( response.body, equalTo( "" ) );
    }
}
