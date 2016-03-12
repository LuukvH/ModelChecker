import aldebaran.AldebaranReader;
import enums.Algorithm;
import models.Aldebaran;
import models.MixedKripkeStructure;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by laj on 23-2-2016.
 */
public class Boolean {

    MixedKripkeStructure mixedKripkeStructure;
    Algorithm algo;

    @Before
    public void setUp() throws Exception {
        AldebaranReader reader = new AldebaranReader();
        Aldebaran aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
        algo = Algorithm.Naive;
    }

    @Test
    public void Expression1() throws Exception {
        String formula = "true";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "false";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "(false && true)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "(true && false)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "(true && true)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression6() throws Exception {
        String formula = "(false || true)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression7() throws Exception {
        String formula = "(false || false)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression8() throws Exception {
        String formula = "(true || false)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

}