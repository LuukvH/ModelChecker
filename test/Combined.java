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
public class Combined {

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
        String formula = "nu X. (<tau>X && mu Y. (<tau>Y || [a]false))";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
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
        String formula = "nu X. <tau>X";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(0);
        expected_result.set(1);
        expected_result.set(2);
        expected_result.set(4);
        expected_result.set(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. ( <tau>Y || <a>X)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(0);
        expected_result.set(1);
        expected_result.set(2);
        expected_result.set(3);
        expected_result.set(4);
        expected_result.set(5);
        expected_result.set(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. ( (<tau>Y || <a>Y) || <b>X)";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result = new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(0);
        expected_result.set(1);
        expected_result.set(2);
        expected_result.set(3);
        expected_result.set(4);
        expected_result.set(5);
        expected_result.set(6);
        expected_result.set(7);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "mu X. ([tau]X && (<tau>true || <a>true))";
        BitSet result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        BitSet expected_result =  new BitSet(mixedKripkeStructure.StateSize());
        expected_result.set(3);
        expected_result.set(5);
        assertEquals(expected_result, result);
    }

}