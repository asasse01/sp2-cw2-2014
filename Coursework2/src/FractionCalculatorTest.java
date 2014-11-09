import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class FractionCalculatorTest {

	@Test
	public void testEvaluate() {
		//evaluates single fraction operation
		assertEquals((new Fraction(3, 10)), FractionCalculator.evaluate((new Fraction(3, 5)), "* 1/2"));
		assertEquals((new Fraction(1, 10)), FractionCalculator.evaluate((new Fraction(3, 10)), "+ -2/10"));
		assertEquals((new Fraction(-3, 4)), FractionCalculator.evaluate((new Fraction(1, 6)), "- 11/12"));
		assertEquals((new Fraction(2, 5)), FractionCalculator.evaluate((new Fraction(8, 10)), "/ 4/2"));
		assertEquals((new Fraction(8, 5)), FractionCalculator.evaluate((new Fraction(8, 10)), "* 2"));
		assertEquals((new Fraction(3, 1)), FractionCalculator.evaluate((new Fraction(8, 10)), "3/2 * 2"));
		
		//evaluates other single operation
		assertEquals((new Fraction(2, 6)), FractionCalculator.evaluate((new Fraction(-2, 6)), "a"));
		assertEquals((new Fraction(7, -10)), FractionCalculator.evaluate((new Fraction(7, 10)), "neg"));
		assertEquals((new Fraction(0, 1)), FractionCalculator.evaluate((new Fraction(7, 10)), "C"));
		
		//evaluates multiple operations
		assertEquals((new Fraction(7, 20)), FractionCalculator.evaluate((new Fraction(3, 5)), "* 1/2 / 6/7"));
		assertEquals((new Fraction(-23, 20)), FractionCalculator.evaluate((new Fraction(3, 10)), "+ -2/10 + -5/4"));
		assertEquals((new Fraction(-5, 4)), FractionCalculator.evaluate((new Fraction(1, 6)), "- 11/12 - 1/2"));
		assertEquals((new Fraction(-2, 5)), FractionCalculator.evaluate((new Fraction(8, 10)), "/ 4/2 * -1/1"));
		assertEquals((new Fraction(-1, 2)), FractionCalculator.evaluate((new Fraction(3, 10)), "/ 3/5 n")); 
		assertEquals((new Fraction(5, 6)), FractionCalculator.evaluate((new Fraction(-4, 8)), "- 1/3 A"));
		assertEquals((new Fraction(0, 1)), FractionCalculator.evaluate((new Fraction(-2, 3)), "- 4/5 clear"));

	}
    
	@Test
	public void testToFraction() {
		assertEquals((new Fraction(3, 10)), FractionCalculator.toFraction("3/10"));
		assertEquals((new Fraction(1, 10)), FractionCalculator.toFraction("2/20"));
		assertEquals((new Fraction(-3, 4)), FractionCalculator.toFraction("-3/4"));
		assertEquals((new Fraction(2, 5)), FractionCalculator.toFraction("-2/-5"));
		assertEquals((new Fraction(10, 1)), FractionCalculator.toFraction("10"));
	}
	
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testSystemExit() {
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

}
