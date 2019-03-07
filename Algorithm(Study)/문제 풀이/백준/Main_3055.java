import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 3055 탈출
//2019-03-05
public class Main_3055 {
	/*
	 * . 비어있는 곳 * 물 X 돌 D 비버의 굴 S 고슴도치
	 * 
	 * 물과 고슴도치는 돌을 통과할 수 없다. 고슴도치는 물을 이동할 수 없다. / 물이 찰 예정인 칸으로 이동할 수 없다 . 물도 비버의 소굴로
	 * 이동할 수 없다.
	 * 
	 * 고슴도치 ==> 비버의 굴
	 */

	static char[][] map;
	static Queue<pair> water;
	static int start_y, start_x, end_y, end_x, R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					start_y = i;
					start_x = j;
				}

				else if (map[i][j] == '*')
					water.add(new pair(i, j));

			}
		} // input

		int ans = bfs();
		System.out.println(ans == -1 ? "KAKTUS" : ans);

	} // end of main

	public static int bfs() {
		int min = Integer.MAX_VALUE;
		int time = 0;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		Queue<pair> sq = new LinkedList<>();
		sq.add(new pair(start_y, start_x));

		while (!sq.isEmpty()) {
			time++;
			// 물 흩뿌리기
			int waters = water.size();
			for (int w = 0; w < waters; w++) {
				pair wp = water.poll();
				int wy = wp.y;
				int wx = wp.x;

				for (int i = 0; i < 4; i++) {
					int ny = wy + dy[i];
					int nx = wx + dx[i];
					if (ny < 0 || ny > R - 1 || nx < 0 || nx > C - 1)
						continue;
					if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
						map[ny][nx] = '*';
						water.add(new pair(ny, nx));
					}
				}
			}

			// 고슴도치 이동
			int doch = sq.size();
			for (int d = 0; d < doch; d++) {
				pair p = sq.poll();
				int y = p.y;
				int x = p.x;
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || ny > R - 1 || nx < 0 || nx > C - 1)
						continue;
					if (map[ny][nx] == '.') {
						map[y][x] = 'S';
						map[ny][nx] = 'S';
						sq.add(new pair(ny, nx));
					} else if (map[ny][nx] == 'D') {// 도
						return time;
					}
				}
			}
		}
		return -1;
	}

	public static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
