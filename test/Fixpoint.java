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
public class Fixpoint {

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
        String formula = "nu X. X";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "mu Y. Y";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. (X || Y)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = mixedKripkeStructure.States();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. (X && Y)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "nu X. (X &&  mu Y. Y)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        assertEquals(expected_result, result);
    }
}