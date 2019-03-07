package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_김규석 {

	static int[][] map;
	static int max = 1000000000;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					int k = Integer.parseInt(st.nextToken());
					
					if(k != 0)
						map[i][j] = k;
					else
						map[i][j] = max;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) {
						map[i][j] = 0;
					}
				}
			}
			
			
			for (int k = 0; k < N; k++) {
				
				for (int i = 0; i < N; i++) {
					if(k == i) continue;
					
					for (int j = 0; j < N; j++) {
						if(k==j || i==j) continue;
						
						if(map[i][j] > map[i][k] + map[k][j])
							map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
			
			int tmp = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int min = 0;
				for (int j = 0; j < N; j++) {
					min += map[i][j];
				}
				
				if(min < tmp) tmp = min;
			}
			
			System.out.println("#"+t+" " + tmp);
		}
		
	}
}
