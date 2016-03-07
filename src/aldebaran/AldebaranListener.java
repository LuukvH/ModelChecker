package aldebaran;// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\Aldebaran.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AldebaranParser}.
 */
public interface AldebaranListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#kripkestructure}.
	 * @param ctx the parse tree
	 */
	void enterKripkestructure(AldebaranParser.KripkestructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#kripkestructure}.
	 * @param ctx the parse tree
	 */
	void exitKripkestructure(AldebaranParser.KripkestructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#aut_header}.
	 * @param ctx the parse tree
	 */
	void enterAut_header(AldebaranParser.Aut_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#aut_header}.
	 * @param ctx the parse tree
	 */
	void exitAut_header(AldebaranParser.Aut_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#first_state}.
	 * @param ctx the parse tree
	 */
	void enterFirst_state(AldebaranParser.First_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#first_state}.
	 * @param ctx the parse tree
	 */
	void exitFirst_state(AldebaranParser.First_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#nr_of_transitions}.
	 * @param ctx the parse tree
	 */
	void enterNr_of_transitions(AldebaranParser.Nr_of_transitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#nr_of_transitions}.
	 * @param ctx the parse tree
	 */
	void exitNr_of_transitions(AldebaranParser.Nr_of_transitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#nr_of_states}.
	 * @param ctx the parse tree
	 */
	void enterNr_of_states(AldebaranParser.Nr_of_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#nr_of_states}.
	 * @param ctx the parse tree
	 */
	void exitNr_of_states(AldebaranParser.Nr_of_statesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#aut_edge}.
	 * @param ctx the parse tree
	 */
	void enterAut_edge(AldebaranParser.Aut_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#aut_edge}.
	 * @param ctx the parse tree
	 */
	void exitAut_edge(AldebaranParser.Aut_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#start_state}.
	 * @param ctx the parse tree
	 */
	void enterStart_state(AldebaranParser.Start_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#start_state}.
	 * @param ctx the parse tree
	 */
	void exitStart_state(AldebaranParser.Start_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(AldebaranParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(AldebaranParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldebaranParser#end_state}.
	 * @param ctx the parse tree
	 */
	void enterEnd_state(AldebaranParser.End_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldebaranParser#end_state}.
	 * @param ctx the parse tree
	 */
	void exitEnd_state(AldebaranParser.End_stateContext ctx);
}