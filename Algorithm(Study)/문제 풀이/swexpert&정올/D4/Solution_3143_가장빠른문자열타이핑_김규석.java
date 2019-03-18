package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3143_가장빠른문자열타이핑_김규석 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			int cnt = 0;
			
			for (int i = 0; i <= A.length() - B.length(); i++) {
				String a = A.substring(i, i+B.length());
				if(a.equals(B)) {
					cnt++;
					i += B.length()-1;
				}
				
			}
			
			String[] str = A.split(B);
			
			
			for (int i = 0; i < str.length; i++) {
				if(!str[i].equals("")) {
					cnt+= str[i].length();
				}
			}
			
			System.out.println("#"+t+ " " + cnt);
		}
	}

}
