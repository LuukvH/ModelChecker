import aldebran.AldebaranReader;
import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import enums.Algorithm;
import models.Aldebaran;
import models.MixedKripkeStructure;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String filename = "";
        String formula = "";
        Algorithm algo = Algorithm.Naive;

        args = new String[6];
        args[0] = "-i";
        //args[1] = "res/test.aut";
        args[1] = "res/demanding_children_10.aut";
        args[2] = "-m";
        args[3] = "4";
        args[4] = "-f";
        args[5] = "mu D. nu A .(mu B . (D || (A || B)) && mu D . true)";

        if ((args.length > 3) && (args.length % 2 == 0)) {
            for (int i = 0; i < args.length - 1; i++) {
                // Aldebaran file
                if (args[i] == "-i") {
                    filename = args[i+1];
                    i++;
                }

                // Formula
                if (args[i] == "-f") {
                    formula = args[i+1];
                    i++;
                }

                // Formula
                if (args[i] == "-m") {
                    switch(Integer.parseInt(args[i+1])) {
                        case 1:
                        algo = Algorithm.Naive;
                        break;
                        case 2:
                            algo = Algorithm.EmersonAndLei;
                            break;
                        case 3:
                            algo = Algorithm.Smart;
                            break;
                        case 4:
                            algo = Algorithm.All;
                            break;
                    }
                }
            }
        } else {
            System.out.println("-i <filename>  To specify and label transition system (LTS) in aldebaran format.");
            System.out.println("-f <formula>   Formula in MuCalculus to validate on the LTS.");
            System.out.println("-m <i>         Select model checking algorithm.");
            System.out.println("               0 = naive (default), 1 = emerson and lei, 3 = custom, 4 = all");
        }

        if (filename.length() == 0 || formula.length() == 0) {
            System.out.println("Wrond input");
        }


        AldebaranReader reader = new AldebaranReader();
        Aldebaran aldebaranStructure = reader.ReadFile(filename);

        if (aldebaranStructure == null)
            return;

        MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo);
        //System.out.println(result.toString());
    }

}
