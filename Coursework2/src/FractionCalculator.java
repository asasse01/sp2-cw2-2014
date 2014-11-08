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
		String[] operator = {"+", "-", "*", "/"};
	 
		for (String str : splitString) { 
			
			// evaluate other variables
			if (Arrays.asList(absolute).contains(str)) {
				valueInCalc = valueInCalc.getAbsVal();
			} else if (Arrays.asList(negate).contains(str))  {
				valueInCalc = valueInCalc.negate();
			} else if (Arrays.asList(clear).contains(str))  {
				valueInCalc = new Fraction(0, 1);
			} else if (Arrays.asList(quit).contains(str))  {
				System.out.println("Goodbye");
				break;
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
				} else valueInCalc = inputFrac;
				
				stored = "";
				
			} else {
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
		int numEnd = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '/') {
				numEnd = i+1;
			} else break;
		}
		num = Integer.parseInt(str.substring(0, numEnd));
		if (numEnd == (str.length())) {
			denom = 1;
		} else denom = Integer.parseInt(str.substring(numEnd+1));
		Fraction result = new Fraction(num, denom);
		return result;

	}

}
