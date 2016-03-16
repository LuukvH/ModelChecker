package aldebaran;

import models.Aldebaran;
import models.Transition;
import org.antlr.v4.runtime.tree.*;

/**
 * This class provides an empty implementation of {@link AldebaranVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class AldebaranFileVisitor<T> extends AbstractParseTreeVisitor<T> implements AldebaranVisitor<T> {

	public Aldebaran aldebaranStructure;
	private Transition transition;

	@Override
	public T visitAldebaran(AldebaranParser.AldebaranContext ctx) {
		aldebaranStructure = new Aldebaran();
		return visitChildren(ctx);
	}

	public T visitAut_header(AldebaranParser.Aut_headerContext ctx) {
		return visitChildren(ctx);
	}

	 public T visitFirst_state(AldebaranParser.First_stateContext ctx) {
		aldebaranStructure.setFirstState(Integer.parseInt(ctx.getText()));
		return visitChildren(ctx);
	}

	 public T visitNr_of_transitions(AldebaranParser.Nr_of_transitionsContext ctx) {
		aldebaranStructure.setNrOfTransitions(Integer.parseInt(ctx.getText()));
		return visitChildren(ctx);
	}

	 public T visitNr_of_states(AldebaranParser.Nr_of_statesContext ctx) {
		aldebaranStructure.setNrOfStates(Integer.parseInt(ctx.getText()));
		return visitChildren(ctx);
	}

	 public T visitAut_edge(AldebaranParser.Aut_edgeContext ctx) {
		transition = new Transition();
		aldebaranStructure.transitions.add(transition);
		return visitChildren(ctx);
	}

	 public T visitStart_state(AldebaranParser.Start_stateContext ctx) {
		transition.setStartState(Integer.parseInt(ctx.getText()));
		return visitChildren(ctx);
	}

	 public T visitLabel(AldebaranParser.LabelContext ctx) {
		transition.setLabel(ctx.getText());
		return visitChildren(ctx);
	}

	 public T visitEnd_state(AldebaranParser.End_stateContext ctx) {
		transition.setEndState(Integer.parseInt(ctx.getText()));
		return visitChildren(ctx);
	}

}