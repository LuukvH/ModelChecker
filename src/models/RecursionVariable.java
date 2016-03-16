package models;

import ObserverPattern.Subject;

import java.util.BitSet;

/**
 * Created by laj on 29-2-2016.
 */
public class RecursionVariable extends Subject {

    private int size = 0;
    private BitSet value;
    private boolean set = false;

    public boolean isSet() {
        return set;
    }

    public RecursionVariable(int size) {
        this.size = size;
        value = new BitSet(size);
    }

    public void reset() {
        set = false;
        value.clear();
    }

    public void setValue(BitSet bs) {

        if (!value.equals(bs)) {
            set = true;
            value = (BitSet) bs.clone();
            notifyAllObservers();
        }
    }

    public BitSet getValue() {
        return (BitSet) value.clone();
    }
}
