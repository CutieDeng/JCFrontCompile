package syntax.node.block;

import java.util.Optional;

import syntax.Util;
import syntax.node.Clause;

public class NonBlockContinue extends Clause {

    public Clause subClause; 

    @Override
    public Optional<Clause> append(int nxtChar) {
        if (Util.isCodePointBlock(nxtChar)) {
            return Optional.empty(); 
        }
        return subClause.append(nxtChar);  
    } 
    
}
