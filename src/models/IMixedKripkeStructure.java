package models;

import enums.Algorithm;

import java.sql.SQLException;
import java.util.BitSet;

/**
 * Created by laj on 22-3-2016.
 */
public interface IMixedKripkeStructure {
    int StateSize();

    BitSet States();

    BitSet getTransitions(String label, BitSet bs);

    Result Evaluate (String formula, Algorithm algo);
}
