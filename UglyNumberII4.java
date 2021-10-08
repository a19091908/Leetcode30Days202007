package leetCodeJuly2020;



public class UglyNumberII4 {

	public static void main(String[] args) {
		int n = 1690;
		int ans = new UglyNumberII4().nthUglyNumber(n);
		System.out.println(ans);
	}

	private int nthUglyNumber(int n) {
		if(n<=1) return n;
		
		int[] uglyArr = new int[n];
		uglyArr[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0; 
		
		for (int i = 1; i < uglyArr.length; i++) {
			uglyArr[i] = Math.min(uglyArr[i2]*2, Math.min(uglyArr[i3]*3, uglyArr[i5]*5));
			if(uglyArr[i] == uglyArr[i2]*2) i2++;
			if(uglyArr[i] == uglyArr[i3]*3) i3++;
			if(uglyArr[i] == uglyArr[i5]*5) i5++;
		}	
		
		return uglyArr[n-1];
	}

}
