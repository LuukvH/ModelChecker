import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String formula = "mu Z.<a>true";

        AldebaranReader reader = new AldebaranReader();
        AldebaranStructure aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        /*
        MuCalculusLexer lexer = new MuCalculusLexer( new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MuCalculusParser parser = new MuCalculusParser( tokens );

        ParseTree tree = parser.formulae();

        //MuCalculusBaseVisitor visitor = new MuCalculusBaseVisitor();
        //visitor.visit(tree);
        ParseTreeWalker walker = new ParseTreeWalker();
*/

        //
        //walker.walk();
        //walker.walk(new MuCalculusWalker(), tree);

        //walker.walk( new HelloWalker(), tree );

    }
}
