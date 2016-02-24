import aldebran.AldebaranReader;
import models.Aldebaran;
import models.MixedKripkeStructure;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by laj on 23-2-2016.
 */
public class Combined {

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
        String formula = "nu X. (<tau>X && mu Y. (<tau>Y || [a]false))";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "nu X. <tau>X";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. ( <tau>Y || <a>X)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. ( (<tau>Y || <a>Y) || <b>X)";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "mu X. ([tau]X && (<tau>true || <a>true))";
        Set<Integer> result = mixedKripkeStructure.Evaluate(formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(expected_result, result);
    }

}