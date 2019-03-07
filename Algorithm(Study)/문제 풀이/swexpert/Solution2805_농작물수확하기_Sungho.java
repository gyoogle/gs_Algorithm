package com.sea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2805_���۹���Ȯ�ϱ�_Sungho {

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

			// visited ����� -> ��� ������ �ش��ϴ� �κи� true�� visited�� ���������
			make_visited(n);
			// visited���� ���·� dfs -> visited�� true�� ���� �湮�ϸ鼭 sum�� �����ش�
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
		// ���� �̵��ϸ鼭 ����� �������� �翷���� ��� �̵����� ��Ʈ�� ���ָ鼭 ������ ����� true�� ����� �ִ� ���
		Stack<Integer> st = new Stack<Integer>();

		int[] dy = { -1, 1 };
		for (int i = 0; i < n; i++) { // �� �̵� for
			for (int y = 0; y < 2; y++) { // ����� �������� �翷�� true�� �ٲ��ֱ� ���� for
				int nx = i;
				int ny = n / 2; // ny�� 2���� �迭�� �࿡�� ������� ����
				visited[nx][ny] = true; // �ϴ� ������ ��� ���� true��
				if (nx < n / 2) // n=5�϶� ���ÿ� 0,1�� ����
					st.add(nx);
				if (nx > n / 2)
					nx = st.pop(); // ��� ���� �������� ��Ī�̶� ���û�� nx = 1,0 ����
				for (int k = 0; k < nx; k++) { // n=5�϶� �翷�� 0��1��2��1��0�� �������鼭 true�� �ٲ���
					ny = ny + dy[y];
					if (ny >= 0 && ny < n) {
						visited[i][ny] = true;
					}
				}
			}
		}
	} // end of make_visited
} // end of class
