package yose;


import support.HttpRequest;
import support.HttpResponse;

public interface Endpoint {
    HttpResponse handle(HttpRequest request);
}
