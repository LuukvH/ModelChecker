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
        args[1] = "res/dining/dining_9.aut";
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


        ArrayList<String> files = new ArrayList<String>(){{
            add("res/dining/dining_2.aut");
            add("res/dining/dining_3.aut");
            add("res/dining/dining_4.aut");
            add("res/dining/dining_5.aut");
            add("res/dining/dining_6.aut");
            add("res/dining/dining_7.aut");
            add("res/dining/dining_8.aut");
            add("res/dining/dining_9.aut");
            add("res/dining/dining_10.aut");
            add("res/dining/dining_11.aut");
        }};

        Map<String, String> formulas = new HashMap<String, String>()
        {{
            put("invariantly_inevitably_eat", "nu X. (([i]X && ([plato]X && [others]X )) && mu Y. ([i]Y && (<plato>true || <others>true)) ))");
            put("invariantly_plato_starves", "nu X. (([i]X && [others]X ) && nu Y. (<i>Y || <others>Y) )");
            put("invariantly_possibly_eat", "nu X. (([i]X && ([plato]X && [others]X )) && mu Y. ((<i>Y || <others>Y) || <plato>true ))");
            put("plato_infinitely_often_can_eat", "nu X. mu Y. ( (<plato>X || <i>Y) || <others>Y)");
        }};

        for (Map.Entry<String, String> entry : formulas.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("# " + entry.getKey().toString());
            stringBuilder.append('\n');
            formula = entry.getValue();
            for (String file : files) {

                filename = file;

                AldebaranReader reader = new AldebaranReader();
                Aldebaran aldebaranStructure = reader.ReadFile(filename);

                if (aldebaranStructure == null)
                    return;

                stringBuilder.append("-- " + filename + '\n');
                System.out.println(String.format("File: %s", filename));

                int nummerOfTest = 100;
                MixedKripkeStructure mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);

                algo = Algorithm.Naive;
                Result nresult = new Result();
                stringBuilder.append("naive");
                for (int i = 0; i < nummerOfTest; i++) {
                    nresult = mixedKripkeStructure.Evaluate(formula, algo);
                    System.out.println(String.format("%d - Algorithm: %s, Duration: %f ms", i, algo.name(), nresult.duration / (float) 1000000));

                    stringBuilder.append(",");
                    stringBuilder.append(nresult.duration);
                }

                stringBuilder.append('\n');
                System.out.println();

                algo = Algorithm.EmersonAndLei;
                Result eresult = new Result();
                stringBuilder.append("EmersonAndLei");
                for (int i = 0; i < nummerOfTest; i++) {
                    eresult = mixedKripkeStructure.Evaluate(formula, algo);
                    System.out.println(String.format("%d - Algorithm: %s, Duration: %f ms", i, algo.name(), eresult.duration / (float) 1000000));

                    stringBuilder.append(",");
                    stringBuilder.append(eresult.duration);
                }

                stringBuilder.append('\n');
                System.out.println();
                System.out.println();

                algo = Algorithm.Smart;
                Result sresult = new Result();
                stringBuilder.append("Smart");
                for (int i = 0; i < nummerOfTest; i++) {
                    sresult = mixedKripkeStructure.Evaluate(formula, algo);
                    System.out.println(String.format("%d - Algorithm: %s, Duration: %f ms", i, algo.name(), sresult.duration / (float) 1000000));

                    stringBuilder.append(",");
                    stringBuilder.append(sresult.duration);
                }

                stringBuilder.append('\n');
                System.out.println();
            }


            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("output/result_" + entry.getKey().toString() + ".csv"));
                writer.write(stringBuilder.toString());

            } catch (IOException e) {
                System.out.println("Error occured writing file.");
            } finally {
                try {
                    if (writer != null)
                        writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

}



