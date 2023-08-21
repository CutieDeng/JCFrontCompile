package syntax;

import java.util.Objects;

public final class RawToken implements Cloneable {

    public String content; 
    public int line; 
    public int column; 
    public String fileName; 

    @Override
    public RawToken clone() {
        try {
            return (RawToken) super.clone(); 
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); 
        }
    } 

    public void check() {
        Objects.requireNonNull(content); 
        Objects.requireNonNull(fileName); 
    }

}

