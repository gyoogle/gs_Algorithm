package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1012 {

	static int[][] map;
	static boolean[][] visited;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int M, N;
	static int count;
	
	public static void dfs(int y, int x) {
		
		if(visited[y][x]) {
			return;
		}
		
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= 0 && nx >= 0 && ny < N && nx < M){
				if(map[ny][nx] == 1 && !visited[ny][nx]){
					dfs(ny,nx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			int K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && visited[i][j] == false){
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
