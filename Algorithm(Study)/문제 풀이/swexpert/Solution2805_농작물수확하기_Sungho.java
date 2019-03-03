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

		Stack<Integer> st = new Stack<Integer>();

		int[] dy = { -1, 1 };
		for (int i = 0; i < n; i++) {
			for (int y = 0; y < 2; y++) {
				int j = n / 2;
				int nx = i;
				int ny = j;
				visited[nx][ny] = true;
				if (nx < n / 2)
					st.add(nx);
				if (nx > n / 2)
					nx = st.pop();
				for (int k = 0; k < nx; k++) {
					ny = ny + dy[y];
					if (ny >= 0 && ny < n) {
						visited[i][ny] = true;
					}
				}
			}
		}
	} // end of make_visited
} // end of class
