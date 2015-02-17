package yose.challenges;

import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.Endpoint;

public class HelloYose implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put("content-type", "text/html");
        response.body = "Hello Yose";
        return response;
    }
}
