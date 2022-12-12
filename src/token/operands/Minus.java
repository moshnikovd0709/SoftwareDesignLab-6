package token.operands;

public class Minus extends Operation {

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public int evaluate(int a, int b) {
        return a - b;
    }
}