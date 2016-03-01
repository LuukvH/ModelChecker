package models;

import MuCalculus.MuCalculusLexer;
import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import enums.Algorithm;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import smart.DependencyGraph;
import smart.RecursionVariable;
import smart.SmartModelChecking;

import java.util.*;

/**
 * Created by laj on 21-2-2016.
 */
public class MixedKripkeStructure {

    private int nr_of_states = 0;
    public BitSet States;

    public Set<String> Labels = new HashSet<String>();
    public Map<String, Map<Integer, BitSet>> labelmap = new HashMap<String, Map<Integer, BitSet>>(); // label, end, startstates

    //public Map<Integer, Map<String, Set<Integer>>> transitionmap = new HashMap<Integer, Map<String, Set<Integer>>>();

    public MixedKripkeStructure(Aldebaran aldebaranStructure) {
        for(Transition transition : aldebaranStructure.transitions) {
            Labels.add(transition.getLabel());
        }

        // Todo normalize bits if states do not start at 0
        States = new BitSet(aldebaranStructure.getNrOfStates());
        States.set(0, aldebaranStructure.getNrOfStates(), true);

        BuildLabelMap(aldebaranStructure.transitions);
    }

    public int StateSize() {
        return nr_of_states;
    }

    private void BuildLabelMap(Set<Transition> transitions) {

        for(Transition t : transitions) {
            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();

            Map<Integer, BitSet> m = labelmap.get(label);
            if (m == null) {
                m = new HashMap<Integer, BitSet>();
                labelmap.put(label, m);
            }

            BitSet s = m.get(end);
            if (s == null) {
                s = new BitSet();
                m.put(end, s);
            }

            s.set(start);
        }
    }

    public BitSet Evaluate (String formula, Algorithm algo) {
        MuCalculusLexer lexer = new MuCalculusLexer(new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MuCalculusParser parser = new MuCalculusParser(tokens);
        ParseTree tree = parser.formulae();

        // Formula
        AlternationDepth alternationDepth = new AlternationDepth();
        System.out.println(String.format("Evaluate: %s, AD: %d", formula, alternationDepth.visit(tree).getDepth()));

        long startTime = 0;
        long endTime = 0;
        long duration = 0;
        BitSet result = null;

        if (algo == Algorithm.Naive) {
            MuCalculusVisitor<BitSet> modelChecking;
            modelChecking = new NaiveModelChecking(this);
            startTime = System.nanoTime();
            result = modelChecking.visit(tree);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println(String.format("Naive Evaluation time: %f ms", duration / (float) 1000000));
        }

        if (algo == Algorithm.EmersonAndLei) {
            MuCalculusVisitor<BitSet> modelChecking;
            modelChecking = new EmersonLeiModelChecking(this);
            startTime = System.nanoTime();
            result = modelChecking.visit(tree);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println(String.format("Emerson & Lei Evaluation time: %f ms", duration / (float) 1000000));
        }

        if (algo == Algorithm.Smart) {
            startTime = System.nanoTime();
            // Create dependency graph
            System.out.println("Generate dependency graph.");
            DependencyGraph dg = new DependencyGraph(this.StateSize());
            dg.visit(tree);
            Map<String, RecursionVariable> recursionVariableMap = dg.recursionVariableMap;
            SmartModelChecking smartModelChecking = new SmartModelChecking(this, recursionVariableMap);
            result = smartModelChecking.visit(tree);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println(String.format("Smart Evaluation time: %f ms", duration / (float) 1000000));
        }

        return result;
    }
}
