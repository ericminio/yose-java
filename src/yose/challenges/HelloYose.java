package yose.challenges;

import support.HttpRequest;
import support.HttpResponse;
import support.Endpoint;

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
