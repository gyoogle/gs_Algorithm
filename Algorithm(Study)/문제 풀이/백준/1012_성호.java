package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012_유기농배추_최성호 {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int m;
	static int n;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int cnt = 0;
			m = sc.nextInt(); // 가로
			n = sc.nextInt(); // 세로
			int k = sc.nextInt(); // 배추위치 개수
			map = new int[m][n];
			visited = new boolean[m][n];
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			for (int j = 0; j < m; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					if (map[j][k1] == 1 && !visited[j][k1]) {
						//bfs(j, k1);
						dfs(j, k1);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // end of tc
	} // end of main

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

	/*private static void bfs(int x, int y) {
		q = new LinkedList<Integer>();

		visited[x][y] = true;
		q.add(x);
		q.add(y);

		while (!q.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				int nx = q.peek() + dx[i];
				int ny = q.peek() + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						q.poll();
						q.poll();
						q.add(nx);
						q.add(ny);
						visited[nx][ny] = true;
					}
				}
			}
			q.clear();
		}
	} // end of bfs
*/} // end of class
