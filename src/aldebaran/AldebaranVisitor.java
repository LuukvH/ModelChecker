// Generated from C:/Users/laj/Documents/GitHub/ModelChecker\Aldebaran.g4 by ANTLR 4.5.1
package aldebaran;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AldebaranParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AldebaranVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#aldebaran}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAldebaran(AldebaranParser.AldebaranContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#aut_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAut_header(AldebaranParser.Aut_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#first_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirst_state(AldebaranParser.First_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#nr_of_transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNr_of_transitions(AldebaranParser.Nr_of_transitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#nr_of_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNr_of_states(AldebaranParser.Nr_of_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#aut_edge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAut_edge(AldebaranParser.Aut_edgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#start_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_state(AldebaranParser.Start_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(AldebaranParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldebaranParser#end_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_state(AldebaranParser.End_stateContext ctx);
}