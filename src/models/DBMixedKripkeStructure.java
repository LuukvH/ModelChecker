package models;

import MuCalculus.MuCalculusLexer;
import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import enums.Algorithm;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.sql.*;
import java.util.*;

/**
 * Created by laj on 21-2-2016.
 */
public class DBMixedKripkeStructure implements IMixedKripkeStructure {

    private int nr_of_states = 0;
    private BitSet states;

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    String url = "jdbc:postgresql://www.kosteninbalans.nl/TrafficData";
    String user = "TrafficUser";
    String password = "n3}n]aqS~F";

    public DBMixedKripkeStructure(Aldebaran aldebaranStructure) {
        nr_of_states = aldebaranStructure.getNrOfStates();
        states = new BitSet(aldebaranStructure.getNrOfStates());
        states.set(0, aldebaranStructure.getNrOfStates(), true);

        // Initialize connection
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Initialize memory
        InitializeMemory(aldebaranStructure.transitions);
    }

    @Override
    public int StateSize() {
        return nr_of_states;
    }

    public BitSet States() {
        return states;
    }

    private void InitializeMemory(ArrayList<Transition> transitions) {
        try {
            st.execute("DROP TABLE IF EXISTS lts");
            st.execute("CREATE TABLE lts (" +
                    "vin        int," +
                    "label  VARCHAR," +
                    "vout       int," +
                    "PRIMARY KEY (vin, label, vout));");

            Transition t;
            for (int i = 0; i < transitions.size(); i++) {
                t = transitions.get(i);
                String query = "INSERT INTO lts (vin, label, vout) " +
                        String.format("VALUES (%d, '%s', '%d')",
                                t.getStartState(), t.getLabel(), t.getEndState());
                st.addBatch(query);

                if (i % 10000 == 0) {
                    System.out.printf("Progress: %d/%d \n", i, transitions.size());
                    st.executeBatch();
                }

            }
            st.executeBatch();

        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getNextException().printStackTrace();
        }
    }

    @Override
    public BitSet getTransitions(String label, BitSet bs) {
        BitSet s = new BitSet(StateSize());

        boolean first = true;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT vin FROM lts WHERE label = '%s'", label));
        for (int i = bs.nextSetBit(0); i != -1; i = bs.nextSetBit(i + 1)) {
            if (!first) {
                sb.append("OR ");
            } else {
                sb.append("AND (");
            }

            sb.append(String.format("vout = %d ", i));
            first = false;
        }
        if (!first)
            sb.append(")");

        try {
            rs = st.executeQuery(sb.toString());

            while (rs.next()) {
                s.set(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public Result Evaluate(String formula, Algorithm algo) {
        MuCalculusLexer lexer = new MuCalculusLexer(new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MuCalculusParser parser = new MuCalculusParser(tokens);
        ParseTree tree = parser.formulae();

        long startTime = 0;
        long endTime = 0;
        Result result = new Result();

        if (algo == Algorithm.EmersonAndLei) {
            MuCalculusVisitor<BitSet> modelChecking;
            modelChecking = new EmersonLeiModelChecking(this);
            startTime = System.nanoTime();
            result.answer = modelChecking.visit(tree);
            endTime = System.nanoTime();
            result.duration = (endTime - startTime);
        } else {
            MuCalculusVisitor<BitSet> modelChecking;
            modelChecking = new NaiveModelChecking(this);
            startTime = System.nanoTime();
            result.answer = modelChecking.visit(tree);
            endTime = System.nanoTime();
            result.duration = (endTime - startTime);
        }

        return result;
    }

    public void Dispose() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
