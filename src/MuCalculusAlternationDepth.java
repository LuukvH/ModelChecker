import enums.Fixpoint;
import models.AlternationDepthNode;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MuCalculusAlternationDepth extends AbstractParseTreeVisitor<AlternationDepthNode> implements MuCalculusVisitor<AlternationDepthNode> {

	@Override public AlternationDepthNode visitFormulae(MuCalculusParser.FormulaeContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override public AlternationDepthNode visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
		AlternationDepthNode left = visit(ctx.left());
		AlternationDepthNode right = visit(ctx.right());

		if (left.getDepth() > right.getDepth()) {
			return left;
		} else if (right.getDepth() > left.getDepth()) {
			return right;
		} else {
			if (left.getFixpoint() != right.getFixpoint()) {
				left.setFixpoint(Fixpoint.none);
			}
			return left;
		}
	}

	@Override public AlternationDepthNode visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
		AlternationDepthNode left = visit(ctx.left());
		AlternationDepthNode right = visit(ctx.right());

		if (left.getDepth() > right.getDepth()) {
			return left;
		} else if (right.getDepth() > left.getDepth() ) {
			return right;
		} else {
			if (left.getFixpoint() != right.getFixpoint()) {
				left.setFixpoint(Fixpoint.none);
			}
			return left;
		}
	}

	@Override public AlternationDepthNode visitDiamond(MuCalculusParser.DiamondContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitBox(MuCalculusParser.BoxContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public AlternationDepthNode visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {
		AlternationDepthNode node = visit(ctx.formulae());
		if (node.getFixpoint() != Fixpoint.least) {
			node.setDepth(1 + node.getDepth());
		}
		node.setFixpoint(Fixpoint.least);

		return node;
	}

	@Override public AlternationDepthNode visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {
		AlternationDepthNode node = visit(ctx.formulae());
		if (node.getFixpoint() != Fixpoint.greatest) {
			node.setDepth(1 + node.getDepth());
		}
		node.setFixpoint(Fixpoint.greatest);

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

	@Override public AlternationDepthNode visitRecursion(MuCalculusParser.RecursionContext ctx) {
		return new AlternationDepthNode(0, Fixpoint.none);
	}
}