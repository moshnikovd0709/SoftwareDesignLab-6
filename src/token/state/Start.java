package token.state;

import token.Token;
import token.Tokenizer;
import token.operands.OpenBracket;
import token.operands.CloseBracket;
import token.operands.Divide;
import token.operands.Minus;
import token.operands.Multiply;
import token.operands.Plus;

public class Start extends State {

    public Start(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token getToken() {
        char c = tokenizer.getCurChar();
        tokenizer.nextChar();
        return switch (c) {
            case '*' -> new Multiply();
            case '/' -> new Divide();
            case '-' -> new Minus();
            case '+' -> new Plus();
            case '(' -> new OpenBracket();
            case ')' -> new CloseBracket();
            default -> throw new RuntimeException("Unexpected token: " + c);
        };
    }

    @Override
    public State getNextState() {
        if (tokenizer.isEnd()) return new End(tokenizer);
        if (tokenizer.isBracket() || tokenizer.isOperation()) return this;
        if (tokenizer.isDigit()) return new Number(tokenizer);
        return new Error(tokenizer);
    }
}