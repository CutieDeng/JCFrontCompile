package syntax.node.operator;

import java.util.Optional;

import syntax.node.Clause;

public class NoOperatorContinue extends Clause {

    public Clause subClause; 
    private Clause cacheClause; 

    @Override
    public Optional<Clause> append(int nxtChar) {
        if (cacheClause == null) {
            var bitC = new NoBitOperatorContinue();
            var cmpC = new NoCmpOperatorContinue(); 
            var mdC = new NoMDOperatorContinue(); 
            var pmC = new NoPMOperatorContinue(); 
            var enC = new NoEnclosedContinue(); 
            bitC.subClause = cmpC; 
            cmpC.subClause = mdC; 
            mdC.subClause = pmC; 
            pmC.subClause = enC; 
            enC.subClause = subClause; 
            cacheClause = bitC; 
        }
        return cacheClause.append(nxtChar); 
    }
     
}
