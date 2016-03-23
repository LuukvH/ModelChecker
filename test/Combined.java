import aldebaran.AldebaranReader;
import enums.Algorithm;
import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

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
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        expected_result.add(0);
        expected_result.add(1);
        expected_result.add(2);
        expected_result.add(4);
        expected_result.add(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "nu X. <tau>X";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        expected_result.add(0);
        expected_result.add(1);
        expected_result.add(2);
        expected_result.add(4);
        expected_result.add(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. ( <tau>Y || <a>X)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        expected_result.add(0);
        expected_result.add(1);
        expected_result.add(2);
        expected_result.add(3);
        expected_result.add(4);
        expected_result.add(5);
        expected_result.add(6);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. ( (<tau>Y || <a>Y) || <b>X)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result = new HashSet<Integer>(mixedKripkeStructure.StateSize());
        expected_result.add(0);
        expected_result.add(1);
        expected_result.add(2);
        expected_result.add(3);
        expected_result.add(4);
        expected_result.add(5);
        expected_result.add(6);
        expected_result.add(7);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "mu X. ([tau]X && (<tau>true || <a>true))";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula, algo).answer;
        Set<Integer> expected_result =  new HashSet<Integer>(mixedKripkeStructure.StateSize());
        expected_result.add(3);
        expected_result.add(5);
        assertEquals(expected_result, result);
    }

}