package support;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import yose.http.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class SunHttpServer implements Server {

    private final HttpServer server;
    private Map<HttpRequestMatcher, Endpoint> routes;

    public SunHttpServer(int port) throws IOException {
        server = HttpServer.create( new InetSocketAddress( port ), 0 );
    }

    @Override
    public void start() {
        server.createContext( "/", exchange -> {
            handle( exchange );
        } );
        server.start();
    }

    @Override
    public void stop() {
        server.stop( 0 );
    }

    @Override
    public void serving(Map<HttpRequestMatcher, Endpoint> routes) {
        this.routes = routes;
    }

    private void handle(HttpExchange exchange) throws IOException {
        HttpRequest request = buildRequest( exchange );
        Endpoint endpoint = findEndpoint( request );
        HttpResponse response = endpoint.handle( request );

        response.headers.forEach( (header, value) -> exchange.getResponseHeaders().add( header, value ) );
        exchange.sendResponseHeaders( response.code, 0 );
        exchange.getResponseBody().write( response.body.getBytes() );
        exchange.close();
    }

    private Endpoint findEndpoint(HttpRequest request) {
        return routes.entrySet().stream().filter( r -> r.getKey().matches( request ) )
                     .findFirst().get().getValue();
    }

    private HttpRequest buildRequest(HttpExchange exchange) {
        HttpRequest request = new HttpRequest();
        request.query = exchange.getRequestURI().getRawQuery();
        request.path = exchange.getRequestURI().getPath();
        return request;
    }

}
