package token.state;

import token.Token;
import token.Tokenizer;

public abstract class State {

    protected final Tokenizer tokenizer;

    State(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public abstract Token getToken();

    public abstract State getNextState();
}