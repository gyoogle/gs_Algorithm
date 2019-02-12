package backjoon;

import java.util.Scanner;

public class b1987_알파벳 {

	static int r, c;
	static int a_index;
	static int cnt_index;
	static int cnt2;
	static int max_x, max_y;
	
	static int[] cnt;
	static int[][] i_visited; // 인덱스의 visited
	static char[] a_visited; // 알파벳의 visited
	static char[][] map;
	static int[] nx = { -1, 0, 1, 0 };
	static int[] ny = { 0, 1, 0, -1 };

	public static void dfs(int x, int y) {
		i_visited[x][y] = 1;
		a_visited[a_index++] = map[x][y];

		for (int i = 0; i < 4; i++) {
			int xx2 = x + nx[i];
			int yy2 = y + ny[i];

			if (xx2 < 0 || xx2 >= r || yy2 < 0 || yy2 >= c) continue;

			if (i_visited[xx2][yy2] == 0 && alpha(xx2, yy2)) { // 방문 안했고 지나온 알파벳이 아니면
				cnt2++;
				if(max_x < xx2) max_x = xx2;
				if(max_y < yy2) max_y = yy2;
				dfs(xx2, yy2);
				//cnt[cnt_index]++;
				//System.out.println(cnt2);
				
			}
		}
	}

	public static boolean alpha(int x, int y) {
		for (int i = 0; i < a_visited.length; i++) {
			if (map[x][y] == a_visited[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 입력
		r = sc.nextInt(); // x
		c = sc.nextInt(); // y
		String[] s = new String[r];
		map = new char[r][c];
		i_visited = new int[r][c];
		a_visited = new char[10];
		cnt = new int[10];
		for (int i = 0; i < r; i++) {
			s[i] = sc.next();
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = s[i].charAt(j);
			}
		}

		// dfs로~
		max_x = 999999;
		max_y = 999999;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i_visited[i][j] == 0 && alpha(i, j) && i <= max_x && j <= max_y) { // 방문 안했으면
					dfs(i, j);
					//cnt[cnt_index]++;
					cnt2++;
					max_x = 0;
					max_y = 0;
					//System.out.println(cnt2);
				}
			}
		}
		
		// 출력
		/*for(int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}*/
		System.out.println(cnt2);
		
	} // end of main
}
