package yose;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class YoseServer {

    private final HttpServer server;

    public YoseServer(int port) throws IOException {
        server = HttpServer.create( new InetSocketAddress( port ), 0 );
    }

    public void start() {
        server.createContext( "/ping", exchange -> {
            exchange.getResponseHeaders().add( "content-type", "application/json" );
            exchange.sendResponseHeaders( 200, 0 );
            OutputStream body = exchange.getResponseBody();
            body.write( "{\"alive\":true}".getBytes() );
            body.close();
            exchange.close();
        } );
        server.start();
    }

    public void stop() {
        server.stop( 1 );
    }

    public static void main(String[] args) throws IOException {
        YoseServer server = new YoseServer( 5000 );
        server.start();
    }
}
