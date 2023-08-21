package syntax.node;

import java.util.Optional;

public abstract class Clause {
    public abstract Optional<Clause> append(int nxtChar);  
}
