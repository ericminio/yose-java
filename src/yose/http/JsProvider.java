package yose.http;

import yose.support.FileContent;

public class JsProvider implements Endpoint {

    private String fileName;

    public JsProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put( "content-type", "application/javascript" );
        response.body = FileContent.of( fileName );
        return response;
    }
}
