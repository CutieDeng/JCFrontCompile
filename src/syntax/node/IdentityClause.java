package syntax.node;

import java.util.Optional;

import syntax.node.block.NonBlockContinue;
import syntax.node.operator.NoOperatorContinue;

public class IdentityClause extends Clause {

    public Clause subClause; 
    private Clause cachedClause; 

    public IdentityClause(String clauseStr) {
        var subC = new RawIdentityClause(); 
        var opC = new NoOperatorContinue(); 
        opC.subClause = subC; 
        subC.content = clauseStr; 
        subClause = opC; 
    }
    
    public IdentityClause() {}

    @Override
    public Optional<Clause> append(int nxtChar) {
        if (cachedClause == null) {
            var c = new NonBlockContinue(); 
            c.subClause = subClause; 
            cachedClause = c; 
        }
        return cachedClause.append(nxtChar); 
    }

}
