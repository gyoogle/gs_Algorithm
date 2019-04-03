import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4672_수진이의팰린드롬_김규석 {

	static String str;
	static int cnt;
	static int[] alpha;
	static String[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
			
			str = br.readLine();
			
			cnt = 0;
			
			alpha = new int[26];
			p = str.split("");
			
			for (int i = 0; i < p.length; i++) {
				int k = p[i].charAt(0) - 'a';
				alpha[k]++;
			}
			
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i] != 0) {
					cnt += (alpha[i] * (alpha[i]+1))/2;
				}
			}
			
			System.out.println("#"+t+" " + cnt);
		}
	}
}
