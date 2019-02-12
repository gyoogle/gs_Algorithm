package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class xy { // 좌표 x,y를 저장할 클래스 생성
	int x;
	int y;
	
	xy(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Problem2178 {
	
	static int[][] map;
	static boolean[][] visited;
	static int n,m;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	//static int count = 0;
	
	public static void bfs(int x, int y) {
		Queue<xy> q = new LinkedList<>();
		
		xy n1 = new xy(x, y);
		
		q.add(n1);
		visited[n1.x][n1.y] = true;
		
		while(!q.isEmpty()){
			xy n2 = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = n2.x + dx[i];
				int ny = n2.y + dy[i];
				
				if(nx>=0 && nx < n && ny >=0 && ny < m){
					if(map[nx][ny] == 1 && visited[nx][ny] == false){
						xy n3 = new xy(nx, ny);
						q.add(n3);
						//count++;
						map[nx][ny] = map[n2.x][n2.y] + 1;
						visited[n3.x][n3.y] = true;
					}
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs(0,0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(map[n-1][m-1]);
	}

}
