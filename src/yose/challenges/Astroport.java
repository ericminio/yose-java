package yose.challenges;

import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;

public class Astroport implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put("content-type", "text/html");
        response.body = "<html><body><label id=\"astroport-name\">Tatoine-01<label></body></html>";
        return response;
    }
}
