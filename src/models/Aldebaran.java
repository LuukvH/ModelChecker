package models;

import models.Transition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laj on 21-2-2016.
 */
public class Aldebaran {

    private int firstState = 0;
    private int nrOfStates = 0;
    private int nrOfTransitions = 0;
    private int nrOfLabels = 0;

    public Aldebaran(int firstState, int nrOfStates, int nrOfTransitions) {
        this.firstState = firstState;
        this.nrOfStates = nrOfStates;
        this.nrOfTransitions = nrOfTransitions;

        transitions = new ArrayList<>(nrOfTransitions);
    }

    public void setNrOfLabels(int value) { nrOfLabels = value; }

    public int getNrOfLabels() { return nrOfLabels; }

    public ArrayList<Transition> transitions;

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
