package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7234_안전기지_김규석 {

	static int map[][];
	static int N, B;
	static int[] dy = {-2,-1,1,2,0,0,0,0};
	static int[] dx = {0,0,1,2,-2,-1,1,2};
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			max = 0;
			
			for (int i = 0; i < B; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[y][x] = -1; // 안전기지
				check(y, x);
			}

			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map.length; j++) {
					if(map[i][j] > max)
						max = map[i][j];
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void check(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<N+1 && nx<N+1) {
				if(map[ny][nx] != -1)
					map[ny][nx]++;
			}
		}
	}

}
