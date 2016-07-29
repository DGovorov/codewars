package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dim on 28.07.2016.
 */
public class MathEvaluatorTest {

    MathEvaluator evaluator = new MathEvaluator();

    @Test
    public void test1(){
        String expression = "(2 / (2 + 3.33) * 4) - -6";
        double result = (2 / (2 + 3.33) * 4) - -6;
        assertEquals(result, evaluator.calculate(expression), 0.01);
    }

    @Test
    public void testMultipleBrackets() {
        String expression = "(2 / 2) + (3.33 * 4) - -6";
        double result = (2 / 2) + (3.33 * 4) - -6;
        assertEquals(result, evaluator.calculate(expression), 0.01);
    }

    @Test
    public void testAddition() {
        assertEquals(new MathEvaluator().calculate("1+1"), 2d, 0.01);
    }

    @Test
    public void testSubtraction() {
        assertEquals(new MathEvaluator().calculate("1 - 1"), 0d, 0.01);
    }

    @Test
    public void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test
    public void testDivision() {
        assertEquals(new MathEvaluator().calculate("1 /1"), 1d, 0.01);
    }

    @Test
    public void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test
    public void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test
    public void testExpression() {
        assertEquals(new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test
    public void testSimple() {
        assertEquals(new MathEvaluator().calculate("12* 123"), 1476d, 0.01);
    }

    @Test
    public void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

}
