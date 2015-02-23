package yose.http.endpoints;

import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;

public class NotFound implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 404;
        response.body = "";
        return response;
    }
}
