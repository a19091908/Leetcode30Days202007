package leetCodeJuly2020;

public class ArrangingCoins1 {

	public static void main(String[] args) {
		int n = 2147483647;
		int ans = new ArrangingCoins1().arrangeCoins(n);
		System.out.println(ans);
	}

	private int arrangeCoins(int n) {
		long i = 0;
		long sum = 0;
		
		while (sum < n) {
			i++;
			sum+=i; 
		}

		return (int) ((sum-n)==0?i:i-1);
	}

}
