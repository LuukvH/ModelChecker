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

        String formula = "mu D. nu A .(mu B . (D || (A || B)) && mu D . true)";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        System.out.println(result.toString());

    }

}
