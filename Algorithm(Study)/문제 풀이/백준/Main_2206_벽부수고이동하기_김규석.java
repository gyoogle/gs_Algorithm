import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기_김규석 {

	static class H {
		int y;
		int x;
		int dist;
		int drill;
		
		public H(int y, int x, int dist, int drill) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.drill = drill;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] copy;
	

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				copy[i][j] = Integer.MAX_VALUE;
			}
		}
		result = Integer.MAX_VALUE;

		bfs(0, 0);
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	public static void bfs(int y, int x) {

		Queue<H> q = new LinkedList<>();

		q.add(new H(y, x, 1, 0));
		copy[y][x] = 0; // 공사 횟수

		while (!q.isEmpty()) {
			H m = q.poll();
			
			// 도착했을 때
			if(m.y == N - 1 && m.x == M - 1) {
				result = m.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = m.y + dy[i];
				int nx = m.x + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;

				if (copy[ny][nx] <= m.drill)
					continue;
				
				if (map[ny][nx] == 0) {
					copy[ny][nx] = m.drill;
					q.add(new H(ny, nx, m.dist + 1, m.drill));
				}
				// 벽인 경우
				else {
					if (m.drill == 0) {
						copy[ny][nx] = m.drill + 1;
						q.add(new H(ny, nx, m.dist + 1, m.drill + 1));
					}
				}
			}
		}
	}
}
