package token.operands;

public class Multiply extends Operation {

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public int evaluate(int a, int b) {
        return a * b;
    }
}