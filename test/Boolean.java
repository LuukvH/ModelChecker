import models.AldebaranStructure;
import models.MixedKripkeStructure;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by laj on 23-2-2016.
 */
public class Boolean {

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
        String formula = "true";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression2() throws Exception {
        String formula = "false";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression3() throws Exception {
        String formula = "(false && true)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression4() throws Exception {
        String formula = "(true && false)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression5() throws Exception {
        String formula = "(true && true)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression6() throws Exception {
        String formula = "(false || true)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression7() throws Exception {
        String formula = "(false || false)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = new HashSet<>();
        assertEquals(result, expected_result);
    }

    @Test
    public void Expression8() throws Exception {
        String formula = "(true || false)";
        Set<Integer> result = FormulaValidator.Validate(mixedKripkeStructure, formula);
        Set<Integer> expected_result = mixedKripkeStructure.States;
        assertEquals(result, expected_result);
    }

}