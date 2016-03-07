import aldebran.AldebaranReader;
import enums.Algorithm;
import models.Aldebaran;
import models.MixedKripkeStructure;
import models.Result;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        String filename = "";
        String formula = "";
        Algorithm algo = Algorithm.Naive;

        args = new String[6];
        args[0] = "-i";
        //args[1] = "res/test.aut";
        args[1] = "res/dining/dining_5.aut";
        args[2] = "-m";
        args[3] = "4";
        args[4] = "-f";
        args[5] = "nu X. (([i]X && ([plato]X && [others]X )) && mu Y. ([i]Y && (<plato>true || <others>true)) )";

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
                    }
                }
            }
        } else {
            System.out.println("-i <filename>  To specify and label transition system (LTS) in aldebaran format.");
            System.out.println("-f <formula>   Formula in MuCalculus to validate on the LTS.");
            System.out.println("-m <i>         Select model checking algorithm.");
            System.out.println("               0 = naive (default), 1 = emerson and lei, 3 = custom");
        }

        if (filename.length() == 0 || formula.length() == 0) {
            System.out.println("Wrong input");
        }

        Long startTime;
        System.out.print("Read input file ");
        startTime = System.nanoTime();
        AldebaranReader reader = new AldebaranReader();
        Aldebaran aldebaranStructure = reader.ReadFile(filename);
        System.out.printf("(%f ms) \n",  (System.nanoTime() - startTime)/(float)100000);

        if (aldebaranStructure == null)
            return;

        startTime = System.nanoTime();
        System.out.print("Build MixedKripkeStructure ");
        MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
        System.out.printf("(%f ms) \n",  (System.nanoTime() - startTime)/(float)100000);


        Result result = mixedKripkeStructure.Evaluate(formula, algo);
        System.out.printf("(%f ms) \n", result.duration / (float)100000);
    }
}




