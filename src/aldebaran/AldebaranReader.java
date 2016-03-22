package aldebaran;

import models.Aldebaran;
import models.Transition;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by laj on 20-2-2016.
 */
public class AldebaranReader {

    private String readFile(String pathname) throws IOException {

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

    public Aldebaran ReadFile(String filename) {
        Aldebaran aldebaran;
        Set<String> labels = new HashSet<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] splitline;

            line = br.readLine();
            splitline = line.split(",");
            splitline[0]=splitline[0].replace("des (", "").trim();
            splitline[1]=splitline[1].trim();
            splitline[2]=splitline[2].replace(")", "").trim();
            int firststate = Integer.parseInt(splitline[0]);
            int nroftransitions = Integer.parseInt(splitline[1]);
            int nrofstates = Integer.parseInt(splitline[2]);
            aldebaran = new Aldebaran(firststate,nrofstates,nroftransitions);

            Transition transition;
            while ((line = br.readLine()) != null) {
                transition = new Transition();
                splitline = line.split(",");
                splitline[0]=splitline[0].replace('(', ' ').trim();
                splitline[1]=splitline[1].replace('"', ' ').trim();
                splitline[2]=splitline[2].replace(')', ' ').trim();
                transition.setStartState(Integer.parseInt(splitline[0]));
                transition.setLabel(splitline[1]);
                labels.add(splitline[1]);
                transition.setEndState(Integer.parseInt(splitline[2]));
                aldebaran.transitions.add(transition);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        aldebaran.setNrOfLabels(labels.size());
        return aldebaran;
    }
}
