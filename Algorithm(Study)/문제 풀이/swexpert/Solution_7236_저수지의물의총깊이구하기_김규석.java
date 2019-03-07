import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7236_저수지의물의총깊이구하기_김규석 {

	static int N;
	static char[][] map;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,1,-1,-1,0,1};
	static int max;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
			
			N = Integer.parseInt(br.readLine().trim());
			
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			max = 0;
			
			here : for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'W') {
						int count = check(i,j);
						if(max < count) max = count;
					}
					
					if(max == 8) break here;
				}
			}
			
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static int check(int x, int y) {
		
		int count = 0;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[nx][ny] == 'W') 
					count++;
			}
		}
		
		if(count == 0) count = 1;
		
		return count;
	}

}
