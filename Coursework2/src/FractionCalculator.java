
public class FractionCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static Fraction evaluate(Fraction fraction, String input) {
		// recursive function to break string?
		Fraction valueinCalc = new Fraction(0, 1);
		String stored;
		//valueinCalc = fraction;
		if (input == "a" || input == "abs" || input == "A")  {
			valueinCalc = fraction.getAbsVal();
			//clear  valueinCalc?
		} else if (input == "n" || input == "neg" || input == "N")  {
			valueinCalc = fraction.negate();
			//clear  valueinCalc?
		} else if (input == "c" || input == "clear" || input == "C")  {
			valueinCalc = new Fraction(0, 1);
			//clear  valueinCalc?
		} 
		
		Fraction result = valueinCalc;

		return result;
	}
	
	
	public static Fraction toFraction(String str) {
		//method converts string to fraction
		int numDigits = 0;
		int numEnd = str.length();
		
		for (int i = 0; (str.charAt(i) != '/'); i++) {
			numDigits++;
		}
		numEnd = numDigits;
		
		int num = Integer.parseInt(str.substring(0, numEnd));
		int denom = Integer.parseInt(str.substring(numEnd+1));

		Fraction result = new Fraction(num, denom);
				
		return result;
	}

}
