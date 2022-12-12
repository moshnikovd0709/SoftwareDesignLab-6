package token.operands;

public class Divide extends Operation {

    @Override
    public String toString() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public int evaluate(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}