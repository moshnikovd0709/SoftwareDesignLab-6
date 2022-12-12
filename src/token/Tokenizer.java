package token;

import token.state.End;
import token.state.Error;
import token.state.Start;
import token.state.State;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private State state = new Start(this);
    private final String input;
    private int index;
    private char curChar;

    private final List<Character> operations = List.of('+', '-', '*', '/');
    private final List<Character> brackets = List.of('(', ')');

    public Tokenizer(String input) {
        if (input.isEmpty()) throw new RuntimeException("empty input");
        this.input = input;
        this.index = 0;
        this.curChar = input.charAt(index);
    }

    public List<Token> getTokens() {
        List<Token> tokens = new ArrayList<>();
        skipWhitespaces();
        nextState();
        while (!isEndingState()) {
            tokens.add(state.getToken());
            skipWhitespaces();
            nextState();
        }
        if (state instanceof Error) throw new RuntimeException("Tokenizing failed");
        return tokens;
    }

    private boolean isEndingState() {
        return state instanceof End || state instanceof Error;
    }

    private void skipWhitespaces() {
        while (index < input.length() && Character.isWhitespace(curChar)) {
            nextChar();
        }
    }

    private void nextState() {
        state = state.getNextState();
    }

    public void nextChar() {
        index++;
        if (index < input.length()) {
            curChar = input.charAt(index);
        }
    }

    public char getCurChar() {
        return curChar;
    }

    public boolean isOperation() {
        return operations.contains(curChar);
    }

    public boolean isBracket() {
        return brackets.contains(curChar);
    }

    public boolean isDigit() {
        return Character.isDigit(curChar);
    }

    public boolean isEnd() {
        return index >= input.length();
    }

}