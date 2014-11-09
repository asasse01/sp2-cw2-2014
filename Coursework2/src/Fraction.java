/**
 * @author Abby Sassel
 * @since 18/10/2014
 *
 * Coursework2 
 * - Extends the FractionTest and Fraction classes associated with this coursework assignment.
 * - Performs as a simple text based calculator to compute with fractions.
 *
 * NB: Fraction.java initial 18 Oct commit created by keith for the second coursework assignment.
 */

public class Fraction {
    private int numerator;
    private int denominator;

    public static void main(String[] args) {
    
    }
    
    public Fraction(int num, int denom) {
        if (denom == 0) {
        	throw new IllegalArgumentException("Invalid fraction with denominator 0"); // this should use exceptions
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    /**
     * toString method parses Fraction to String
     * @return resulting String
     */
    @Override
    public String toString() {
    	String str = "" + getNumerator();
    	if(getDenominator() != 1)  {
    		str += "/" + getDenominator();
    	}
        return str;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    /**
     * method multiplies fraction
     * @return result fraction
     */
    public Fraction multiply(Fraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }
    
    /**
     * method adds fraction
     * @return result fraction
     */
    public Fraction add(Fraction frac) {
    	int lcd = myLcd(this.getDenominator(), frac.getDenominator());
        int num1 = this.getNumerator() * (lcd/this.getDenominator());
        int num2 = frac.getNumerator() * (lcd/frac.getDenominator());
        int numSum = num1 + num2;
        Fraction result = new Fraction(numSum, lcd);
        return result;
    }
    
    /**
     * method subtracts fraction
     * @return result fraction
     */
    public Fraction subtract(Fraction frac) {
    	int lcd = myLcd(this.getDenominator(), frac.getDenominator());
        int num1 = this.getNumerator() * (lcd/this.getDenominator());
        int num2 = frac.getNumerator() * (lcd/frac.getDenominator());
        int numSum = num1 - num2;
        Fraction result = new Fraction(numSum, lcd);
        return result;
    }
    
    /**
     * method divides fraction
     * @return result fraction
     */
    public Fraction divide(Fraction frac) {
    	Fraction reciprocal = reciprocate(frac);
        Fraction result = this.multiply(reciprocal);
        return result;
    }
    
    /**
     * method returns absolute value of fraction
     * @return result fraction
     */
    public Fraction getAbsVal() {
    	int num = this.getNumerator();
    	int denom = this.getDenominator();
    	if (num < 0 ^ denom < 0) {
    		//where ^ is XOR
    		denom = -denom;
    	}
    	
    	Fraction absVal = new Fraction(num, denom);
    	return absVal;
    } 
    
    /**
     * method returns negated value of fraction
     * @return result fraction
     */
    public Fraction negate() {
    	int num = this.getNumerator();
    	int denom = this.getDenominator();

    	num = -num;
    	
    	Fraction negated = new Fraction(num, denom);
    	return negated;
    } 
    
    /**
     * method returns reciprocal of fraction
     * @return result fraction
     */  
    private Fraction reciprocate(Fraction frac) {
    	int recNum = frac.getDenominator();
    	int recDenom = frac.getNumerator();
    	Fraction reciprocal = new Fraction(recNum, recDenom);
    	return reciprocal;
    }    
    
    /**
     * method calculates and returns lowest common denominator
     * @return LCD
     */  
    private int myLcd(int denom1, int denom2) {
    	int lcd;
    	if (denom1 == denom2) {
    		lcd = denom1;
    	} else lcd = denom1 * denom2;
    	return lcd;
    }

    /**
     * method calculates and returns greatest common divisor
     * @return GCD
     */  
    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}
