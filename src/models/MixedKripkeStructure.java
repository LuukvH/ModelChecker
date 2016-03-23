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
    private Set<Integer> states;
    public Map<String, Set<Integer>[]> labelmap;

    public MixedKripkeStructure(Aldebaran aldebaranStructure) {
        nr_of_states = aldebaranStructure.getNrOfStates();
        states = new HashSet<>(aldebaranStructure.getNrOfStates());

        // Initialize memory
        labelmap = new HashMap<String, Set<Integer>[]>(aldebaranStructure.getNrOfLabels());

        BuildLabelMap(aldebaranStructure.transitions);
    }

    public int StateSize() {
        return nr_of_states;
    }

    public Set<Integer> States() {
        return states;
    }

    private void BuildLabelMap(ArrayList<Transition> transitions) {

        Transition t;
        for(int i = 0; i < transitions.size(); i++) {
            t = transitions.get(i);

            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();

            Set<Integer>[] m = labelmap.get(label);
            if (m == null) {
                m = new Set[nr_of_states];
                for (int b = 0; b < nr_of_states; b++) {
                    m[b] = new HashSet<Integer>();
                }

                labelmap.put(label, m);
            }

            m[end].add(start);
            states.add(start);
            states.add(end);
        }
    }

    public Set<Integer> getTransitions(String label, Set<Integer> bs) {
        Set<Integer> s = new HashSet<Integer>(StateSize());

        Set<Integer>[] lm = labelmap.get(label);
        for (int i : bs) {
            Set<Integer> ls = lm[i];
            if (ls != null) {
                s.addAll(ls);
            }
        }
        return s;
    }

    public Result Evaluate(String formula, Algorithm algo) {
        MuCalculusLexer lexer = new MuCalculusLexer(new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MuCalculusParser parser = new MuCalculusParser(tokens);
        ParseTree tree = parser.formulae();

        long startTime = 0;
        long endTime = 0;
        Result result = new Result();

        if (algo == Algorithm.EmersonAndLei) {
            MuCalculusVisitor<Set<Integer>> modelChecking;
            modelChecking = new EmersonLeiModelChecking(this);
            startTime = System.nanoTime();
            result.answer = modelChecking.visit(tree);
            endTime = System.nanoTime();
            result.duration = (endTime - startTime);
        } else {
            MuCalculusVisitor<Set<Integer>> modelChecking;
            modelChecking = new NaiveModelChecking(this);
            startTime = System.nanoTime();
            result.answer = modelChecking.visit(tree);
            endTime = System.nanoTime();
            result.duration = (endTime - startTime);
        }

        return result;
    }
}
