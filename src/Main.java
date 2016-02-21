import models.AldebaranStructure;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AldebaranReader reader = new AldebaranReader();
        AldebaranStructure aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);

        String formula = "mu D. nu A .(nu B .true && mu C . true)";
        MuCalculusLexer lexer = new MuCalculusLexer( new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MuCalculusParser parser = new MuCalculusParser( tokens );

        ParseTree tree = parser.formulae();
        MuCalculusAlternationDepth visitor = new MuCalculusAlternationDepth();
        int alternationDepth = visitor.visit(tree).getDepth();
        System.out.println(String.format("Alternation depth: %d", alternationDepth));

        //MuCalculusBaseVisitor visitor = new MuCalculusBaseVisitor();
        //visitor.visit(tree);
        /*
        ParseTreeWalker walker = new ParseTreeWalker();


        System.out.println(test);
        //
        //walker.walk();
        //walker.walk(new MuCalculusWalker(), tree);

        //walker.walk( new HelloWalker(), tree );
    */
    }
}
