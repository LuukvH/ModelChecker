import enums.Fixpoint;
import models.AlternationDepthNode;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;

public class ModelChecking extends AbstractParseTreeVisitor<Set<Integer>> implements MuCalculusVisitor<Set<Integer>> {

	private MixedKripkeStructure mixedKripkeStructure;
	private Map<String, Set<Integer>> fixpoint = new HashMap<String, Set<Integer>>();

	public ModelChecking(MixedKripkeStructure mixedKripkeStructure) {
		this.mixedKripkeStructure = mixedKripkeStructure;
	}

	@Override public Set<Integer> visitFormulae(MuCalculusParser.FormulaeContext ctx) {
		return visitChildren(ctx);
	}

	@Override public Set<Integer> visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
		Set<Integer> left = visit(ctx.left());
		Set<Integer> right = visit(ctx.right());

		left.retainAll(right);
		return left;
	}

	@Override public Set<Integer> visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
		Set<Integer> left = visit(ctx.left());
		Set<Integer> right = visit(ctx.right());

		left.addAll(right);
		return left;
	}

	@Override public Set<Integer> visitDiamond(MuCalculusParser.DiamondContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public Set<Integer> visitBox(MuCalculusParser.BoxContext ctx) {
		String label = ctx.label().getText();
		Set<Integer> t = visit(ctx.formulae());
		Set<Integer> states = new HashSet<Integer>();

		for (Integer s : t) {
			states.addAll(mixedKripkeStructure.Find(label, s));
		}

		return states;
	}

	@Override public Set<Integer> visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
		String variable = ctx.startrecursion().getText();
		Set<Integer> states = new HashSet<Integer>();
		Set<Integer> nstates = visit(ctx.formulae());

		// Debugging only //
		int i = 0;
		System.out.println(String.format("Least fixpoint itteration %d: %s", i, states.toString()));
		// Debugging only //

		while (!states.equals(nstates)) {
			states.addAll(nstates);

			// Debugging only //
			i++;
			System.out.println(String.format("Least fixpoint itteration %d: %s", i, states.toString()));
			// Debugging only //

			fixpoint.put(variable, states);
			nstates = visit(ctx.formulae());
		}
		return states;
	}

	@Override public Set<Integer> visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
		String variable = ctx.startrecursion().getText();
		Set<Integer> states = new HashSet<Integer>();
		states.addAll(mixedKripkeStructure.States);
		fixpoint.put(variable, states);
		Set<Integer> nstates = visit(ctx.formulae());

		// Debugging only //
		int i = 0;
		System.out.println(String.format("Greatest fixpoint itteration %d: %s", i, states.toString()));
		// Debugging only //

		while (!states.equals(nstates)) {
			states.retainAll(nstates);

			// Debugging only //
			i++;
			System.out.println(String.format("Greatest fixpoint itteration %d: %s", i, states.toString()));
			// Debugging only //

			fixpoint.put(variable, states);
			nstates = visit(ctx.formulae());
		}

		return states;
	}

	@Override public Set<Integer> visitLeft(MuCalculusParser.LeftContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public Set<Integer> visitRight(MuCalculusParser.RightContext ctx) {
		return visit(ctx.formulae());
	}

	@Override
	public Set<Integer> visitLabel(MuCalculusParser.LabelContext ctx) {
		return new HashSet<Integer>();
	}

	@Override public Set<Integer> visitMfalse(MuCalculusParser.MfalseContext ctx) {
		return new HashSet<Integer>();
	}

	@Override public Set<Integer> visitMtrue(MuCalculusParser.MtrueContext ctx) {
		Set states = new HashSet<Integer>();
		states.addAll(mixedKripkeStructure.States);
		return states;
	}

	@Override public  Set<Integer> visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
		Set<Integer> states = new HashSet<Integer>();
		return states;
	}

	@Override public  Set<Integer> visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
		Set<Integer> states = new HashSet<Integer>();
		Set<Integer> f = fixpoint.get(ctx.getText());
		if (f!=null) {
			states.addAll(f);
		}
		return states;
	}
}