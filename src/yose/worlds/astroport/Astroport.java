package yose.worlds.astroport;

import yose.http.Endpoint;
import yose.http.HttpRequest;
import yose.http.HttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Astroport implements Endpoint {

    @Override
    public HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        response.code = 200;
        response.headers.put( "content-type", "text/html" );
        response.body = contentOf( "src/yose/worlds/astroport/astroport.html" );
        return response;
    }

    private String contentOf(String name) {
        try {
            List<String> lines = Files.readAllLines( Paths.get( name ), StandardCharsets.UTF_8 );
            return lines.stream().collect( Collectors.joining( "\n" ) );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
}
