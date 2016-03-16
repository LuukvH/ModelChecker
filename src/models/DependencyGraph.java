package models;

import MuCalculus.MuCalculusParser;
import MuCalculus.MuCalculusVisitor;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DependencyGraph extends AbstractParseTreeVisitor<Set<String>> implements MuCalculusVisitor<Set<String>> {

	private int stateSize = 0;
	public Map<String, RecursionVariable> recursionVariableMap = new HashMap<String, RecursionVariable>();

	public DependencyGraph(int StateSize) {
		stateSize = StateSize;
	}

	@Override public Set<String> visitFormulae(MuCalculusParser.FormulaeContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override public Set<String> visitConjunction(MuCalculusParser.ConjunctionContext ctx) {
		ctx.dependencies.addAll(visit(ctx.left()));
		ctx.dependencies.addAll(visit(ctx.right()));

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach( ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitDisjunction(MuCalculusParser.DisjunctionContext ctx) {
		ctx.dependencies.addAll(visit(ctx.left()));
		ctx.dependencies.addAll(visit(ctx.right()));

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach(ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitDiamond(MuCalculusParser.DiamondContext ctx) {
		ctx.dependencies.addAll(visit(ctx.formulae()));

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach(ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitBox(MuCalculusParser.BoxContext ctx) {
		ctx.dependencies.addAll(visit(ctx.formulae()));

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach( ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx) {

		recursionVariableMap.put(ctx.startrecursion().getText(), new RecursionVariable(stateSize));

		ctx.dependencies.addAll(visit(ctx.formulae()));
		ctx.dependencies.remove(ctx.startrecursion().getText());

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach( ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx) {

		recursionVariableMap.put(ctx.startrecursion().getText(), new RecursionVariable(stateSize));

		ctx.dependencies.addAll(visit(ctx.formulae()));
		ctx.dependencies.remove(ctx.startrecursion().getText());

		for(String dependency : ctx.dependencies) {
			RecursionVariable rv = recursionVariableMap.get(dependency);
			rv.attach( ctx);
		}

		return ctx.dependencies;
	}

	@Override public Set<String> visitLeft(MuCalculusParser.LeftContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public Set<String> visitRight(MuCalculusParser.RightContext ctx) {
		return visit(ctx.formulae());
	}

	@Override public Set<String> visitLabel(MuCalculusParser.LabelContext ctx) {
		return new HashSet<String>();
	}

	@Override public Set<String> visitMfalse(MuCalculusParser.MfalseContext ctx) {
		return new HashSet<String>();
	}

	@Override public Set<String> visitMtrue(MuCalculusParser.MtrueContext ctx) {
		return new HashSet<String>();
	}

	@Override public Set<String> visitStartrecursion(MuCalculusParser.StartrecursionContext ctx) {
		return new HashSet<String>();
	}

	@Override public Set<String> visitEndrecursion(MuCalculusParser.EndrecursionContext ctx) {
		ctx.dependencies = new HashSet<String>();
		ctx.dependencies.add(ctx.getText());
		return ctx.dependencies;
	}
}