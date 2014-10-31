
public class FractionCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static Fraction evaluate(Fraction fraction, String input) {
		// TODO recursive function to break string?
		// TODO convert if to switch statements
		Fraction valueinCalc = new Fraction(0, 1);
		char stored = 0;
		String fractionSubstr = "";
		String inputchar;
		int split = 0;
		
		if (input == "a" || input == "abs" || input == "A" )  {
			// shorten if statement
			valueinCalc = fraction.getAbsVal();
			//clear  valueinCalc?
		} else if (input == "n" || input == "neg" || input == "N")  {
			valueinCalc = fraction.negate();
			//clear  valueinCalc?
		} else if (input == "c" || input == "clear" || input == "C")  {
			valueinCalc = new Fraction(0, 1);
		} else {
			for (int i = 0; i < input.length()-1; i++) {
				
				inputchar = input.substring(i, i+1);
				//TODO new function to continue once fraction operated on
				if (input.charAt(i) == '+' || input.charAt(i) == '-' 
						|| input.charAt(i) == '*' 
						|| input.charAt(i) == '/') {
					//raise exception if already stored
					stored = input.charAt(i); 
				} else if (inputchar.equals(" "))  {
					split = i;
					break;
				}
			}
			
			for (int j = split+1; j < input.length(); j++) { 
				fractionSubstr += input.substring(j, j+1);
			}
			
			Fraction inputFrac = toFraction(fractionSubstr);
			
			if (stored == '+') {
			valueinCalc = fraction.add(inputFrac);
			} else if (stored == '-') {
				valueinCalc = fraction.subtract(inputFrac);
			} else if (stored == '*') {
				valueinCalc = fraction.multiply(inputFrac);
			} else if (stored == '/') {
				valueinCalc = fraction.divide(inputFrac);
			}
		}
		
		Fraction result = valueinCalc; //repeat for remaining string

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
