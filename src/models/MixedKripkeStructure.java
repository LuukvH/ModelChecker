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
        long duration = 0;
        Result result = new Result();

        AlternationDepth alternationDepth = new AlternationDepth();
        result.AlternationDepth = alternationDepth.visit(tree).getDepth();


        if (algo == Algorithm.EmersonAndLei) {
            MuCalculusVisitor<BitSet> modelChecking;
            modelChecking = new EmersonLeiModelChecking(this);
            startTime = System.nanoTime();
            result.answer = modelChecking.visit(tree);
            endTime = System.nanoTime();
            result.duration = (endTime - startTime);
        } else if (algo == Algorithm.Smart) {
            startTime = System.nanoTime();
            DependencyGraph dg = new DependencyGraph(this.StateSize());
            dg.visit(tree);
            Map<String, RecursionVariable> recursionVariableMap = dg.recursionVariableMap;
            SmartModelChecking smartModelChecking = new SmartModelChecking(this, recursionVariableMap);
            result.answer = smartModelChecking.visit(tree);
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
