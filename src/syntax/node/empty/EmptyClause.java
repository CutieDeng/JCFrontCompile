package syntax.node.empty;

import java.util.Optional;

import syntax.node.Clause;
import syntax.node.block.NonBlockContinue;

public final class EmptyClause extends Clause {

    public Clause subClause;

    {
        var r = new RawEmptyClause(); 
        var nonB = new NonBlockContinue(); 
        nonB.subClause = r; 
        this.subClause = nonB; 
    } 

    @Override
    public Optional<Clause> append(int nxtChar) {
        return subClause.append(nxtChar);
    }
    
}
