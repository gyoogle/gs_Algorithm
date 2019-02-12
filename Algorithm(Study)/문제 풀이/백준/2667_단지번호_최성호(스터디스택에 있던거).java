package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class b2667_단지번호 {

	static int n; // 배열 크기
	static int total, house; // 총 단지수 , 단지안에 집수
	static int[] house2 = new int[650]; // 한개의 단지에 있을 수 있는 집의 최대
	static int[][] map = new int[26][26]; // 배열 정보
	static int[][] visited = new int[26][26]; // bfs visited
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void dfs(int x, int y) {

		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue; // 경계조건

			if (map[nx][ny] == 1 && visited[nx][ny] == 0) { // 인전한 곳이 집이고 visited 안했으면 계속 찾기
				house++; // 집이 존재
				dfs(nx, ny);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = s[i].charAt(j) - 48; // char형이 int형으로 들어갈때 0->48 , 1->49로 들어감
			}
		}

		// visited 초기화 사실 굳이 해줄 필요 없긴함
		/*
		 * for(int i = 0; i < n; i++) { for (int j = 0; j < n; j++) { visited[i][j] = 0;
		 * } }
		 */

		// dfs로~
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					house++; // 일단 집 한개 존재
					dfs(i, j);
					total++; // dfs끝날때가 단지가 한개 존재한다
					house2[total] = house; // dfs끝날때 한 단지의 집 개수 저장
					house = 0; // dfs끝날때 마다 집 개수 초기화
				}
			}
		}
		System.out.println(total);
		Arrays.sort(house2);
		for (int i = 0; i < house2.length; i++) {
			if (house2[i] != 0)
				System.out.println(house2[i]);
		}

	} // end of main
}
