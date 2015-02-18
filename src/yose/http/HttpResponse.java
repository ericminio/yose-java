package yose.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    public int code;
    public Map<String, String> headers = new HashMap<>();
    public String body;

    public String contentType() {
        return headers.get( "content-type" );
    }
}
