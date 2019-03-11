import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3750_Digitsum {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= ts; i++) {
			
			String str = br.readLine();
			
			
			System.out.println("#" + i + " " + digit(str));
			
		}
	}
	
	public static String digit(String str) {
		
		if(str.length() == 1) {
			return str;
		}
		
		int sum = 0;
		
		String[] arr = str.split("");
		
		
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		return digit(Integer.toString(sum));
	}

}
