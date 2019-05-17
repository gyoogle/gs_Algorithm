import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17201_자석체인_김규석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");
		boolean chk = true;
		for (int i = 1; i < str.length-1; i+=2) {
			if(str[i].equals(str[i+1])){
				chk = false;
				break;
			}
		}
		
		if(chk)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
