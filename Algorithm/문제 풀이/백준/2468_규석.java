package com.ssafy.incheon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2468 {

	static int[][] map; // 2차원 배열 생성
	static boolean[][] visited; // 방문한 영역 확인할 2차원 boolean 배열 생성
	static int n; // 배열 사이즈 받을 변수 선언
	static int[] dx = {0, 0, -1, 1}; // 상하좌우 값 확인할 배열 선언
	static int[] dy = {-1, 1, 0, 0};
	
	public static void dfs(int x, int y, int c){ // dfs
		visited[x][y] = true; // 해당 위치 방문 완료
		
		for (int i = 0; i < 4; i++) { // 상하좌우 확인
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < n){ // 배열을 벗어나지 않게 조건문 생성
				if(visited[nx][ny] == false && map[nx][ny] > c){ // 아직 방문하지 않은 곳이거나, 안잠기는 곳이면
					dfs(nx, ny, c);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(max < map[i][j]){ // 최대 높이 저장
					max = map[i][j];
				}
			}
		}
		
		int maxCount = 1;
		int cnt = 0;
		
		for (int c = 1; c <= max; c++) { // 최대 높이만큼 for문으로 안전 영역 최대 개수 찾기
			visited = new boolean[n][n];
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] > c && visited[i][j] == false){ // 안잠기는 곳이거나 한번도 방문하지 않았으면 
						cnt++;
						dfs(i,j,c);
					}
				}
			}
			if (maxCount < cnt) maxCount = cnt;
		}
		
		System.out.println(maxCount);
	}

}
