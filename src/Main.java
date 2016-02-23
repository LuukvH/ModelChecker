import models.AldebaranStructure;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        AldebaranReader reader = new AldebaranReader();
        AldebaranStructure aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);

        //String formula = "mu D. nu A .(mu B . (D || (A || B)) && mu D . true)";
        String formula = "mu X .[a] true";
        MuCalculusLexer lexer = new MuCalculusLexer( new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MuCalculusParser parser = new MuCalculusParser( tokens );

        ParseTree tree = parser.formulae();
        MuCalculusDependentAlternationDepth visitor = new MuCalculusDependentAlternationDepth();
        int alternationDepth = visitor.visit(tree).getDepth();
        System.out.println(String.format("Alternation depth: %d", alternationDepth));

        ModelChecking modelChecking = new ModelChecking(mixedKripkeStructure);
        Set<Integer> result = modelChecking.visit(tree);
        print(result);




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

    private static void print(Set<Integer> states) {
        System.out.println(states.toString());
    }
}
