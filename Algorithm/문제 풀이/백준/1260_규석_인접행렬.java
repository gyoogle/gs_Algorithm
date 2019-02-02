package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1260 {

	static int[][] map;
	static boolean[] visited;
	static int n, m, v;
	
	public static void dfs(int v, int n){
		if(visited[v]) return;
		
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= n; i++) {
			if(map[v][i] == 1){
				dfs(i, n);
			}
		}
	}
	
	public static void bfs(int v, int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		
		while(!q.isEmpty()){
			int temp = q.poll();
			visited[temp] = true;
			System.out.print(temp + " ");
			for (int i = 1; i <= n; i++) {
				if(map[temp][i] == 1 && visited[i] == false){
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			String[] vv = br.readLine().split(" ");
			
			int v1 = Integer.parseInt(vv[0]);
			int v2 = Integer.parseInt(vv[1]);
			
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		dfs(v, n);
		
		System.out.println();
		visited = new boolean[n+1];
		
		bfs(v, n);
	}
}
