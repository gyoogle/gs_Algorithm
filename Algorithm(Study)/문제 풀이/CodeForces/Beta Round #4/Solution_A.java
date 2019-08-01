import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_A {

	static int N;
	static boolean chk;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		chk = false;
		
		if(N != 1) {
			for (int i = N/2; i > 0; i--) {
				if(i % 2 == 0 && (N-i) % 2 == 0) {
					chk = true;
					break;
				}
			}
		}
		
		System.out.println(chk ? "YES" : "NO");
	}

}
