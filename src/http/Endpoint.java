package http;


public interface Endpoint {
    HttpResponse handle(HttpRequest request);
}
