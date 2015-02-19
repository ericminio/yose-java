package yose.worlds.start;

import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.Endpoint;
import yose.support.FileContent;

public class Home implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put("content-type", "text/html");
        response.body = FileContent.of( "src/yose/worlds/start/home.html" );
        return response;
    }
}
