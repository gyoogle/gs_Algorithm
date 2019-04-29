import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1094_막대기_김규석 {

	static int res;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int max = 64;
		res = 0;
		
		sol(n, max);
		
		System.out.println(res);
	}
	
	public static void sol(int num, int max) {
		
		while(true) {
			
			if(num == 1) {
				res++;
				break;
			}
			
			
			if(num / max == 0) {
				max /= 2;
			}
			else {
				if(num == max) {
					num /= max;
					continue;
				}
				num %= max;
				res++;
			}
		
		}
	}

}
