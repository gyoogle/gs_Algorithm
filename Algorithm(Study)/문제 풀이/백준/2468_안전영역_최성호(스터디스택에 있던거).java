package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class b2468_안전영역 {
	
	static int n;
	static int[][] map = new int[102][102];
	static int[][] visited = new int[102][102];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	
	public static void dfs(int x, int y, int rain) {
		
		int nx , ny;
		
		visited[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			
			if(map[nx][ny] > rain && visited[nx][ny] == 0) {
				dfs(nx, ny, rain);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int rain_max = 0 , rain_min = 101;
		int area_cnt = 0 , area_max = 1; // 비가 하나도 안올경우 안전구역은 1개
		
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(rain_max <= map[i][j]) rain_max = map[i][j];
				if(rain_min >= map[i][j]) rain_min = map[i][j];
			}
		}
		
		for(int tc = rain_min; tc <= rain_max; tc++) {
			//area_max = 1;
			area_cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > tc && visited[i][j] == 0) {
						dfs(i, j, tc);
						area_cnt++;
					}
				}
			}
			if(area_max < area_cnt) area_max = area_cnt;
		}
		System.out.println(area_max);
		
	} // end of main
}
