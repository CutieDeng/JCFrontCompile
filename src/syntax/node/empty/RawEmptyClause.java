package syntax.node.empty;

import java.util.Optional;

import syntax.node.Clause;
import syntax.node.IdentityClause;
import syntax.node.operator.NoOperatorContinue;
import syntax.node.operator.SingleOperator;

public final class RawEmptyClause extends Clause {

    @Override
    public Optional<Clause> append(int nxtChar) {
        // assert it isn't block 
        Clause a = new Clause() {
            @Override
            public Optional<Clause> append(int nxtChar) {
                return Optional.of(this); 
            }
        };
        var testOperator = new NoOperatorContinue(); 
        testOperator.subClause = a; 
        var ret = testOperator.append(nxtChar);
        var sb = new StringBuilder(); 
        sb.appendCodePoint(nxtChar); 
        var s = sb.toString(); 
        if (ret.isEmpty()) {
            var r = new SingleOperator();
            r.content = s; 
            return Optional.of(r); 
        } else {
            var id = new IdentityClause(s); 
            return Optional.of(id); 
        }
    }
    
}
