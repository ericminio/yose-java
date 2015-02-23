package http;

import org.junit.Before;
import org.junit.Test;
import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.endpoints.NotFound;
import yose.http.routing.HttpRequestMatcher;
import yose.http.routing.Router;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class RouterTest {

    HttpRequest request = new HttpRequest();
    Map<HttpRequestMatcher, Endpoint> routes;
    private Router router;

    @Before
    public void thisRouter() {
        routes = new HashMap<>();
        router = Router.routing( routes );
    }

    @Test
    public void returnsTheEndpointOfTheMatchingRequest() {
        Endpoint library = request -> null;
        Endpoint bakery = request -> null;
        routes.put( request -> request.path.equals( "/bakery" ), bakery );
        routes.put( request -> request.path.equals( "/library" ), library );
        request.path = "/library";

        assertThat( router.firstEndpointMatching( request ), equalTo( library ) );
    }

    @Test
    public void returnsFirstEndpointOfTheFirstMatchingRequest() {
        Endpoint first = request -> null;
        Endpoint second = request -> null;
        routes.put( request -> request.path.equals( "/library" ), first );
        routes.put( request -> request.path.equals( "/library" ), second );
        request.path = "/library";

        assertThat( router.firstEndpointMatching( request ), equalTo( first ) );
    }

    @Test
    public void returnsNotFoundWhenNothingMatchesRequest() {
        Endpoint library = request -> null;
        routes.put( request -> request.path.equals( "/library" ), library );
        request.path = "/anywhere";

        assertThat( router.firstEndpointMatching( request ), instanceOf( NotFound.class ) );
    }
}
