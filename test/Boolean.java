import aldebaran.AldebaranReader;
import enums.Algorithm;
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
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "false";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "(false && true)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "(true && false)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "(true && true)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression6() throws Exception {
        String formula = "(false || true)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression7() throws Exception {
        String formula = "(false || false)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression8() throws Exception {
        String formula = "(true || false)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

}