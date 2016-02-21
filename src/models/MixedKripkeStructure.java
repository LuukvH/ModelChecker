package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by laj on 21-2-2016.
 */
public class MixedKripkeStructure {

    public Set<Integer> States = new HashSet<Integer>();
    public Set<String> Labels = new HashSet<String>();
    public Set<Transition> Transitions = new HashSet<Transition>();

    public MixedKripkeStructure(AldebaranStructure aldebaranStructure) {
        for(Transition transition : aldebaranStructure.transitions) {
            States.add(transition.getStartState());
            States.add(transition.getEndState());
            Labels.add(transition.getLabel());
            Transitions.add(transition);
        }
    }
}
