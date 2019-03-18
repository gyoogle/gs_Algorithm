package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성_김규석 {

	static class San{
		int y;
		int x;
		
		San(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int N,K;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	
	static ArrayList<San> san;
	
	static int max = 0;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 지도 한 변 길이
			K = Integer.parseInt(st.nextToken()); // 공사 가능 깊이
			
			map = new int[N][N];
			
			max = Integer.MIN_VALUE;
			int maxHeight = 0; // 가장 큰 지형 높이 찾기
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(maxHeight < map[i][j])
						maxHeight = map[i][j];
				}
			}
			
			san = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == maxHeight)
						san.add(new San(i,j));
				}
			}
			
			visited = new boolean[N][N];
			
			for (int i = 0; i < san.size(); i++) {
				San s = san.get(i);
				cnt = 1;
				
				for (int j = 0; j < N; j++) {
					for (int z = 0; z < N; z++) {
						for (int k = K; k >= 0; k--) {
							map[j][z] -= k;
							visited[s.y][s.x] = true;
							dfs(s.y, s.x, cnt);
							visited[s.y][s.x] = false;
							map[j][z] += k;
							
						}
					}
				}
			}
		
			System.out.println("#"+t+" " + max);
		}
	}
	
	static public void dfs(int y, int x, int len) {
		
		if(max < len) {
			max = len;
		}

		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<N && nx<N && !visited[ny][nx]) {
				if(map[ny][nx] < map[y][x]){
					visited[ny][nx] = true;
					dfs(ny, nx, len+1);
					visited[ny][nx] = false;
				}
			}
		}
	}
	
	static public boolean checking(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && nx>=0 && ny<N && nx<N) {
				if(map[ny][nx] < map[y][x] && !visited[ny][nx]) 
					continue;
				else
					return false;
			}
		}
		
		return true;
	}

}
