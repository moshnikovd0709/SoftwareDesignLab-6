package token.state;

import token.Token;
import token.Tokenizer;

public class Error extends State {

    public Error(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token getToken() {
        throw new RuntimeException("asking error state for token");
    }

    @Override
    public State getNextState() {
        throw new RuntimeException("asking error state for next state");
    }
}