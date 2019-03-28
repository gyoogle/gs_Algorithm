import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_김규석 {

	static int N,L;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			dp = new int[L+1];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int score = Integer.parseInt(st.nextToken());
				int calory = Integer.parseInt(st.nextToken());
				
				sol(score, calory);
			}
			
			
			System.out.println("#"+t+" " + dp[L]);
		}
	}
	
	public static void sol(int score, int calory) {
		for (int i = L; i >= calory; i--) {
			if(dp[i] < score + dp[i-calory]){
				dp[i] = score + dp[i-calory];
			}
		}
	}

}
