package support;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.YoseServer;
import yose.http.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyServer implements YoseServer {

    private final Server server;

    public JettyServer(int port) {
        server = new Server( port );
    }

    @Override
    public void useRouter(Router router) {
        server.setHandler( new AbstractHandler() {
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
                HttpRequest request = buildRequest( httpServletRequest );
                HttpResponse response = router.firstEndpointMatching( request ).handle( request );
                sendResponse( httpServletResponse, response );
                baseRequest.setHandled( true );
            }
        } );
    }

    private HttpRequest buildRequest(HttpServletRequest httpServletRequest) {
        HttpRequest request = new HttpRequest();
        request.query = httpServletRequest.getQueryString();
        request.path = httpServletRequest.getRequestURI();
        return request;
    }

    private void sendResponse(HttpServletResponse httpServletResponse, HttpResponse response) throws IOException {
        response.headers.forEach( (header, value) -> httpServletResponse.setHeader( header, value ) );
        httpServletResponse.setStatus( response.code );
        httpServletResponse.getWriter().println( response.body );
    }

    @Override
    public void start() throws Exception {
        server.start();
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }
}
