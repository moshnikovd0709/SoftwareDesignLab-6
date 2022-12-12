package token.operands;

import token.Token;
import token.TokenVisitor;

public abstract class Bracket implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}