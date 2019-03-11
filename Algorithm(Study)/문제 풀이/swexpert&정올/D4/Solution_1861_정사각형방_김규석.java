import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_김규석 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int start;
	static int max;
	static int[][] check;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			
			check = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					start = map[i][j];
					int count = 0;
					dfs(i,j, count);
				}
			}
			
			/*
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(check[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
			System.out.println("#" + t + " " + ans + " " + max);
		}
		
	}
	
	public static void dfs(int x, int y, int count) {
		
		visited[x][y] = true;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny] == map[x][y] + 1) {
					dfs(nx,ny,count);
				}
			}
		}
		
		if(max < count) {
			ans = start;
			max = count;
		}
		else if(max == count) {
			if(start < ans) ans = start;
		}
	}
}
