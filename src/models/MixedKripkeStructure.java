package models;

import MuCalculus.AlternationDepth;
import MuCalculus.MuCalculusLexer;
import MuCalculus.MuCalculusParser;
import models.Aldebaran;
import models.Transition;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * Created by laj on 21-2-2016.
 */
public class MixedKripkeStructure {

    public Set<Integer> States = new HashSet<Integer>();
    public Set<String> Labels = new HashSet<String>();
    public Map<Integer, Map<String, Set<Integer>>> transitionmap = new HashMap<Integer, Map<String, Set<Integer>>>();
    private Map<String, Map<Integer, Set<Integer>>> labelmap = new HashMap<String, Map<Integer, Set<Integer>>>(); // label, end, startstates

    public MixedKripkeStructure(Aldebaran aldebaranStructure) {
        for(Transition transition : aldebaranStructure.transitions) {
            States.add(transition.getStartState());
            States.add(transition.getEndState());
            Labels.add(transition.getLabel());
        }

        BuildTransitionMap(aldebaranStructure.transitions);
        BuildLabelMap(aldebaranStructure.transitions);
    }

    public Set<Integer> Find(String label, Integer end) {
        Map<Integer, Set<Integer>> m = labelmap.get(label);
        if (m!=null) {
            Set s = m.get(end);
            if (s!=null) {
                return s;
            }
        }
        return new HashSet<Integer>();
    }

    private void BuildLabelMap(Set<Transition> transitions) {
        for(Transition t : transitions) {
            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();

            Map<Integer, Set<Integer>> m = labelmap.get(label);
            if (m == null) {
                m = new HashMap<Integer, Set<Integer>>();
                labelmap.put(label, m);
            }

            Set<Integer> s = m.get(end);
            if (s == null) {
                s = new HashSet<Integer>();
                m.put(end, s);
            }

            s.add(start);
        }
    }

    private void BuildTransitionMap(Set<Transition> transitions) {
        for(Transition t : transitions) {
            Integer start = t.getStartState();
            Integer end = t.getEndState();
            String label = t.getLabel();

            Map<String, Set<Integer>> m = transitionmap.get(start);
            if (m == null) {
                m = new HashMap<String, Set<Integer>>();
                transitionmap.put(start, m);
            }

            Set<Integer> s = m.get(label);
            if (s == null) {
                s = new HashSet<Integer>();
                m.put(label, s);
            }

            s.add(end);
        }
    }

    public Set<Integer> Evaluate (String formula) {
        MuCalculusLexer lexer = new MuCalculusLexer(new ANTLRInputStream(formula));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MuCalculusParser parser = new MuCalculusParser(tokens);
        ParseTree tree = parser.formulae();

        // Formula
        System.out.println(String.format("Evaluate: %s", formula));

        // Calculate alternation depth
        AlternationDepth alternationDepth = new AlternationDepth();
        System.out.println(String.format("Alternation depth: %d", alternationDepth.visit(tree).getDepth()));

        ModelChecking modelChecking = new ModelChecking(this);
        Set<Integer> result = modelChecking.visit(tree);

        return result;
    }

}
