import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231_분해합_김규석 {

	static int[] div = new int[1000001];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < div.length; i++) {
			div[i] = solution(i);
		}
		
		int ask = Integer.parseInt(br.readLine());
		boolean chk = true;
		
		for (int i = 0; i < div.length; i++) {
			if(div[i] == ask) {
				System.out.println(i);
				chk = false;
				break;
			}
		}
		
		if(chk) System.out.println(0);
		
	}
	
	
	public static int solution(int num) {
		
		int sum = num;
		
		String s = Integer.toString(num);
		String[] str = s.split("");
		
		for (int i = 0; i < str.length; i++) {
			sum += Integer.parseInt(str[i]);
		}
		
		return sum;
		
	}

}
