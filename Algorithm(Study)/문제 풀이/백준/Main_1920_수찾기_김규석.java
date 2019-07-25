import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] number = new int[100001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		number = new int[N];
			
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			if(maxNum < number[i]) maxNum = number[i];
			if(minNum > number[i]) minNum = number[i];
		}
		
		Arrays.sort(number);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < M; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num > maxNum || num < minNum) {
				sb.append(0).append("\n");
			}
			else {
				
				int max = N;
				int min = -1;
				int mid;
				boolean check = false;
				
				while(max - min > 1) {
					
					mid = (max+min)/2;
					
					if(num == number[mid]){
						sb.append(1).append("\n");
						check = true;
						break;
					}
					if(num > number[mid]){
						min = mid;
					}
					else {
						max = mid;
					}
				}
				if(!check) {
					sb.append(0).append("\n");
				}
			}
			
		}
		
		System.out.println(sb.toString());
	}

}
