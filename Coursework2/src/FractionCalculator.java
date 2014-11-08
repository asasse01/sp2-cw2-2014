import java.util.Arrays;
import java.util.Scanner;


public class FractionCalculator {
	public static final String FRACTIONFORMAT = "(-?\\d+\\/-?\\d+)|(-?\\d+)";
	public static final String[] ABSOLUTE = {"a", "A", "abs"};
	public static final String[] NEGATE = {"n", "N", "neg"};
	public static final String[] CLEAR = {"c", "C", "clear"};
	public static final String[] QUIT = {"q", "Q", "quit"};
	public static final String[] SIGN = {"+", "-", "*", "/"};
	public static final Fraction ZERO = new Fraction(0, 1);
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Fraction valueInCalc = ZERO;
	    
		System.out.println("Welcome to Abby's fraction calculator.");
		System.out.println("Please enter lines to be calculated, and 'q' or 'quit' to end:");

		while(true) {
			String input = in.nextLine();
			valueInCalc = evaluate(valueInCalc, input);
			System.out.println(valueInCalc);
		}		
	}

	
	public static Fraction evaluate(Fraction frac, String input) {
		Fraction valueInCalc = frac;
		String stored = "";
		String[] splitString = input.split(" ");
	 
		for (String inputSubstr : splitString) { 
			
			// evaluate other variables
			if (Arrays.asList(ABSOLUTE).contains(inputSubstr)) {
				valueInCalc = valueInCalc.getAbsVal();
			} else if (Arrays.asList(NEGATE).contains(inputSubstr))  {
				valueInCalc = valueInCalc.negate();
			} else if (Arrays.asList(CLEAR).contains(inputSubstr))  {
				valueInCalc = new Fraction(0, 1);
			/*} else if (Arrays.asList(QUIT).contains(inputSubstr))  {
				System.out.println("Goodbye");
				in.close();
				break;*/
	        } else if (Arrays.asList(SIGN).contains(inputSubstr)) {
				if(stored == "") {
					stored = inputSubstr; 
				} else {
					System.out.println("Operator already stored, please enter a fraction");
					in.close();
					break;
				}
			} else if(inputSubstr.matches(FRACTIONFORMAT)) {
				Fraction inputFrac = toFraction(inputSubstr);
				
				//evaluate operation
				if (stored.equals("+")) {
				valueInCalc = valueInCalc.add(inputFrac);
				} else if (stored.equals("-")) {
					valueInCalc = valueInCalc.subtract(inputFrac);
				} else if (stored.equals("*")) {
					valueInCalc = valueInCalc.multiply(inputFrac);
				} else if (stored.equals("/")) {
					valueInCalc = valueInCalc.divide(inputFrac);
				} else valueInCalc = inputFrac;
				
				stored = "";
				
			} else {
				input = "";
				stored = "";
				valueInCalc = ZERO;
	        	throw new IllegalArgumentException("Invalid input");
	        }
						
		} 
	
			Fraction result = valueInCalc; 
			
		return result;
	}
	
	
	public static Fraction toFraction(String str) {
		//method converts string to fraction
		int num;
		int denom;
		String[] splitString = str.split("/");
		
		num = Integer.parseInt(splitString[0]);
		if (splitString.length < 2) {
			denom = 1;
		} else denom = Integer.parseInt(splitString[1]);
		
		Fraction result = new Fraction(num, denom);

		return result;

	}

}
