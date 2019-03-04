package com.sea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2805_농작물수확하기_Sungho {

	static int[][] map;
	static boolean[][] visited;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> sum_total = new ArrayList<Integer>();
		int test_case = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= test_case; tc++) {

			sum = 0;
			int n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			// visited 만들기 -> 가운데 마름모에 해당하는 부분만 true인 visited가 만들어진다
			make_visited(n);
			// visited만든 상태로 dfs -> visited가 true인 곳만 방문하면서 sum에 더해준다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0 && visited[i][j] == true) {
						dfs(i, j, n);
					}
				}
			}
			sum_total.add(sum);

			System.out.println("#" + tc + " " + sum_total.get(tc-1));
		} // end of tc
	} // end of main

	private static void dfs(int i, int j, int size) {
		visited[i][j] = false;
		sum += map[i][j];
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
				if (map[i][j] != 0 && visited[i][j] == true) {
					dfs(nx, ny, size);
				}
			}
		}
	} // end of dfs

	private static void make_visited(int n) {
		// 행을 이동하면서 가운데를 기준으로 양옆으로 몇번 이동할지 컨트롤 해주면서 마름모 모양의 true를 만들어 주는 방법
		Stack<Integer> st = new Stack<Integer>();

		int[] dy = { -1, 1 };
		for (int i = 0; i < n; i++) { // 행 이동 for
			for (int y = 0; y < 2; y++) { // 가운데를 기준으로 양옆을 true로 바꿔주기 위한 for
				int nx = i;
				int ny = n / 2; // ny는 2차원 배열의 행에서 가운데에서 시작
				visited[nx][ny] = true; // 일단 각행의 가운데 열은 true로
				if (nx < n / 2) // n=5일때 스택에 0,1이 쌓임
					st.add(nx);
				if (nx > n / 2)
					nx = st.pop(); // 가운데 행을 기준으로 대칭이라서 스택사용 nx = 1,0 순서
				for (int k = 0; k < nx; k++) { // n=5일때 양옆을 0번1번2번1번0번 지나가면서 true로 바꿔줌
					ny = ny + dy[y];
					if (ny >= 0 && ny < n) {
						visited[i][ny] = true;
					}
				}
			}
		}
	} // end of make_visited
} // end of class
