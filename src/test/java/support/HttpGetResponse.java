package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpGetResponse {

    private HttpURLConnection connection;

    public HttpGetResponse(HttpURLConnection connection) {
        this.connection = connection;
    }

    public String contentType() {
        return connection.getHeaderField( "content-type" );
    }

    public String body() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( (connection.getInputStream()) ) );
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append( output );
        }
        return sb.toString();
    }
}
