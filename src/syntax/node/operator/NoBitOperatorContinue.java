package syntax.node.operator;

import java.util.Optional;

import syntax.node.Clause;

public final class NoBitOperatorContinue extends Clause {

    public Clause subClause; 

    @Override
    public Optional<Clause> append(int nxtChar) {
        if (nxtChar == '&') {
            return Optional.empty(); 
        }
        if (nxtChar == '|') {
            return Optional.empty();
        }
        if (nxtChar == '^') {
            return Optional.empty(); 
        }
        return subClause.append(nxtChar); 
    }
    
}
