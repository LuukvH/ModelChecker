// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\MuCalculus.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MuCalculusParser}.
 */
public interface MuCalculusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#formulae}.
	 * @param ctx the parse tree
	 */
	void enterFormulae(MuCalculusParser.FormulaeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#formulae}.
	 * @param ctx the parse tree
	 */
	void exitFormulae(MuCalculusParser.FormulaeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(MuCalculusParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(MuCalculusParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(MuCalculusParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(MuCalculusParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#diamond}.
	 * @param ctx the parse tree
	 */
	void enterDiamond(MuCalculusParser.DiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#diamond}.
	 * @param ctx the parse tree
	 */
	void exitDiamond(MuCalculusParser.DiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#box}.
	 * @param ctx the parse tree
	 */
	void enterBox(MuCalculusParser.BoxContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#box}.
	 * @param ctx the parse tree
	 */
	void exitBox(MuCalculusParser.BoxContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#leastfixpoint}.
	 * @param ctx the parse tree
	 */
	void enterLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#leastfixpoint}.
	 * @param ctx the parse tree
	 */
	void exitLeastfixpoint(MuCalculusParser.LeastfixpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#greatestfixpoint}.
	 * @param ctx the parse tree
	 */
	void enterGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#greatestfixpoint}.
	 * @param ctx the parse tree
	 */
	void exitGreatestfixpoint(MuCalculusParser.GreatestfixpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#left}.
	 * @param ctx the parse tree
	 */
	void enterLeft(MuCalculusParser.LeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#left}.
	 * @param ctx the parse tree
	 */
	void exitLeft(MuCalculusParser.LeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#right}.
	 * @param ctx the parse tree
	 */
	void enterRight(MuCalculusParser.RightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#right}.
	 * @param ctx the parse tree
	 */
	void exitRight(MuCalculusParser.RightContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(MuCalculusParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(MuCalculusParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#mfalse}.
	 * @param ctx the parse tree
	 */
	void enterMfalse(MuCalculusParser.MfalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#mfalse}.
	 * @param ctx the parse tree
	 */
	void exitMfalse(MuCalculusParser.MfalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#mtrue}.
	 * @param ctx the parse tree
	 */
	void enterMtrue(MuCalculusParser.MtrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#mtrue}.
	 * @param ctx the parse tree
	 */
	void exitMtrue(MuCalculusParser.MtrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#startrecursion}.
	 * @param ctx the parse tree
	 */
	void enterStartrecursion(MuCalculusParser.StartrecursionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#startrecursion}.
	 * @param ctx the parse tree
	 */
	void exitStartrecursion(MuCalculusParser.StartrecursionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuCalculusParser#endrecursion}.
	 * @param ctx the parse tree
	 */
	void enterEndrecursion(MuCalculusParser.EndrecursionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuCalculusParser#endrecursion}.
	 * @param ctx the parse tree
	 */
	void exitEndrecursion(MuCalculusParser.EndrecursionContext ctx);
}