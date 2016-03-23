package models;

import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;

public class EmersonLeiModelChecking extends AbstractParseTreeVisitor<Set<Integer>> implements MuCalculusVisitor<Set<Integer>> {

    private MixedKripkeStructure mixedKripkeStructure;
    private Map<String, Set<Integer>> fixpoint = new HashMap<String,  Set<Integer>>();

    public EmersonLeiModelChecking(MixedKripkeStructure mixedKripkeStructure) {
        this.mixedKripkeStructure = mixedKripkeStructure;
    }

    @Override public Set<Integer> visitFormulae(MuCalculusParser.FormulaeContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Set<Integer> visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
        Set<Integer> s = visit(ctx.left());
        s.retainAll(visit(ctx.right()));
        return s;
    }

    @Override public Set<Integer> visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
        Set<Integer> s = visit(ctx.left());
        s.addAll(visit(ctx.right()));
        return s;
    }

    @Override public Set<Integer> visitDiamond(MuCalculusParser.DiamondContext ctx) {
        String label = ctx.label().getText();
        return diamond(label, visit(ctx.formulae()));
    }

    private Set<Integer> diamond(String label, Set<Integer> bs) {
        return mixedKripkeStructure.getTransitions(label, bs);
    }

    private Set<Integer> not(Set<Integer> s) {
        Set<Integer> bs = new HashSet<Integer>();
        bs.addAll(mixedKripkeStructure.States());
        bs.removeAll(s);
        return bs;
    }

    @Override public Set<Integer> visitBox(MuCalculusParser.BoxContext ctx) {
        String label = ctx.label().getText();
        return not(diamond(label, not(visit(ctx.formulae()))));
    }

    @Override public Set<Integer> visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
        String variable = ctx.startrecursion().getText();

        Set<Integer> s = fixpoint.get(variable);
        if (s == null) {
            s = new HashSet<Integer>(mixedKripkeStructure.StateSize());
            fixpoint.put(variable, s);
        }

        Set<Integer> nstates = visit(ctx.formulae());
        while (!s.equals(nstates)) {
            s.addAll(nstates);
            fixpoint.put(variable, s);
            nstates = visit(ctx.formulae());
        }
        return s;
    }

    @Override public Set<Integer> visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
        String variable = ctx.startrecursion().getText();

        Set<Integer> s = fixpoint.get(variable);
        if (s == null) {
            s = new HashSet<>(mixedKripkeStructure.StateSize());
            s.addAll(mixedKripkeStructure.States());
            fixpoint.put(variable, s);
        }

        Set<Integer> nstates = visit(ctx.formulae());
        while (!s.equals(nstates)) {
            s.retainAll(nstates);
            fixpoint.put(variable, s);
            nstates = visit(ctx.formulae());
        }
        return s;
    }

    @Override public Set<Integer> visitLeft(MuCalculusParser.LeftContext ctx) {
        return visit(ctx.formulae());
    }

    @Override public Set<Integer> visitRight(MuCalculusParser.RightContext ctx) {
        return visit(ctx.formulae());
    }

    @Override
    public Set<Integer> visitLabel(MuCalculusParser.LabelContext ctx) {
        return new HashSet<Integer>(mixedKripkeStructure.StateSize());
    }

    @Override public Set<Integer> visitMfalse(MuCalculusParser.MfalseContext ctx) {
        return new HashSet<Integer>(mixedKripkeStructure.StateSize());
    }

    @Override public Set<Integer> visitMtrue(MuCalculusParser.MtrueContext ctx) {
        HashSet<Integer> s = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        s.addAll(mixedKripkeStructure.States());
        return s;
    }

    @Override public  Set<Integer> visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
        return new HashSet<Integer>(mixedKripkeStructure.StateSize());
    }

    @Override public  Set<Integer> visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
        Set<Integer> s = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        Set<Integer> f = fixpoint.get(ctx.getText());
        if (f!=null) {
            s.addAll(f);
        }
        return s;
    }
}