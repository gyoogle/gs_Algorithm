import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크_김규석 {

	static int N;
	static int[][] map;
	static boolean[] num;
	
	static int[] arr;
	static int[] set;
	static int r;
	static int min;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		r = N/2;
		set = new int[r];
		min = Integer.MAX_VALUE;
		comb(0,0);
		
		System.out.println(min);
	}

	public static void comb(int len, int k) {
		
		if(len == r) {
			num = new boolean[N];
			for (int i = 0; i < set.length; i++) {
				num[set[i]] = true;
			}
			
			int start = 0;
			int link = 0;
			
			for (int i = 0; i < num.length; i++) {
				if(num[i]) { // start 팀
					for (int j = 0; j < num.length; j++) {
						if(i==j) continue;
						if(num[j]) {
							start += map[i][j];
						}
					}
				}
				
				else { // link 팀
					for (int j = 0; j < num.length; j++) {
						if(i==j) continue;
						if(!num[j]) {
							link += map[i][j];
						}
					}
				}
			}
			
			int res = Math.abs(start-link);
			if(min > res) min = res;
			return;
		}
		
		if(k == N) return;
		
		set[len] = arr[k];
		comb(len+1, k+1);
		comb(len, k+1);
	}
}
