package aldebaran;

import models.Aldebaran;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        AldebaranLexer lexer = null;

        Long startTime = System.nanoTime();
        String filecontent = "";
        try {
            filecontent = readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.printf("(%f ms) \n", (System.nanoTime() - startTime) / (float) 100000);

        //try {
            //lexer = new AldebaranLexer(new ANTLRFileStream(filename));
            lexer = new AldebaranLexer(new ANTLRInputStream(filecontent));
        //} catch (IOException e) {
            //System.out.println(String.format("File \"%s\" not found.", filename));
            //return null;
        //}

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AldebaranParser parser = new AldebaranParser(tokens);

        ParseTree tree = parser.aldebaran();
        AldebaranFileVisitor visitor = new AldebaranFileVisitor();
        visitor.visit(tree);

        return visitor.aldebaranStructure;
    }
}
