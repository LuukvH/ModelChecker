import aldebran.AldebaranReader;
import models.Aldebaran;
import models.MixedKripkeStructure;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        AldebaranReader reader = new AldebaranReader();
        Aldebaran aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);

        //String formula = "mu D. nu A .(mu B . (D || (A || B)) && mu D . true)";
        String formula = "<a>true";
        BitSet result = mixedKripkeStructure.Evaluate(formula);

        System.out.println(result.toString());

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
