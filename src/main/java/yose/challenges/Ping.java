package yose.challenges;

import yose.Endpoint;

public class Ping implements Endpoint {

    @Override
    public String contentType() {
        return "application/json";
    }

    @Override
    public String body() {
        return "{\"alive\":true}";
    }

    @Override
    public void setQuery(String query) {

    }
}
