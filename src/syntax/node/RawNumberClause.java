package syntax.node;

import java.util.Optional;

public class RawNumberClause extends Clause {

    public String content;

    // 0b /0x /0 / 
    // 0123456

    @Override
    public Optional<Clause> append(int nxtChar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'append'");
    } 

}
