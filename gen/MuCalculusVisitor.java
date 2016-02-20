// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\MuCalculus.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MuCalculusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MuCalculusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#formulae}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulae(MuCalculusParser.FormulaeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(MuCalculusParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(MuCalculusParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#diamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiamond(MuCalculusParser.DiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#box}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBox(MuCalculusParser.BoxContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#leastfixpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuCalculusParser#greatestfixpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx);
}