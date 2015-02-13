package yose.challenges;

import yose.Endpoint;

public class HelloYose implements Endpoint {

    @Override
    public String contentType() {
        return "text/html";
    }

    @Override
    public String body() {
        return "Hello Yose";
    }
}
