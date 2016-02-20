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
}