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
public class MixedKripkeStructure implements IMixedKripkeStructure {

    private int nr_of_states = 0;
    private BitSet states;
    public Map<String, BitSet[]> labelmap;

    //public Map<Integer, Map<String, Set<Integer>>> transitionmap = new HashMap<Integer, Map<String, Set<Integer>>>();

    public MixedKripkeStructure(Aldebaran aldebaranStructure) {
        nr_of_states = aldebaranStructure.getNrOfStates();
        states = new BitSet(aldebaranStructure.getNrOfStates());
        states.set(0, aldebaranStructure.getNrOfStates(), true);

        // Initialize memory
        labelmap = new HashMap<String, BitSet[]>(aldebaranStructure.getNrOfLabels());

        BuildLabelMap(aldebaranStructure.transitions);
    }

    @Override
    public int StateSize() {
        return nr_of_states;
    }

    public BitSet States() {
        return states;
    }

    private void BuildLabelMap(ArrayList<Transition> transitions) {

       //System.out.print("[...................]");
        Transition t;
        for(int i = 0; i < transitions.size(); i++) {
            t = transitions.get(i);

            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();

            BitSet[] m = labelmap.get(label);
            if (m == null) {
                m = new BitSet[nr_of_states];
                for (int b = 0; b < nr_of_states; b++)
                    m[b] = new BitSet(nr_of_states);

                m = new BitSet[0];
                labelmap.put(label, m);
            }

            m[end].set(start);

            if (i % 1000 == 1)
                System.out.println(String.format("%d/%d", i, transitions.size()));
        }
    }

    @Override
    public BitSet getTransitions(String label, BitSet bs) {
        BitSet s = new BitSet(StateSize());

        BitSet[] lm = labelmap.get(label);
        for (int i = bs.nextSetBit(0); i != -1; i = bs.nextSetBit(i + 1)) {
            BitSet ls = lm[i];
            if (ls != null) {
                s.or(ls);
            }
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
}
