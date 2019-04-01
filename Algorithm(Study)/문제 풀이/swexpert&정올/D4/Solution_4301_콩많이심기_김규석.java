package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_김규석 {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ts = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= ts; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[1001][1001];

			add(map);

			int max = Integer.MIN_VALUE;

			if (M == 2 && N == 2) {
				max = 4;
			} else {
				int sum1 = 0;
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						sum1 += map[i][j];
					}
				}

				int sum2 = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						sum2 += map[i][j];
					}
				}

				if (sum1 < sum2)
					sum1 = sum2;

				if (max < sum1)
					max = sum1;
			}
			
			System.out.println("#" + t + " " + max);
		}

	}

	public static void add(int[][] map) {

		allAdd(0, 0);

		for (int i = 3; i < map.length; i += 4) {
			allAdd2(i, 0);
		}
		for (int i = 0; i < map.length; i += 4) {
			allAdd(0, i);
		}

	}

	public static void allAdd(int y, int x) {
		for (int i = y; i < map.length; i++) {
			if (x < map.length)
				map[i][x] = 1;
			if (x + 1 < map.length) {
				map[i][x + 1] = 1;
			}
			x++;
		}

	}

	public static void allAdd2(int y, int x) {
		// map[y-1][x] = 1;
		for (int i = y; i < map.length; i++) {
			if (x - 1 >= 0 && x - 1 < map.length)
				map[i][x - 1] = 1;
			if (x >= 0 && x < map.length) {
				map[i][x] = 1;
			}
			x++;
		}
	}

}
