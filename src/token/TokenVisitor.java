package token;

import token.operands.Bracket;
import token.operands.Operation;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(Bracket token);

    void visit(Operation token);
}