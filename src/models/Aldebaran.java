package models;

import models.Transition;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by laj on 21-2-2016.
 */
public class Aldebaran {

    private int firstState=0;
    private int nrOfStates = 0;
    private int nrOfTransitions = 0;

    public Set<Transition> transitions = new HashSet<>();

    public int getFirstState() {
        return firstState;
    }

    public void setFirstState(int firstState) {
        this.firstState = firstState;
    }

    public int getNrOfStates() {
        return nrOfStates;
    }

    public void setNrOfStates(int nrOfStates) {
        this.nrOfStates = nrOfStates;
    }

    public int getNrOfTransitions() {
        return nrOfTransitions;
    }

    public void setNrOfTransitions(int nrOfTransitions) {
        this.nrOfTransitions = nrOfTransitions;
    }

}
