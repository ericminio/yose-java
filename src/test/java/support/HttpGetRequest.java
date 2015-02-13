package support;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetRequest {

    private String uri;

    public HttpGetRequest(String uri) {
        this.uri = uri;
    }


    public HttpGetResponse open() throws IOException {
        URL url = new URL( uri );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return new HttpGetResponse( connection );
    }
}
