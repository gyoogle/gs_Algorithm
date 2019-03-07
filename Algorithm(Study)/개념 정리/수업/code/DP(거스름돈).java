import java.util.Arrays;

public class Z43_DP3 {
	
	public static void main(String[] args) {
		System.out.println(f(12345678));
	}
	
	public static int f(int n) {
		int[] memo = new int[n+1];
		
		// 1원
		for (int i = 0; i < memo.length; i++) {
			memo[i] = i;
		}
		
		// 5원
		for (int i = 5; i < memo.length; i++) {
			if(memo[i] > memo[i-5] + 1)
				memo[i] = memo[i-5] + 1;
		}
		
		// 10원
		for (int i = 10; i < memo.length; i++) {
			if(memo[i] > memo[i-10] + 1)
				memo[i] = memo[i-10] + 1;
		}
		
		// 16원
		for (int i = 16; i < memo.length; i++) {
			if(memo[i] > memo[i-16] + 1)
				memo[i] = memo[i-16] + 1;
		}
		//System.out.println(Arrays.toString(memo));
		
		return memo[n];
	}
}
