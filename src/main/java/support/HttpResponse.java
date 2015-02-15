package support;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    public int code;
    public Map<String, String> headers = new HashMap<>();
    public String body;
}
