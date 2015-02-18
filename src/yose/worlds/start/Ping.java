package yose.worlds.start;

import yose.http.HttpRequest;
import yose.http.HttpResponse;
import yose.http.Endpoint;

public class Ping implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put("content-type", "application/json");
        response.body = "{\"alive\":true}";
        return response;
    }
}
