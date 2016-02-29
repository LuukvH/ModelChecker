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
public class Modal {

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
        String formula = "[tau]true";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(0);
        expected_result.set(1);
        expected_result.set(2);
        expected_result.set(4);
        expected_result.set(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "<tau>[tau]true";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(0);
        expected_result.set(3);
        expected_result.set(5);
        expected_result.set(6);
        expected_result.set(7);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "[tau]false";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "<tau>[tau]false";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(3);
        expected_result.set(5);
        expected_result.set(7);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "<tau>false";
        BitSet result = mixedKripkeStructure.Evaluate(formula);
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(3);
        expected_result.set(5);
        expected_result.set(7);
        assertEquals(expected_result, result);
    }

}