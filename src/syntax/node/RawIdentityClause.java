package syntax.node;

import java.util.Optional;

public class RawIdentityClause extends Clause {

    public String content;

    @Override
    public Optional<Clause> append(int nxtChar) {
        StringBuilder builder = new StringBuilder(content); 
        builder.appendCodePoint(nxtChar); 
        var ret = new RawIdentityClause(); 
        ret.content = builder.toString(); 
        var id = new IdentityClause(); 
        id.subClause = ret; 
        return Optional.of(id); 
    } 

}
