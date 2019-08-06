import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11060 {
	
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = arr[0];
		
		for (int i = 1; i < 1 + start; i++) {
			if(i == N) break;
			dp[i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			int num = arr[i];
			
			for (int j = i+1; j < i+1 + num; j++) {
				if(j == N) break;
				if(dp[j] < dp[i]) dp[j] = dp[i] + 1;
			}
		}
		if(dp.length == 1) System.out.println(0);
		else if(dp[N-1] == 0) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}
}
