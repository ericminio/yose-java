package yose;

public interface Endpoint {

    void setQuery(String query);

    String contentType();

    String body();
}
