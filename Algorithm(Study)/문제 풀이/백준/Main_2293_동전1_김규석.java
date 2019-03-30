import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293_µ¿Àü1_±è±Ô¼® {

	static int N,K;
	static int[] dp;
	static int[] num;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		num = new int[N];
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			num[i] = number;
		}
		
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j-num[i] >= 0)
					dp[j] += dp[j - num[i]];
			}
			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(dp[K]);
	}
	
	

}
