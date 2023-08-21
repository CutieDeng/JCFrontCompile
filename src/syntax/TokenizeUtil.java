package syntax;

import java.util.*;
import java.util.stream.*; 

public final class TokenizeUtil {
    public List<String> tokenize(String src, String fileName) {
        var lines = src.lines().collect(Collectors.toList());
        var originToken = new RawToken(); 
        originToken.fileName = fileName; 
        throw new RuntimeException("Not implemented yet");  
    }
}
