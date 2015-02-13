package support;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetRequest {

    public static HttpResponse getResponseOf(String uri) throws IOException {
        URL url = new URL( uri );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return HttpResponseBuilder.open( connection ).getResponse();
    }
}
