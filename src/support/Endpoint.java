package support;


public interface Endpoint {
    HttpResponse handle(HttpRequest request);
}
