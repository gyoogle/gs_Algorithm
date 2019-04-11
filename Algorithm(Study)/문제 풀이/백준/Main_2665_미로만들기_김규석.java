import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2665_미로만들기_김규석 {

	static class Block {
		int y;
		int x;

		Block(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int[][] map;
	static int[][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int cnt;
	static int min;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);
		
		System.out.println(visit[N-1][N-1]);
	}

	public static void bfs(int y, int x) {

		Queue<Block> q = new LinkedList<>();

		q.add(new Block(y, x));
		visit[0][0] = 0;

		while (!q.isEmpty()) {

			Block b = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = b.y + dy[i];
				int nx = b.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				
				if(visit[ny][nx] <= visit[b.y][b.x]) continue;
				
				if (map[ny][nx] == 1) {
					q.add(new Block(ny, nx));
					visit[ny][nx] = visit[b.y][b.x];
				}
				else {
					q.add(new Block(ny, nx));
					visit[ny][nx] = visit[b.y][b.x] + 1;
				}
			}

		}

	}


}
