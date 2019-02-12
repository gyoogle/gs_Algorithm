package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class xy1 {
	int x;
	int y;
	
	xy1(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Problem1389 {
	
	static int[][] map;
	static boolean[] visited;
	static int n,m;
	static int[] cnt;
	static int min = 999999;
	
	public static void bfs(int v){
		Queue<xy1> q = new LinkedList<>();
		
		xy1 a = new xy1(v, 0);
		q.add(a);
		visited[v] = true;
		
		while(!q.isEmpty()){
			xy1 b = q.poll();
			
			int x = b.x;
			int y = b.y;
			
			for (int i = 1; i <= n; i++) {
				if(map[x][i] == 1 && visited[i] == false){
					xy1 c = new xy1(i, y+1);
					q.add(c);
					visited[i] = true;
					cnt[i] += c.y;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		cnt = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1]; // 반복문 돌 때마다 초기화
			bfs(i);
		}
		
		for (int i = 1; i <= n; i++) {
			if(min > cnt[i]) min = cnt[i];
		}
		
		for (int i = 1; i <= n; i++) {
			if(min == cnt[i]){
				System.out.println(i);
				break;
			}
		}
	}
}
