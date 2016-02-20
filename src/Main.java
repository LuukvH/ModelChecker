import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String formula = "mu Z.<a>true";

        MuCalculusLexer lexer = new MuCalculusLexer( new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MuCalculusParser parser = new MuCalculusParser( tokens );

        ParseTree tree = parser.formulae();

        //MuCalculusBaseVisitor visitor = new MuCalculusBaseVisitor();
        //visitor.visit(tree);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.

        walker.walk(new MuCalculusBaseListener(), tree);

        CommonAST

        //
        //walker.walk();
        //walker.walk(new MuCalculusWalker(), tree);

        //walker.walk( new HelloWalker(), tree );

    }
}
