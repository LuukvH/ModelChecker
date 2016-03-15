import aldebaran.AldebaranReader;
import enums.Algorithm;
import models.Aldebaran;
import models.MixedKripkeStructure;
import models.Result;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        Boolean performanceTest = false;
        int nrofiterations = 1;
        String folder = "";

        Set<File> models = new HashSet<File>();
        Set<String> formulas = new HashSet<String>();
        Set<Algorithm> algorithms = new OrderedHashSet<>();

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
        args[1] = "res/boardgame/";

        if ((args.length > 1) && (args.length % 2 == 0)) {
            for (int i = 0; i < args.length - 1; i++) {
                // Aldebaran file
                if (args[i] == "-i") {
                    models.add(new File(args[i + 1]));
                    i++;
                }

                // Formula
                if (args[i] == "-f") {
                    formulas.add(args[i + 1]);
                    i++;
                }

                // Formula
                if (args[i] == "-m") {
                    switch (Integer.parseInt(args[i + 1])) {
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
                    folder = args[i + 1];
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
            for (File file : files) {
                System.out.println("Model: " + file.toString());
                models.add(file);
            }

            files = FileUtils.getFiles(folder, ".mcf");
            for (File file : files) {
                System.out.print("Formula: " + file.toString());

                // Read file and find formula
                BufferedReader br = new BufferedReader(new FileReader(file.toString()));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        line.trim();
                        if (!line.startsWith("%") && (line.length() > 0)) {
                            formulas.add(line);
                            System.out.println(" - " + line);
                        }
                        line = br.readLine();
                    }
                } finally {
                    br.close();
                }
            }

            nrofiterations = 100;
            algorithms.clear();
            algorithms.add(Algorithm.Naive);
            algorithms.add(Algorithm.EmersonAndLei);
            algorithms.add(Algorithm.Smart);
        }

        // Create header
        StringBuilder performancestring = new StringBuilder();
        StringBuilder resultstring = new StringBuilder();
        performancestring.append("file,algorithm");
        resultstring.append("file,algorithm");
        for (String formula : formulas) {
            performancestring.append("," + formula);
            resultstring.append("," + formula);
        }
        performancestring.append('\n');
        resultstring.append('\n');

        for (File model : models) {

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

            for (Algorithm algorithm : algorithms) {
                performancestring.append(String.format("%s,%s",model.toString(), algorithm.toString())); // Add algorithm to output
                resultstring.append(String.format("%s,%s",model.toString(), algorithm.toString())); // Add algorithm to output
                for (String formula : formulas) {
                    Long resultsum = 0L;
                    String answer = "";
                    for (int i = 0; i < 100; i++) {
                        System.out.print(String.format("Evaluate %s %s", algorithm.toString(), formula));
                        Result result = mixedKripkeStructure.Evaluate(formula, algorithm);
                        if (result.answer.get(0)) {
                            answer = "True";
                        } else {
                            answer = "False";
                        }
                        resultsum += result.duration;
                        System.out.println(String.format(", AD: %d (%f ms)", result.AlternationDepth, result.duration / (float) 100000));
                    }
                    Long result = resultsum / nrofiterations;
                    performancestring.append(String.format(",%d", result));
                    resultstring.append(String.format(",%s", answer));
                    System.out.println(String.format("Average: %f ms", result / (float) 100000));
                }
                performancestring.append('\n');
                resultstring.append('\n');
            }
            System.out.println();
        }

        // Write result file
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "performance.txt"), "utf-8"))) {
            writer.write(performancestring.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Write result file
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(folder + "result.txt"), "utf-8"))) {
            writer.write(resultstring.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}




