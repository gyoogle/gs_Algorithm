package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11724 {
	
	static int[][] map;
	static boolean[] visited;
	static int n; // 정점 개수
	static int m; // 간선 개수
	static int count = 0;
	
	public static void dfs(int i, int n){
		visited[i] = true;
		
		for (int j = 1; j <= n ; j++) {
			if(map[i][j] == 1 && visited[j] == false){
				dfs(j, n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		map = new int[n+1][n+1];
		
		int u, v;
		
		for (int i = 1; i <= m ; i++) {
			String[] arr = br.readLine().split(" ");
			
			u = Integer.parseInt(arr[0]);
			v = Integer.parseInt(arr[1]);
			
			map[u][v] = map[u][v] = 1;
		}
		
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			if(visited[i] == false){
				dfs(i, n);
				count++;
			}
		}
		
		System.out.println(count);
	}

}
