import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		
		
		@Test
		public void testSubtract() {
			assertEquals((new Fraction(3, 5)), (new Fraction(4, 5).subtract(new Fraction(1, 5))));
			assertEquals((new Fraction(5, 10)), (new Fraction(1, 10).subtract(new Fraction(-4, 10))));
			assertEquals((new Fraction(-3, 4)), (new Fraction(1, 6).subtract(new Fraction(11, 12))));
			assertEquals((new Fraction(1, 5)), (new Fraction(-2, 5).subtract(new Fraction(-3, 5))));
		}
		
		
		@Test
		public void testDivide() {
			assertEquals((new Fraction(9, 4)), (new Fraction(1, 2).divide(new Fraction(2, 9))));
			assertEquals((new Fraction(2, 5)), (new Fraction(8, 10).divide(new Fraction(4, 2))));
		}
		
		
		@Test
		public void testAbsValue() {
			assertEquals((new Fraction(2, 6)), (new Fraction(-2, 6)).getAbsVal());
			assertEquals((new Fraction(7, 10)), (new Fraction(-7, -10)).getAbsVal());
		}
	
		
		@Test
		public void testNegate() {
			assertEquals((new Fraction(2, 6)), (new Fraction(-2, 6)).negate());
			assertEquals((new Fraction(-7, 10)), (new Fraction(7, 10)).negate());
		}
		
		@Test
		public void testToString() {
			assertEquals("1/2", (new Fraction(1, 2)).toString());
			assertEquals("3/-5", (new Fraction(-3, 5)).toString());
		}

		/*test and rule for testZeroDenom from 
		 * http://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
		 */
	
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void testZeroDenom() {
		    exception.expect(IllegalArgumentException.class);
		    new Fraction(1, 0);
			    
		}
 
		
}