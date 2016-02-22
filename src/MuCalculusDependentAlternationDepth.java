import enums.Fixpoint;
import models.AlternationDepthNode;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MuCalculusDependentAlternationDepth extends AbstractParseTreeVisitor<AlternationDepthNode> implements MuCalculusVisitor<AlternationDepthNode> {

	private Map<String, Fixpoint> fixpoints = new HashMap<String, Fixpoint>();

	@Override public AlternationDepthNode visitFormulae(MuCalculusParser.FormulaeContext ctx) {
		return visitChildren(ctx);
	}

	@Override public AlternationDepthNode visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
		AlternationDepthNode left = visit(ctx.left());
		AlternationDepthNode right = visit(ctx.right());

		if (left.getDepth() > right.getDepth()) {
			return left;
		} else {
			return right;
		}
	}

	@Override public AlternationDepthNode visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
		AlternationDepthNode left = visit(ctx.left());
		AlternationDepthNode right = visit(ctx.right());

		if (left.getDepth() > right.getDepth()) {
			return left;
		} else {
			return right;
		}
	}

	@Override public AlternationDepthNode visitDiamond(MuCalculusParser.DiamondContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitBox(MuCalculusParser.BoxContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
		String variable = visit(ctx.startrecursion()).getVariable();
		fixpoints.put(variable, Fixpoint.least);
		AlternationDepthNode node = visit(ctx.formulae());
		fixpoints.remove(variable);
		if (node.getFixpoint() == Fixpoint.greatest) {
			if (node.getVariable() != variable) {
				node.setDepth(node.getDepth() + 1);
			}
		}
		return node;
	}

	@Override public AlternationDepthNode visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
		String variable = visit(ctx.startrecursion()).getVariable();
		fixpoints.put(variable, Fixpoint.greatest);
		AlternationDepthNode node = visit(ctx.formulae());
		fixpoints.remove(variable);
		if (node.getFixpoint() == Fixpoint.least) {
			if (node.getVariable() != variable) {
				node.setDepth(node.getDepth() + 1);
			}
		}
		return node;
	}

	@Override public AlternationDepthNode visitLeft(MuCalculusParser.LeftContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitRight(MuCalculusParser.RightContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitLabel(MuCalculusParser.LabelContext ctx) {
		return new AlternationDepthNode(0, Fixpoint.none);
	}

	@Override public AlternationDepthNode visitMfalse(MuCalculusParser.MfalseContext ctx) {
		return new AlternationDepthNode(0, Fixpoint.none);
	}

	@Override public AlternationDepthNode visitMtrue(MuCalculusParser.MtrueContext ctx) {
		return new AlternationDepthNode(0, Fixpoint.none);
	}

	@Override public AlternationDepthNode visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
		return new AlternationDepthNode(0, ctx.getText(), Fixpoint.none);
	}

	@Override public AlternationDepthNode visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
		return new AlternationDepthNode(0, ctx.getText(), fixpoints.get(ctx.getText()));
	}
}