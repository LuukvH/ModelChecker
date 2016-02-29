import aldebran.AldebaranReader;
import models.Aldebaran;
import models.MixedKripkeStructure;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by laj on 23-2-2016.
 */
public class Fixpoint {

    MixedKripkeStructure mixedKripkeStructure;

    @Before
    public void setUp() throws Exception {
        AldebaranReader reader = new AldebaranReader();
        Aldebaran aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
    }

    @Test
    public void Expression1() throws Exception {
        String formula = "nu X. X";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "mu Y. Y";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. (X || Y)";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. (X && Y)";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "nu X. (X &&  mu Y. Y)";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }
}