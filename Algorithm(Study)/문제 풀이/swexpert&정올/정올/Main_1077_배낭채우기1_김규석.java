package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1077_배낭채우기1_김규석 {
	
	static class J{
		int c;
		int v;
		
		J(int c, int v){
			this.c = c;
			this.v = v;
		}
	}
	static int N,W;
	static ArrayList<J> arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		dp = new int[W+1];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.add(new J(s,c));
		}
		
		for (int z = 1; z < arr.size()-1; z++) {
			int q = arr.get(z-1).c;
			int n = 1;
			for (int j = q; j < dp.length; j+=q) {
				if(dp[j] == 0)
					dp[j] = arr.get(z-1).v * n;
				else if(dp[j] < arr.get(z-1).v * n)
					dp[j] = arr.get(z-1).v * n;
				n++;
			}
		}
		
		for (int i = 1; i < dp.length; i++) {
			
			for (int j = 1; j < arr.size()-1; j++) {
				int q = arr.get(j-1).c;
				if(i > q) {
					int val = arr.get(j-1).v;
					if(dp[i] < val + dp[i-q])
						dp[i] = val + dp[i-q];
				}
			}
		}
		
		System.out.println(dp[W]);
		
	}

}
