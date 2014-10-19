import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
	  
		@Test
		public void testMultiply() {
			assertEquals((new Fraction(3, 10)), (new Fraction(1, 2).multiply(new Fraction(3, 5))));
			assertEquals((new Fraction(1, 6)), (new Fraction(1, 4).multiply(new Fraction(2, 3))));
			assertEquals((new Fraction(6, 25)), (new Fraction(2, 5).multiply(new Fraction(6, 10))));
			assertEquals((new Fraction(-1, 4)), (new Fraction(3, -8).multiply(new Fraction(2, 3))));


		 }
		
		
		@Test
		public void testEquals() {
			assertEquals("Fractions not equal", new Fraction(1, 2), new Fraction(1, 2));
			assertEquals("Fractions not equal", new Fraction(1, 2), new Fraction(3, 6));
			assertEquals("Fractions not equal", new Fraction(-1, 2), new Fraction(1, -2));
			assertEquals("Fractions not equal", new Fraction(-1, -2), new Fraction(1, 2));
	
		}
		
	
		@Test
		public void testAdd() {
			assertEquals((new Fraction(3, 5)), (new Fraction(1, 5).add(new Fraction(2, 5))));
			assertEquals((new Fraction(1, 10)), (new Fraction(3, 10).add(new Fraction(-2, 10))));
			assertEquals((new Fraction(11, 15)), (new Fraction(1, 3).add(new Fraction(2, 5))));
			assertEquals((new Fraction(-1, 10)), (new Fraction(1, 2).add(new Fraction(-3, 5))));


		}
		
		/*
		@Test
		public void testSubtract() {
			//test subtract. Write method
			assertEquals((new Fraction(3, 5)), (new Fraction(4, 5).subtract(new Fraction(1, 5))));
			assertEquals((new Fraction(5, 10)), (new Fraction(1, 10).subtract(new Fraction(-4, 10))));

		}
		
		@Test
		public void testDivide() {
			//test divide. Write method
			assertEquals((new Fraction(4, 9)), (new Fraction(1, 2).divide(new Fraction(2, 9))));
			assertEquals((new Fraction(4, 10)), (new Fraction(8, 10).divide(new Fraction(4, 2))));

		}
		
		@Test
		public void testAbsValue() {
			//test absValue. Write method
			assertEquals((new Fraction(2, 6)), absValue(new Fraction(-2, 6)));
			assertEquals((new Fraction(7, 10)), absValue(new Fraction(7, -10)));
		}
	
		@Test
		public void testNegate() {
			//test negate. Write method
			assertEquals((new Fraction(2, 6)), negate(new Fraction(-2, 6)));
			assertEquals((new Fraction(-7, 10)), negate(new Fraction(7, 10)));
		}


		*/
/*	
 * 	@Test

		public void test2() {
			// test divide by zero - should print an error and exit
	        
	        assertEquals ("The numerator is divided by zero", new Fraction(1, 0));
	        
		}
 */
		
}