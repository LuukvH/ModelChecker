package models;

import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;

public class NaiveModelChecking extends AbstractParseTreeVisitor<BitSet> implements MuCalculusVisitor<BitSet> {

    private IMixedKripkeStructure mixedKripkeStructure;
    private Map<String, BitSet> fixpoint = new HashMap<String, BitSet>();

    public NaiveModelChecking(IMixedKripkeStructure mixedKripkeStructure) {
        this.mixedKripkeStructure = mixedKripkeStructure;
    }

    @Override public BitSet visitFormulae(MuCalculusParser.FormulaeContext ctx) {
        return visitChildren(ctx);
    }

    @Override public BitSet visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
        BitSet s = visit(ctx.left());
        s.and(visit(ctx.right()));
        return s;
    }

    @Override public BitSet visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
        BitSet s = visit(ctx.left());
        s.or(visit(ctx.right()));
        return s;
    }

    @Override public BitSet visitDiamond(MuCalculusParser.DiamondContext ctx) {
        String label = ctx.label().getText();
        return diamond(label, visit(ctx.formulae()));
    }

    private BitSet diamond(String label, BitSet bs) {
        return mixedKripkeStructure.getTransitions(label, bs);
    }

    private BitSet not(BitSet s) {
        s.xor(mixedKripkeStructure.States());
        return s;
    }

    @Override public BitSet visitBox(MuCalculusParser.BoxContext ctx) {
        String label = ctx.label().getText();
        return not(diamond(label, not(visit(ctx.formulae()))));
    }

    @Override public BitSet visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
        String variable = ctx.startrecursion().getText();
        BitSet s = new BitSet(mixedKripkeStructure.StateSize());
        fixpoint.put(variable, s);
        BitSet nstates = visit(ctx.formulae());

        while (!s.equals(nstates)) {
            s.or(nstates);
            fixpoint.put(variable, s);
            nstates = visit(ctx.formulae());
        }
        return s;
    }

    @Override public BitSet visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
        String variable = ctx.startrecursion().getText();
        BitSet s = (BitSet)mixedKripkeStructure.States().clone();
        fixpoint.put(variable, s);
        BitSet nstates = visit(ctx.formulae());

        while (!s.equals(nstates)) {
            s.and(nstates);
            fixpoint.put(variable, s);
            nstates = visit(ctx.formulae());
        }
        return s;
    }

    @Override public BitSet visitLeft(MuCalculusParser.LeftContext ctx) {
        return visit(ctx.formulae());
    }

    @Override public BitSet visitRight(MuCalculusParser.RightContext ctx) {
        return visit(ctx.formulae());
    }

    @Override
    public BitSet visitLabel(MuCalculusParser.LabelContext ctx) {
        return new BitSet(mixedKripkeStructure.StateSize());
    }

    @Override public BitSet visitMfalse(MuCalculusParser.MfalseContext ctx) {
        return new BitSet(mixedKripkeStructure.StateSize());
    }

    @Override public BitSet visitMtrue(MuCalculusParser.MtrueContext ctx) {
        BitSet s = (BitSet)mixedKripkeStructure.States().clone();
        return s;
    }

    @Override public  BitSet visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
        return new BitSet(mixedKripkeStructure.StateSize());
    }

    @Override public  BitSet visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
        BitSet s = new BitSet(mixedKripkeStructure.StateSize());
        BitSet f = fixpoint.get(ctx.getText());
        if (f!=null) {
            s.or(f);
        }
        return s;
    }
}