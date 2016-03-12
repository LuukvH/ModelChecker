package smart;

import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import smart.RecursionVariable;

import java.util.*;

public class SmartModelChecking extends AbstractParseTreeVisitor<BitSet> implements MuCalculusVisitor<BitSet> {

	private MixedKripkeStructure mixedKripkeStructure;
	private Map<String, RecursionVariable> recursionVariableMap = new HashMap<String, RecursionVariable>();

	public SmartModelChecking(MixedKripkeStructure mixedKripkeStructure, Map<String, RecursionVariable> recursionVariableMap ) {
		this.mixedKripkeStructure = mixedKripkeStructure;
		this.recursionVariableMap = recursionVariableMap;
	}

	@Override public BitSet visitFormulae(MuCalculusParser.FormulaeContext ctx) {
		if (ctx.changed) {
			BitSet s = visitChildren(ctx);
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	@Override public BitSet visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
		if (ctx.changed) {
			BitSet s = visit(ctx.left());
			s.and(visit(ctx.right()));
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	@Override public BitSet visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
		if (ctx.changed) {
			BitSet s = visit(ctx.left());
			s.or(visit(ctx.right()));
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	@Override public BitSet visitDiamond(MuCalculusParser.DiamondContext ctx) {
		if (ctx.changed) {
			String label = ctx.label().getText();
			BitSet s = diamond(label, visit(ctx.formulae()));
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	private BitSet diamond(String label, BitSet bs) {

		BitSet s = new BitSet(mixedKripkeStructure.StateSize());

		Map<Integer, BitSet> lm = mixedKripkeStructure.labelmap.get(label);
		for (int i = bs.nextSetBit(0); i != -1; i = bs.nextSetBit(i + 1)) {
			BitSet ls = lm.get(i);
			if (ls != null) {
				s.or(ls);
			}
		}
		return s;
	}

	private BitSet not(BitSet s) {
		s.xor(mixedKripkeStructure.States);
		return s;
	}

	@Override public BitSet visitBox(MuCalculusParser.BoxContext ctx) {
		if (ctx.changed) {
			String label = ctx.label().getText();
			BitSet s = not(diamond(label, not(visit(ctx.formulae()))));
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	@Override public BitSet visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
		if (ctx.changed) {
			String variable = ctx.startrecursion().getText();
			RecursionVariable v = recursionVariableMap.get(variable);
			BitSet s = v.getValue();
			if (!v.isSet()) {
				s = new BitSet(mixedKripkeStructure.StateSize());
				v.setValue(s);
			}

			BitSet nstates = visit(ctx.formulae());
			while (!s.equals(nstates)) {
				s.or(nstates);
				v.setValue(s);
				nstates = visit(ctx.formulae());
			}
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
	}

	@Override public BitSet visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
		if (ctx.changed) {
		String variable = ctx.startrecursion().getText();
			RecursionVariable v = recursionVariableMap.get(variable);
			BitSet s = v.getValue();
			if (!v.isSet()) {
				s =  (BitSet)mixedKripkeStructure.States.clone();
				v.setValue(s);
			}

		BitSet nstates = visit(ctx.formulae());

		while (!s.equals(nstates)) {
			s.and(nstates);
			v.setValue(s);
			nstates = visit(ctx.formulae());
		}
			ctx.value = (BitSet) s.clone();
			ctx.changed = false;
			return s;
		} else {
			return (BitSet)ctx.value.clone();
		}
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
		BitSet s = (BitSet)mixedKripkeStructure.States.clone();
		return s;
	}

	@Override public  BitSet visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
		return new BitSet(mixedKripkeStructure.StateSize());
	}

	@Override public  BitSet visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
		BitSet s = new BitSet(mixedKripkeStructure.StateSize());
		BitSet f = recursionVariableMap.get(ctx.getText()).getValue();
		if (f!=null) {
			s.or(f);
		}
		return s;
	}
}