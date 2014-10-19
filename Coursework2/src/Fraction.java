/**
 * Created by keith for the second coursework assignment.
 */

public class Fraction {
    private int numerator;
    private int denominator;

    public static void main(String[] args) {
    
    }
    
    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        return "" + getNumerator() + '/' + getDenominator();
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

    public Fraction multiply(Fraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction frac) {
    	//method adds fraction, returns new result fraction
    	int lcd = myLcd(this.getDenominator(), frac.getDenominator());
        int num1 = this.getNumerator() * (lcd/this.getDenominator());
        int num2 = frac.getNumerator() * (lcd/frac.getDenominator());
        int numSum = num1 + num2;
        Fraction result = new Fraction(numSum, lcd);
        return result;
    }
    
    public Fraction subtract(Fraction frac) {
    	//method subtracts fraction, returns new result fraction
    	int lcd = myLcd(this.getDenominator(), frac.getDenominator());
        int num1 = this.getNumerator() * (lcd/this.getDenominator());
        int num2 = frac.getNumerator() * (lcd/frac.getDenominator());
        int numSum = num1 - num2;
        Fraction result = new Fraction(numSum, lcd);
        return result;
    }
    
    public Fraction divide(Fraction frac) {
    	//method subtracts fraction, returns new result fraction
    	Fraction reciprocal = reciprocate(frac);
        Fraction result = this.multiply(reciprocal);
        return result;
    }
    
    public Fraction getAbsVal() {
    	//method returns absolute value of fraction
    	int num = this.getNumerator();
    	int denom = this.getDenominator();
    	if (num < 0 ^ denom < 0) {
    		//where ^ is XOR
    		num = -num;
    	}
    	
    	Fraction absVal = new Fraction(num, denom);
    	return absVal;
    } 
    
    private Fraction reciprocate(Fraction frac) {
    	//method returns reciprocal of fraction
    	int recNum = frac.getDenominator();
    	int recDenom = frac.getNumerator();
    	Fraction reciprocal = new Fraction(recNum, recDenom);
    	return reciprocal;
    }    
    
    private int myLcd(int denom1, int denom2) {
    	//lcd method calculates and returns lowest common denominator
    	int lcd;
    	if (denom1 == denom2) {
    		lcd = denom1;
    	} else lcd = denom1 * denom2;
    	return lcd;
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}
