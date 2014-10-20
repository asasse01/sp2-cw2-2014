
public class FractionCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	private Fraction evaluate(Fraction fraction, String input) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	public static Fraction toFraction(String str) {
		
		int numDigits = 0;
		int numEnd = str.length();
		
		for (int i = 0; str.charAt(i) != '/'; i++) {
			//if (str.charAt(i) != '/') {
				numDigits++;
			//} 
			/*else  {
				numEnd = numDigits + 1;
				break;
			}*/ 
		}
		numEnd = numDigits;
		
		int num = Integer.parseInt(str.substring(0, numEnd));
		int denom = Integer.parseInt(str.substring(numEnd+1));

		Fraction result = new Fraction (num, denom);
				
		return result;
	}

}
