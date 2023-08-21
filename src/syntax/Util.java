package syntax;
public final class Util {
    public static boolean isCodePointBlock(int codePoint) {
        if (codePoint == ' ' || codePoint == '\n' || codePoint == '\r' || codePoint == '\t') 
            return true; 
        return false; 
    }
}
