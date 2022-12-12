package token.operands;

import token.Token;
import token.TokenVisitor;

public abstract class Operation implements Token {

    public abstract int getPriority();

    public abstract int evaluate(int a, int b);

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}