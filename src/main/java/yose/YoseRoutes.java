package yose;

import yose.challenges.HelloYose;
import yose.challenges.Ping;

import java.util.HashMap;

public class YoseRoutes extends HashMap<String, Endpoint> {

    public YoseRoutes() {
        put( "/ping", new Ping() );
        put( "/", new HelloYose() );
    }
}
