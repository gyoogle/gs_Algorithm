import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1256_K번째접미어_김규석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 10; i++) {
			
			int cnt = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			String[] strArr = new String[str.length()];
			
			for (int j = 0; j < strArr.length; j++) {
				strArr[j] = str.substring(j, str.length());
			}
			
			Arrays.sort(strArr);
			
			System.out.println("#" + i + " " + strArr[cnt-1]);
		}
	}

}
