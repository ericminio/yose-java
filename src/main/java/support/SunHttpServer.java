package support;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import yose.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class SunHttpServer implements YoseServer {

    private final HttpServer server;
    private Map<String, Endpoint> routes;

    public SunHttpServer(int port) throws IOException {
        server = HttpServer.create( new InetSocketAddress( port ), 0 );
    }

    @Override
    public void start() {
        routes.forEach( (uri, endpoint) -> server.createContext( uri, exchange -> {
            send( exchange, endpoint );
        } ) );
        server.start();
    }

    @Override
    public void stop() {
        server.stop( 1 );
    }

    @Override
    public void setRoutes(Map<String, Endpoint> routes) {
        this.routes = routes;
    }

    private void send(HttpExchange exchange, Endpoint endpoint) throws IOException {
        exchange.getResponseHeaders().add( "content-type", endpoint.contentType() );
        exchange.sendResponseHeaders( 200, 0 );
        exchange.getResponseBody().write( endpoint.body().getBytes() );
        exchange.close();

    }
}
