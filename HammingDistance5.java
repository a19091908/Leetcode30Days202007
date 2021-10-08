package leetCodeJuly2020;

public class HammingDistance5 {

	public static void main(String[] args) {
		int x = 1, y = 4;
		int ans = new HammingDistance5().hammingDistance(x,y);
		System.out.println(ans);
	}

	private int hammingDistance(int x, int y) {
		int xOr = x ^ y;
		int sum = xOr & 1;
		for (int i = 1; i < 32; i++) {
			xOr = xOr >> 1;
			sum += xOr & 1;
			
		}
		
		return sum;
	}

}
