package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9663_NQueen_±è±Ô¼® {

	static int[][] map;
	static int N;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int cnt;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			map = new int[N][N];
			backtracking(0, i, 0);
		}
		
		System.out.println(cnt);
	}
	
	public static void backtracking(int y, int x, int level) {
		
		map[y][x] += 1;
		check(y,x);
		
		/*
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		if(level == N-1) {
			cnt++;
			return;
		}
		
		for (int z = 0; z < N; z++) {
			
			if(map[y+1][z] == 0) {
				//System.out.println("["+(y+1) + "," + z + "]");
				
				backtracking(y+1, z, level+1);
				
				map[y+1][z] -= 1;
				
				for (int i = 0; i < 8; i++) {
					int ny = y+1;
					int nx = z;
					
					while(true) {
						ny += dy[i];
						nx += dx[i];
						
						if(ny>=0 && nx>=0 && ny<N && nx<N) {
							map[ny][nx] -= 1;
						}
						else break;
					}
				}
			}
			
		}
		
		
	}
	
	public static void check(int y, int x) {
		
		for (int i = 0; i < 8; i++) {
			int ny = y;
			int nx = x;
			
			while(true) {
				ny += dy[i];
				nx += dx[i];
				
				if(ny>=0 && nx>=0 && ny<N && nx<N) {
					map[ny][nx] += 1;
				}
				else break;
			}
		}
	}

}