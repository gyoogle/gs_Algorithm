import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5213_진수의홀수약수 {

	
	static long[] arr = new long[1000001];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < arr.length; i+=2) {
			
			for (int j = i; j < arr.length; j+=i) {
				arr[j] += i;
			}
			
		}
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i-1];
		}
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			
			
			System.out.println("#" + t + " " + (arr[n2] - arr[n1 - 1]));
		}
		
		
		
	}

	
}
