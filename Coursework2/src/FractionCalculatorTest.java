import static org.junit.Assert.*;

import org.junit.Test;


public class FractionCalculatorTest {

	/*
	@Test
	public void testEvaluate() {
		assertEquals((new Fraction(3, 10)), evaluate((new Fraction(3, 5)), "* 1/2"));
		assertEquals((new Fraction(1, 10)), evaluate((new Fraction(3, 10)), "+ -2/10"));
		assertEquals((new Fraction(-3, 4)), evaluate((new Fraction(1, 6)), "- 11/12"));
		assertEquals((new Fraction(2, 5)), evaluate((new Fraction(8, 10)), "/ 4/ 2"));
		
		assertEquals((new Fraction(2, 6)), evaluate((new Fraction(-2, 6)), "a"));
		assertEquals((new Fraction(7, -10)), evaluate((new Fraction(7, 10)), "neg"));
		assertEquals((0), evaluate((new Fraction(7, 10)), "C"));

	 }*/

	@Test
	public void testToFraction() {
		assertEquals((new Fraction(3, 10)), toFraction("3/10"));
		assertEquals((new Fraction(1, 10)), toFraction("2/20"));
		assertEquals((new Fraction(-3, 4)), toFraction("-3/4"));
		assertEquals((new Fraction(2, 5)), toFraction("-2/-5"));
	}

}
