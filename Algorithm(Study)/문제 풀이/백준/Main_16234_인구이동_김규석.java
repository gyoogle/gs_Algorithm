import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동_김규석 {

	static class C {
		int y;
		int x;

		C(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, L, R;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visited;

	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int c;
	static int result = 0;
	static int sum, cnt;
	static ArrayList<int[]> arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			
			copymap = new int[N][N];
			visited = new boolean[N][N];
			
			c = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copymap[i][j] == 0) {
						arr = new ArrayList<>();
						sum = map[i][j];
						arr.add(new int[]{i,j});
						cnt = 1;
						
						dfs(i, j);
						c++;
						
						if(cnt > 1){
							for (int t = 0; t < arr.size(); t++) {
								map[arr.get(t)[0]][arr.get(t)[1]] = sum / cnt;
							}
						}
					}
				}
			}

			int[] cnt = new int[--c];

			if (cnt.length == N * N) {
				break;
			}
			
			
			result++;

		}
		System.out.println(result);
	}

	public static void dfs(int y, int x) {

		copymap[y][x] = c;
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
				int k = Math.abs(map[y][x] - map[ny][nx]);
				if (k >= L && k <= R && !visited[ny][nx]) {
					
					cnt++;
					sum += map[ny][nx];
					arr.add(new int[]{ny,nx});
					dfs(ny, nx);
				}
			}
		}
	}
	
	public static void bfs(int y, int x) {
		
		Queue<C> q = new LinkedList<>();
		C cc = new C(y,x);
		q.add(cc);
		
		while(!q.isEmpty()){
			
			C c1 = q.poll();
			copymap[c1.y][c1.x] = c;
			//sum += map[c1.y][c1.x];
			visited[c1.y][c1.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int ny = c1.y + dy[i];
				int nx = c1.x + dx[i];

				if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
					int k = Math.abs(map[c1.y][c1.x] - map[ny][nx]);
					if (k >= L && k <= R && !visited[ny][nx]) {
						q.add(new C(ny,nx));
						visited[ny][nx] = true;
					}
				}
			}
			
		}
	}

}
