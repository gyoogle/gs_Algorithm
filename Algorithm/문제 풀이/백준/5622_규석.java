import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5622 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] dial = br.readLine().split("");
		int sum = 0;
		
		for (int i = 0; i < dial.length; i++) {
			char chk = dial[i].charAt(0);
			int alpha = (char) (chk - '0');
			
			if (alpha >= 17 && alpha <= 19) { // ABC
				sum += 3;
			} else if(alpha >= 20 && alpha <= 22) { //DEF
				sum += 4;
			} else if(alpha >= 23 && alpha <= 25) { //GHI
				sum += 5;
			} else if(alpha >= 26 && alpha <= 28) { //JKL
				sum += 6;
			} else if(alpha >= 29 && alpha <= 31) { //MNO
				sum += 7;
			} else if(alpha >= 32 && alpha <= 35) { //PQRS
				sum += 8;
			} else if(alpha >= 36 && alpha <= 38) { //TUV
				sum += 9;
			} else if(alpha >= 39 && alpha <= 42) { //WXYZ
				sum += 10;
			}
		}
		
		System.out.println(sum);
	}

}