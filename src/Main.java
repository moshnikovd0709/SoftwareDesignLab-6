import token.Token;
import token.Tokenizer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter("result.txt")) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.getTokens();

            ParserVisitor parserVisitor = new ParserVisitor();
            tokens.forEach(token -> token.accept(parserVisitor));

            List<Token> resTokens = parserVisitor.getPolishTokens();
            PrintVisitor printVisitor = new PrintVisitor(System.out);
            resTokens.forEach(token -> token.accept(printVisitor));

            CalcVisitor calcVisitor = new CalcVisitor();
            resTokens.forEach(token -> token.accept(calcVisitor));
            out.println(calcVisitor.getResult());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}