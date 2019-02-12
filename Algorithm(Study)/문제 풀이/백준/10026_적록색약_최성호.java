package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10026_적록색약_최성호 {
	
	static char[][] map;
	static int[][] visited;
	static int[][] visited2;
	static int cnt;
	static int cnt2;
	static int n;
	static int[] xs = {-1, 0, 1, 0};
	static int[] ys = {0, 1, 0, -1};
	
	public static void dfs2(int x, int y) {
		
		visited2[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + xs[i];
			int ny = y + ys[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			
			if((map[x][y] == 'R' || map[x][y] == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G') && visited2[nx][ny] == 0) {
				dfs2(nx , ny);
			}
			else if(map[x][y] == 'B' && map[nx][ny] == 'B' && visited2[nx][ny] == 0) {
				dfs2(nx , ny);
			}
		}
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + xs[i];
			int ny = y + ys[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			
			if(map[x][y] == 'R' && map[nx][ny] == 'R' && visited[nx][ny] == 0) {
				dfs(nx , ny);
			}
			else if(map[x][y] == 'B' && map[nx][ny] == 'B' && visited[nx][ny] == 0) {
				dfs(nx , ny);
			}
			else if(map[x][y] == 'G' && map[nx][ny] == 'G' && visited[nx][ny] == 0) {
				dfs(nx , ny);
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new int[n][n];
		visited2 = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <  n; j++) {
				if(map[i][j] == 'R' && visited[i][j] == 0) {
					dfs(i , j);
					cnt++;
				}
				else if(map[i][j] == 'B' && visited[i][j] == 0) {
					dfs(i , j);
					cnt++;
				}
				else if(map[i][j] == 'G' && visited[i][j] == 0) {
					dfs(i , j);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((map[i][j] == 'R' || map[i][j] == 'G') && visited2[i][j] == 0) {
					dfs2(i, j);
					cnt2++;
				}
				else if(map[i][j] == 'B' && visited2[i][j] == 0) {
					dfs2(i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(cnt2);
		cnt = 0;
		cnt2 = 0;
		
		
	} // end of main
}
