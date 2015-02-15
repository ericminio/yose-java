package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpResponseBuilder {

    private HttpURLConnection connection;

    public HttpResponseBuilder(HttpURLConnection connection) {
        this.connection = connection;
    }

    public static HttpResponseBuilder open(HttpURLConnection connection) {
        return new HttpResponseBuilder( connection );
    }

    public HttpResponseForTest getResponse() throws IOException {
        HttpResponseForTest response = new HttpResponseForTest();
        response.contentType = connection.getHeaderField( "content-type" );
        response.body = readBody( connection );
        return response;
    }

    private String readBody(HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( (connection.getInputStream()) ) );
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append( output );
        }
        return sb.toString();
    }
}
