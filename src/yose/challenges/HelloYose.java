package yose.challenges;

import http.HttpRequest;
import http.HttpResponse;
import http.Endpoint;

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
