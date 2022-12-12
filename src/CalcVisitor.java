import token.NumberToken;
import token.Token;
import token.TokenVisitor;
import token.operands.Bracket;
import token.operands.Operation;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalcVisitor implements TokenVisitor {

    private Deque<Token> stack = new ArrayDeque<>();

    @Override
    public void visit(NumberToken token) {
        stack.push(token);
    }

    @Override
    public void visit(Bracket token) {
        throw new RuntimeException("bracket in polish");
    }

    @Override
    public void visit(Operation op) {
        Token rightToken = stack.pop();
        Token leftToken = stack.pop();
        if (!(rightToken instanceof NumberToken) || !(leftToken instanceof NumberToken)) {
            throw new RuntimeException("no arguments for operation found");
        }
        int left = ((NumberToken) leftToken).getValue();
        int right = ((NumberToken) rightToken).getValue();
        int result = op.evaluate(left, right);
        stack.push(new NumberToken(result));
    }

    public int getResult() {
        if (stack.size() != 1) {
            throw new RuntimeException("stack must contain exactly 1 element");
        }
        Token token = stack.pop();
        if (!(token instanceof NumberToken)) throw new RuntimeException("stack must contain number");
        return ((NumberToken) token).getValue();
    }
}