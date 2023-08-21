package syntax.node;

import java.util.Optional;

public final class IfClause extends Clause {
    @Override
    public Optional<Clause> append(int nxtChar) {
        // judge nxtChar is empty block or not 
        if (syntax.Util.isCodePointBlock(nxtChar)) {
            return Optional.empty(); 
        }
        StringBuilder builder = new StringBuilder("if"); 
        builder.appendCodePoint(nxtChar); 
        var id = new IdentityClause(builder.toString()); 
        return Optional.of(id); 
    }
}
