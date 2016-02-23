import models.MixedKripkeStructure;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Set;

/**
 * Created by laj on 23-2-2016.
 */
public class FormulaValidator {

    public static Set<Integer> Validate(MixedKripkeStructure mixedKripkeStructure, String formula) {

        MuCalculusLexer lexer = new MuCalculusLexer(new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MuCalculusParser parser = new MuCalculusParser(tokens);
        ParseTree tree = parser.formulae();
        ModelChecking modelChecking = new ModelChecking(mixedKripkeStructure);
        Set<Integer> result = modelChecking.visit(tree);

        return result;
    }
}
