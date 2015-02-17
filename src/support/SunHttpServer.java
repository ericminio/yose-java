package support;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class SunHttpServer implements Server {

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
        server.stop(0);
    }

    @Override
    public void serving(Map<String, Endpoint> routes) {
        this.routes = routes;
    }

    private void send(HttpExchange exchange, Endpoint endpoint) throws IOException {
        HttpRequest request = buildRequest(exchange);
        HttpResponse response = endpoint.handle(request);
        sendResponse(exchange, response);
    }

    private HttpRequest buildRequest(HttpExchange exchange) {
        HttpRequest request = new HttpRequest();
        request.query = exchange.getRequestURI().getRawQuery();
        return request;
    }

    private void sendResponse(HttpExchange exchange, HttpResponse response) throws IOException {
        response.headers.forEach((header, value) -> exchange.getResponseHeaders().add(header, value));
        exchange.sendResponseHeaders(response.code, 0);
        exchange.getResponseBody().write(response.body.getBytes());
        exchange.close();
    }
}
