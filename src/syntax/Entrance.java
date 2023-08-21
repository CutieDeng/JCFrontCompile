package syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import syntax.node.Clause;
import syntax.node.empty.EmptyClause;

public class Entrance {
    public static void main(String[] args) throws Throwable {
        Scanner input = new Scanner(System.in); 
        var n = input.nextLine();  
        var r = test(n);
        System.out.println("size: " + r.size());
        for (Clause rClause : r) {
            var s = fromClauseToString(rClause); 
            System.out.println(s);
        }
        input.close(); 
    } 

    public static String fromClauseToString(Clause clause) throws Throwable {
        if (clause instanceof EmptyClause) {
            return "<EMPTY>"; 
        }
        while (true) {
            var currentClass = clause.getClass(); 
            try {
                var hasSub = currentClass.getField("subClause"); 
                clause = (Clause) hasSub.get(clause); 
            } catch (Throwable t) {
                var content = currentClass.getField("content"); 
                return (String ) content.get(clause); 
            }
        }
    }

    public static List<Clause> test(String input) {
        var inputArray = input.codePoints().toArray(); 
        Clause current = new EmptyClause(); 
        boolean isCurrentEmpty = true; 
        var rst = new ArrayList<Clause>(); 
        for (var i: inputArray) {
            Optional<Clause> nxt = current.append(i); 
            if (nxt.isEmpty()) {
                System.out.println("You read empty!");
                if (!(current instanceof EmptyClause)) { 
                    rst.add(current);  
                }
                current = new EmptyClause(); 
                if (!isCurrentEmpty) {
                    isCurrentEmpty = true; 
                    var nxt2 = current.append(i); 
                    if (nxt2.isPresent()) {
                        current = nxt2.get(); 
                        isCurrentEmpty = false; 
                    }
                }
            } else {
                current = nxt.get(); 
                isCurrentEmpty = false; 
            }
        }
        return rst; 
    }
}
