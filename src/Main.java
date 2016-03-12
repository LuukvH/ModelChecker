import aldebaran.AldebaranReader;
import enums.Algorithm;
import models.Aldebaran;
import models.MixedKripkeStructure;
import models.Result;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
=======
import java.io.IOException;
>>>>>>> origin/master

public class Main {

    public static void main(String[] args) throws IOException {

        Boolean performanceTest = false;
        String folder = "";

        Set<File> models = new HashSet<File>();
        Set<String> formulas = new HashSet<String>();
        Set<Algorithm> algorithms = new HashSet<Algorithm>();

        /*
        args = new String[6];
        args[0] = "-i";
        args[1] = "res/test.aut";
        args[2] = "-m";
        args[3] = "4";
        args[4] = "-f";
        args[5] = "nu X. (([i]X && ([plato]X && [others]X )) && mu Y. ([i]Y && (<plato>true || <others>true)) )";
        */

        args = new String[2];
        args[0] = "-t";
        args[1] = "res/demanding/";

        if ((args.length > 1) && (args.length % 2 == 0)) {
            for (int i = 0; i < args.length - 1; i++) {
                // Aldebaran file
                if (args[i] == "-i") {
                    models.add(new File(args[i+1]));
                    i++;
                }

                // Formula
                if (args[i] == "-f") {
                    formulas.add(args[i+1]);
                    i++;
                }

                // Formula
                if (args[i] == "-m") {
                    switch(Integer.parseInt(args[i+1])) {
                        case 1:
                            algorithms.add(Algorithm.Naive);
                            break;
                        case 2:
                            algorithms.add(Algorithm.EmersonAndLei);
                            break;
                        case 3:
                            algorithms.add(Algorithm.Smart);
                            break;
                    }
                }

                if (args[i] == "-t") {
                    performanceTest = true;
                    folder = args[i+1];
                    i++;
                }
            }
        } else {
            System.out.println("-i <filename>  To specify and label transition system (LTS) in aldebaran format.");
            System.out.println("-f <formula>   Formula in MuCalculus to validate on the LTS.");
            System.out.println("-m <i>         Select model checking algorithm.");
            System.out.println("               0 = naive (default), 1 = emerson and lei");
        }

        if (algorithms.isEmpty()) {
            algorithms.add(Algorithm.Naive);
        }

        if (models.size() > 0 && formulas.size() > 0) {
            System.out.println("Wrong input");
        }

        if (performanceTest) {
            File[] files = FileUtils.getFiles(folder, ".aut");
            for(File file : files) {
                System.out.println("Model: " + file.toString());
                models.add(file);
            }

            files = FileUtils.getFiles(folder, ".mcf");
            for(File file : files) {
                System.out.print("Formula: " + file.toString());

                // Read file and find formula
                BufferedReader br = new BufferedReader(new FileReader(file.toString()));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        line.trim();
                        if (!line.startsWith("%") && line.length() > 0){
                            formulas.add(line);
                            System.out.println(" - " + line);
                        }
                        line = br.readLine();
                    }
                } finally {
                    br.close();
                }

                models.add(file);
            }

            algorithms.add(Algorithm.Naive);
            algorithms.add(Algorithm.EmersonAndLei);
            algorithms.add(Algorithm.Smart);
        }


        for(File model : models) {

            Long startTime;
            System.out.printf("Read model: %s", model.toString());
            startTime = System.nanoTime();
            AldebaranReader reader = new AldebaranReader();
            Aldebaran aldebaranStructure = reader.ReadFile(model.toString());
            System.out.printf("(%f ms) \n", (System.nanoTime() - startTime) / (float) 100000);

            if (aldebaranStructure == null) {
                System.out.print("Empty aldebaran file ");
                return;
            }

            startTime = System.nanoTime();
            System.out.print("Build MixedKripkeStructure ");
            MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
            System.out.printf("(%f ms) \n", (System.nanoTime() - startTime) / (float) 100000);

            // Result result = mixedKripkeStructure.Evaluate(formula, algo);
            // System.out.printf("(%f ms) \n", result.duration / (float) 100000);

        }
    }
}




