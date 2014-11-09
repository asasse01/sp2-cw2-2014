/**
 * @author Abby Sassel
 * @since 18/10/2014
 *
 * Coursework2 
 * - Extends the FractionTest and Fraction classes associated with this coursework assignment.
 * - Performs as a simple text based calculator to compute with fractions.
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator {
	public static final String FRACTIONFORMAT = "(-?\\d+\\/-?\\d+)|(-?\\d+)";
	public static final int MAXFRACELEMENTS = 2;
	public static final String[] ABSOLUTE = {"a", "A", "abs"};
	public static final String[] NEGATE = {"n", "N", "neg"};
	public static final String[] CLEAR = {"c", "C", "clear"};
	public static final String[] QUIT = {"q", "Q", "quit"};
	public static final String[][] TEXTINPUT = {ABSOLUTE, NEGATE, CLEAR, QUIT};
	public static final String[] SYMBOL = {"+", "-", "*", "/"};
	public static final String SPACEDELIM = " ";
	public static final String SLASHDELIM = "/";
	public static final String EMPTY = "";
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

    /**
     * evaluate method computes result of string of operation on Fraction
     * @param frac fraction to perform operations on (in order of writing)
     * @param input some mixture of numbers and operators, separated by spaces, to be performed on frac in order of writing
     * @return valueInCalc the final result of calculating the input
     */
	public static Fraction evaluate(Fraction frac, String input) {
		Fraction valueInCalc = frac;
		String stored = EMPTY;
		String[] splitString = input.split(SPACEDELIM);
	 
		for (String inputSubstr : splitString) { 
			
			if(inputSubstr.matches(FRACTIONFORMAT)) {
				valueInCalc = evaluateFraction(valueInCalc, stored, inputSubstr);
				stored = EMPTY; //once value operated on, clear stored symbol
				
			} else if (Arrays.asList(SYMBOL).contains(inputSubstr)) {
				stored = storeSymbol(stored, inputSubstr);
				
			} else if (searchNestedArray(TEXTINPUT, inputSubstr)) {
				valueInCalc = evaluateText(valueInCalc, inputSubstr);
				
			} else {
				//exception: clear all values and print error
				input = EMPTY;
				stored = EMPTY;
				valueInCalc = ZERO;
				System.out.println("Error");
				break;
	        }
						
		} 
				
		return valueInCalc;
	}
	
    /**
     * toFraction method parses String to Fraction
     * @param str String to be parsed
     * @return resulting Fraction
     */
	public static Fraction toFraction(String str) {
		//method converts string to fraction
		int num;
		int denom;
		String[] splitString = str.split(SLASHDELIM);
		
		num = Integer.parseInt(splitString[0]);
		if (splitString.length < MAXFRACELEMENTS) {
			denom = 1;
		} else denom = Integer.parseInt(splitString[1]);

		Fraction frac = new Fraction(num, denom);

		return frac;
	}

    /**
     * searchNestedArray searches a 2d array for any given String
     * @param nestedArray array to search
     * @param inputSubstr string to find
     * @return boolean to indicate presence in array
     */
	public static boolean searchNestedArray(String[][] nestedArray, String inputSubstr)  {
		for (String[] other : nestedArray) {
			if (Arrays.asList(other).contains(inputSubstr)) {
			return true; 
			}
		} return false;
	}
	
    /**
     * evaluateText evaluates text input as defined in coursework spec
     * @param valueInCalc fraction to operate on
     * @param inputSubstr string contain text operator
     * @return resulting Fraction
     */
	public static Fraction evaluateText(Fraction valueInCalc, String inputSubstr) {
		if (Arrays.asList(ABSOLUTE).contains(inputSubstr)) {
			valueInCalc = valueInCalc.getAbsVal();
		} else if (Arrays.asList(NEGATE).contains(inputSubstr))  {
			valueInCalc = valueInCalc.negate();
		} else if (Arrays.asList(CLEAR).contains(inputSubstr))  {
			valueInCalc = ZERO;
		} else if (Arrays.asList(QUIT).contains(inputSubstr))  {
			valueInCalc = null;
			quit();
	    }
		return valueInCalc;
	}
	
    /**
     * storeSymbol checks symbol is empty and stores input symbol
     * @param stored variable to store symbol in if empty
     * @param inputSymbol symbol to store
     * @return stored symbol
     */
	public static String storeSymbol(String stored, String inputSymbol) {
		if(stored == EMPTY) {
			return inputSymbol; 
			} else {
				System.out.println("Operator already stored, please enter a fraction");
				return stored;
			}
	}
	
    /**
     * evaluateFraction calculates operation with given input
     * @param valueInCalc fraction to operate on
     * @param inputSymbol operation
     * @param inputSubstr remaining operand
     * @return resulting Fraction
     */
	public static Fraction evaluateFraction(Fraction valueInCalc, String inputSymbol, String inputSubstr) {
		Fraction inputFrac = toFraction(inputSubstr);
		
		//evaluate operation
		if (inputSymbol.equals("+")) {
		valueInCalc = valueInCalc.add(inputFrac);
		} else if (inputSymbol.equals("-")) {
			valueInCalc = valueInCalc.subtract(inputFrac);
		} else if (inputSymbol.equals("*")) {
			valueInCalc = valueInCalc.multiply(inputFrac);
		} else if (inputSymbol.equals("/")) {
			valueInCalc = valueInCalc.divide(inputFrac);
		} else valueInCalc = inputFrac;
		
		return valueInCalc;
	}
	
	public static void quit() {
		System.out.println("Goodbye");
		System.exit(0);
	}
}
