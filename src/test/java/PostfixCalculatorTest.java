import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PostfixCalculatorTest {
    private IStack<Integer> stack;
    private ICalculadora calculator;

    @Before
    public void setUp() {
        stack = new VectorStack<>();
        calculator = new PostfixCalculator(stack);
    }

    @Test(expected = CalculatorException.class)
    public void testEmptyExpression() throws Exception {
        calculator.evaluate("");
    }

    @Test(expected = CalculatorException.class)
    public void testNullExpression() throws Exception {
        calculator.evaluate(null);
    }

    @Test
    public void testSimpleAddition() throws Exception {
        int result = calculator.evaluate("3 4 +");
        assertEquals(7, result);
    }

    @Test
    public void testSimpleSubtraction() throws Exception {
        int result = calculator.evaluate("5 3 -");
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() throws Exception {
        int result = calculator.evaluate("4 5 *");
        assertEquals(20, result);
    }

    @Test
    public void testDivision() throws Exception {
        int result = calculator.evaluate("20 4 /");
        assertEquals(5, result);
    }

    @Test
    public void testModulo() throws Exception {
        int result = calculator.evaluate("7 3 %");
        assertEquals(1, result);
    }

    @Test
    public void testComplexExpression() throws Exception {
        int result = calculator.evaluate("3 4 + 2 *");
        assertEquals(14, result);
    }

    @Test(expected = Exception.class)
    public void testInsufficientOperands() throws Exception {
        calculator.evaluate("3 +");
    }

    @Test(expected = Exception.class)
    public void testTooManyOperands() throws Exception {
        calculator.evaluate("3 4 5 +");
    }

    @Test(expected = Exception.class)
    public void testDivisionByZero() throws Exception {
        calculator.evaluate("10 0 /");
    }
}
