package models;

import enums.Fixpoint;

/**
 * Created by laj on 21-2-2016.
 */
public class AlternationDepthNode {

    private Integer depth = 0;
    private String variable ="";
    private Fixpoint fixpoint = Fixpoint.none;

    public AlternationDepthNode(Integer depth, Fixpoint fixpoint) {
        this.depth = depth;
        this.fixpoint = fixpoint;
    }

    public AlternationDepthNode(Integer depth, String variable, Fixpoint fixpoint) {
        this.depth = depth;
        this.variable = variable;
        this.fixpoint = fixpoint;
    }

    public Fixpoint getFixpoint() {
        return fixpoint;
    }

    public void setFixpoint(Fixpoint fixpoint) {
        this.fixpoint = fixpoint;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
