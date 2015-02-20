package yose.http;

import yose.support.FileContent;

public class JsProvider implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put( "content-type", "application/javascript" );
        response.body = FileContent.of( "src/yose/worlds" + request.path );
        return response;
    }
}
