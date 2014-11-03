import java.util.Arrays;

public class FractionCalculator {

	public static void main(String[] args) {

	}

	
	public static Fraction evaluate(Fraction fraction, String input) {
		Fraction valueInCalc = new Fraction(0, 1); //class var?
		valueInCalc = fraction;
		String stored = "";
		String[] splitString = input.split(" ");
		String fractionFormat = "(-?\\d+\\/-?\\d+)|(-?\\d+)";
		String[] absolute = {"a", "A", "abs"};
		String[] negate = {"n", "N", "neg"};
		String[] clear = {"c", "C", "clear"};
		String[] operator = {"+", "-", "*", "/"};
	 
		for (String str : splitString) { 
			
			// evaluate other variables
			if (Arrays.asList(absolute).contains(str)) {
				valueInCalc = valueInCalc.getAbsVal();
			} else if (Arrays.asList(negate).contains(str))  {
				valueInCalc = valueInCalc.negate();
			} else if (Arrays.asList(clear).contains(str))  {
				valueInCalc = new Fraction(0, 1);
			} else if (Arrays.asList(operator).contains(str)) {
				if(stored == "") {
					stored = str; 
				} else {
					System.out.println("Operator already stored, please enter a fraction");
					break;
				}
			} else if(str.matches(fractionFormat)) {
				Fraction inputFrac = toFraction(str);
				
				//evaluate operation
				if (stored.equals("+")) {
				valueInCalc = valueInCalc.add(inputFrac);
				} else if (stored.equals("-")) {
					valueInCalc = valueInCalc.subtract(inputFrac);
				} else if (stored.equals("*")) {
					valueInCalc = valueInCalc.multiply(inputFrac);
				} else if (stored.equals("/")) {
					valueInCalc = valueInCalc.divide(inputFrac);
				}
				
				stored = "";
				
			}
						
		} 
	
			Fraction result = valueInCalc; 
			valueInCalc = new Fraction(0, 1);
			
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
