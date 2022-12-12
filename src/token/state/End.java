package token.state;

import token.Token;
import token.Tokenizer;

public class End extends State {

    public End(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token getToken() {
        throw new RuntimeException("asking end state for token");
    }

    @Override
    public State getNextState() {
        throw new RuntimeException("asking end state for next state");
    }
}