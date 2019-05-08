import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14500_테트로미노_김규석 {

	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int result;
 	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MIN_VALUE;
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i,j,0,0);
				sol(i,j);
			}
		}
		
		
		System.out.println(result);
	}
	
	public static void dfs(int y, int x, int cnt, int val) {
		
		if(cnt == 4) {
			if(result < val) result = val;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			
			if(visit[ny][nx]) continue;
			
			visit[ny][nx] = true;
			dfs(ny,nx,cnt+1,val+map[ny][nx]);
			visit[ny][nx] = false;
		}
		
	}
	
	public static void sol(int y, int x) {
		
		boolean[] chk = new boolean[4];
		int cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			
			chk[i] = true;
			cnt++;
		}
		
		if(cnt == 4) { // 4번 가능
			
			int[] arr = new int[4];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				arr[i] = map[ny][nx];
			}
			
			Arrays.sort(arr);
			int sum = map[y][x];
			
			for (int i = 1; i < arr.length; i++) {
				sum += arr[i];
			}
			
			if(result < sum) result = sum;
			
		}
		
		else if(cnt == 3) { // 한번 가능
			
			int[] arr = new int[3];
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				
				if(!chk[i]) continue;
				
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				arr[idx++] = map[ny][nx];
			}
			
			int sum = map[y][x];
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			
			if(result < sum) result = sum;
		}
	}

}
