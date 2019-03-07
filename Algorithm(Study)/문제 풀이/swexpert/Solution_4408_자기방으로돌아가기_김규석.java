import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408 {

	static int N;
	static int[] visited;
	static int cnt;
	
	public static void visit(int y, int x) {
		
		if(x < y) {
			int temp = y;
			y = x;
			x = temp;
		}
		
		y = (y-1)/2;
		x = (x-1)/2;
		
		for (int i = y; i <= x; i++) {
			visited[i] +=1 ;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(cnt < visited[i])
				cnt = visited[i];
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine().trim());
			
			visited = new int[201];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				visit(y, x);
			}
			
			
			System.out.println("#"+t+" " + cnt);
		}
	}

}
