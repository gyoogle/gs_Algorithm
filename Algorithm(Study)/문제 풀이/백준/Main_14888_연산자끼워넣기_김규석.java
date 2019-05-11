import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기_김규석 {

	static int N;
	static int[] num;
	static int[] sol;
	static int[] arr;
	static int[] copy;
	static int[] set;
	static int r;
	
	static boolean[] visit;
	
	static int max, min;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		sol = new int[4];
		arr = new int[N-1];
		st = new StringTokenizer(br.readLine(), " ");
		
		int idx = 0;
		for (int i = 0; i < sol.length; i++) {
			sol[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < sol[i]; j++) {
				arr[idx++] = i;
			}
		}
		
		visit = new boolean[arr.length];
		set = new int[arr.length];
		r = set.length;
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void perm(int len) {
		
		if(len == r) {
			copy = new int[N];
			for (int i = 0; i < copy.length; i++) {
				copy[i] = num[i];
			}
			
			for (int i = 0; i < N-1; i++) {
				int s = set[i];
				
				if(s == 0) { // +
					copy[i+1] = (copy[i] + copy[i+1]);
				}
				else if(s == 1) { // -
					copy[i+1] = (copy[i] - copy[i+1]);
				}
				else if(s == 2) { // *
					copy[i+1] = (copy[i] * copy[i+1]);
				}
				else if(s == 3) { // 나누기
					if(copy[i] < 0 && copy[i+1] > 0) { // 음수를 양수로 나눌때
						int temp = -(copy[i]);
						int res = temp / copy[i+1];
						copy[i+1] = -(res);
					}
					
					else {
						copy[i+1] = (copy[i] / copy[i+1]);
					}
				}
			}
			
			if(copy[copy.length-1] > max) max = copy[copy.length-1];
			if(copy[copy.length-1] < min) min = copy[copy.length-1];
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!visit[i]){
				set[len] = arr[i];
				visit[i] = true;
				perm(len+1);
				visit[i] = false;
			}
			
		}
		
	}
	
	

}
