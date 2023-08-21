package syntax.node.operator;

import java.util.Optional;

import syntax.node.Clause;

public final class SingleOperator extends Clause {
    public String content;

    @Override
    public Optional<Clause> append(int nxtChar) {
        return Optional.empty(); 
    } 
}
