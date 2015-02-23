package yose.http.endpoints;

import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.support.FileContent;

public class CssProvider implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put( "content-type", "text/css" );
        response.body = FileContent.of( "src/yose/worlds" + request.path );
        return response;
    }
}
