import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2178 {
	static int cnt, N, M;
	static int[][] map;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	
	public static void bfs(int y, int x) {
		
	}
	
	public static void dfs(int y, int x) {
		++cnt;
		map[y][x]=0; //visited check
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<1 || ny>N || nx<1 || nx>M) continue; //index check
			if(map[ny][nx] == 1) dfs(ny,nx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		
		for(int i=1;i<=N;i++) {
			String str = bf.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		} //입력받기
		
		cnt = 0;
		dfs(1,1);
		System.out.println(cnt);
		
		System.out.println();
	}//end of main
	
	
}
