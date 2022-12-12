import token.NumberToken;
import token.TokenVisitor;
import token.operands.Bracket;
import token.operands.Operation;

import java.io.PrintStream;

public class PrintVisitor implements TokenVisitor {

    private final PrintStream out;

    public PrintVisitor(PrintStream stream) {
        out = stream;
    }

    @Override
    public void visit(NumberToken token) {
        out.print(token + " ");
    }

    @Override
    public void visit(Bracket token) {
        out.print(token + " ");
    }

    @Override
    public void visit(Operation token) {
        out.print(token + " ");
    }
}