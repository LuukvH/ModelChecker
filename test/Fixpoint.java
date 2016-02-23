import models.AldebaranStructure;
import models.MixedKripkeStructure;
import org.junit.Before;
import org.junit.Test;

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
        AldebaranStructure aldebaranStructure = reader.ReadFile("res/test.aut");

        if (aldebaranStructure == null)
            return;

        mixedKripkeStructure = new MixedKripkeStructure(aldebaranStructure);
    }

    @Test
    public void Expression1() throws Exception {
        String formula = "nu X. X";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<Integer>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "mu Y. Y";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "nu X. mu Y. (X || Y)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "nu X. mu Y. (X && Y)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        expected_result.add(3);
        expected_result.add(5);
        expected_result.add(7);
        assertEquals(expected_result, result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "nu X. (X &&  mu Y. Y)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        expected_result.add(3);
        expected_result.add(5);
        expected_result.add(7);
        assertEquals(expected_result, result);
    }
}