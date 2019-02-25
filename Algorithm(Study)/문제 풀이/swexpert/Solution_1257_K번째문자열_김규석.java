import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_1257_K번째문자열_김규석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			int cnt = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			HashSet<String> saveStr = new HashSet<String>();
			
			int num = 0;
			
			for (int i = str.length(); i > 0; i--) {
				for (int j = 0; j < i; j++) {
					saveStr.add(str.substring(j, j+num+1));
				}
				num++;
			}
			
			Object[] ob = saveStr.toArray();
			
			Arrays.sort(ob);
			
			System.out.println("#" + t + " " + ob[cnt-1]);
		}
	}

}
