import java.util.Arrays;
import java.util.Scanner;


public class FractionCalculator {
	static Fraction valueInCalc;
	static String stored;
	
	public static void main(String[] args) {
		valueInCalc = new Fraction(0, 1);
		stored = "";
	    
		System.out.println("Welcome to Abby's fraction calculator.");
		System.out.println("Please enter lines to be calculated, and 'q' or 'quit' to end:");
		Scanner in = new Scanner(System.in);

		while(true) {
			String input = in.nextLine();
			System.out.println(evaluate(valueInCalc, input));
		}
		
		//in.close();

	}

	
	public static Fraction evaluate(Fraction fraction, String input) {
		valueInCalc = fraction;
		String[] splitString = input.split(" ");
		String fractionFormat = "(-?\\d+\\/-?\\d+)|(-?\\d+)";
		String[] absolute = {"a", "A", "abs"};
		String[] negate = {"n", "N", "neg"};
		String[] clear = {"c", "C", "clear"};
		String[] quit = {"q", "Q", "quit"};
		String[] sign = {"+", "-", "*", "/"};
	 
		for (String inputSubstr : splitString) { 
			
			// evaluate other variables
			if (Arrays.asList(absolute).contains(inputSubstr)) {
				valueInCalc = valueInCalc.getAbsVal();
			} else if (Arrays.asList(negate).contains(inputSubstr))  {
				valueInCalc = valueInCalc.negate();
			} else if (Arrays.asList(clear).contains(inputSubstr))  {
				valueInCalc = new Fraction(0, 1);
			/*} else if (Arrays.asList(quit).contains(inputSubstr))  {
				System.out.println("Goodbye");
				break;*/
	        } else if (Arrays.asList(sign).contains(inputSubstr)) {
				if(stored == "") {
					stored = inputSubstr; 
				} else {
					System.out.println("Operator already stored, please enter a fraction");
					break;
				}
			} else if(inputSubstr.matches(fractionFormat)) {
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
				//
				input = "";
				stored = "";
				valueInCalc = new Fraction(0, 1);
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
