package token.state;

import token.NumberToken;
import token.Token;
import token.Tokenizer;

public class Number extends State {
    public Number(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token getToken() {
        StringBuilder builder = new StringBuilder();
        while (!tokenizer.isEnd() && tokenizer.isDigit()) {
            builder.append(tokenizer.getCurChar());
            tokenizer.nextChar();
        }
        return new NumberToken(Integer.parseInt(builder.toString()));
    }

    @Override
    public State getNextState() {
        if (tokenizer.isEnd()) return new End(tokenizer);
        if (tokenizer.isOperation() || tokenizer.isBracket()) return new Start(tokenizer);
        return new Error(tokenizer);
    }
}