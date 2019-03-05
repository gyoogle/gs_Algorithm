package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9663 {
	
	static int N;
	static boolean[][] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		dfs(visited, N, 0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(boolean[][] visited, int N, int x) {
		
		if (x == N) {
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited.length; j++) {
					int k = visited[i][j] == true ? 1 : 0;
					System.out.print( k + " ");
				}
				System.out.println();
			}
			System.out.println();
			cnt++;
		}
		else {
			for (int y = 0; y < N; y++) {
				if(checking(visited, N, x, y)){
					boolean[][] newvisited = copy(visited, N);
					newvisited[x][y] = true;
					dfs(newvisited, N, x+1);
				}
			}
		}
	}
	
	public static boolean checking(boolean[][] visited, int n, int x, int y) {
		for (int i = 1; i <= x; i++) {
			
			if (x-i>=0 && y-i>=0 && visited[x-i][y-i]) {
				return false;
			}
			if (x-i>=0 && y+i<N && visited[x-i][y+i]) {
				return false;
			}
			if (x-i>=0 && visited[x-i][y]) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public static boolean[][] copy(boolean[][] visited, int N){
		
		boolean[][] res = new boolean[N][N];
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				res[i][j] = visited[i][j];
			}
		}
				
		return res;
	}

}
