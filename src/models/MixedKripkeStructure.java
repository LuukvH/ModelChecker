package models;

import MuCalculus.MuCalculusLexer;
import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import enums.Algorithm;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * Created by laj on 21-2-2016.
 */
public class MixedKripkeStructure {

    private int nr_of_states = 0;
    public BitSet States;

    public Set<String> Labels = new HashSet<String>();
    public Map<String, Map<Integer, BitSet>> labelmap;

    //public Map<Integer, Map<String, Set<Integer>>> transitionmap = new HashMap<Integer, Map<String, Set<Integer>>>();

    public MixedKripkeStructure(Aldebaran aldebaranStructure) {
        for(Transition transition : aldebaranStructure.transitions) {
            Labels.add(transition.getLabel());
        }

        nr_of_states = aldebaranStructure.getNrOfStates();
        States = new BitSet(aldebaranStructure.getNrOfStates());
        States.set(0, aldebaranStructure.getNrOfStates(), true);

        BuildLabelMap(aldebaranStructure.transitions);
    }

    public int StateSize() {
        return nr_of_states;
    }

    private void BuildLabelMap(Set<Transition> transitions) {

        labelmap = new HashMap<String, Map<Integer, BitSet>>(Labels.size() * 2);

        System.out.print("[...................]");
        for(Transition t : transitions) {
            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();
            Labels.add(transition.getLabel());

            Map<Integer, BitSet> m = labelmap.get(label);
            if (m == null) {
                m = new HashMap<Integer, BitSet>(nr_of_states * 2);
                labelmap.put(label, m);
            }

            BitSet s = m.get(end);
            if (s == null) {
                s = new BitSet(nr_of_states);
                m.put(end, s);
            }

            s.set(start);
        }
    }

    public Result Evaluate (String formula, Algorithm algo) {
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
}
