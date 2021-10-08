package leetCodeJuly2020;

public class PlusOne6 {

	public static void main(String[] args) {
		int[] digits = {9,0};
		int[] arr = plusOne(digits);
		for(int n : arr) System.out.print(n + ", ");
	}

	private static int[] plusOne(int[] digits) {
		for (int i = digits.length-1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			}else {
				digits[i]++;
				break;
			}
		}

		if (digits[0] == 0) {
			int[] newDigits = new int[digits.length+1]; 
			newDigits[0] = 1;
			for (int i = 1; i < newDigits.length; i++) {
				newDigits[i] = digits[i-1];
			}
			digits = newDigits;
		}
		
		return digits;
	}

}
