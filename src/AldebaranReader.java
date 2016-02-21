import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Created by laj on 20-2-2016.
 */
public class AldebaranReader {

    public AldebaranStructure ReadFile(String filename) {
        AldebaranLexer lexer = null;
        try {
            lexer = new AldebaranLexer(new ANTLRFileStream(filename));
        } catch (IOException e) {
            System.out.println(String.format("File \"%s\" not found.", filename));
            return null;
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AldebaranParser parser = new AldebaranParser(tokens);

        ParseTree tree = parser.kripkestructure();
        AldebaranFileVisitor visitor = new AldebaranFileVisitor<>();
        visitor.visit(tree);

        return visitor.aldebaranStructure;
    }
}
