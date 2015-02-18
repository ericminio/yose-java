package yose.support;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileContent {

    public static String of(String file) {
        try {
            List<String> lines = Files.readAllLines( Paths.get( file ), StandardCharsets.UTF_8 );
            return lines.stream().collect( Collectors.joining( "\n" ) );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
}
