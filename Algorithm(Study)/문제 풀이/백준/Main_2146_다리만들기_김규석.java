import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기_김규석 {

	static class pair {
		int y;
		int x;
		int val;
		
		pair(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}
	static int N;
	static int[][] map;
	static int[][] copy;
	static int[][] result;
	static boolean[][] visit;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int min;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][N];
		copy = new int[N][N];
		int num = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j] ) {
					bfs(i,j, num);
					num++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copy[i][j] != 0)
					sol(i,j);
			}
		}
		
		System.out.println(min);
	}
	
	public static void sol(int y, int x) {
		
		int check = copy[y][x];
		
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				if(copy[i][j] != 0 && copy[i][j] != check) {
					int dir = Math.abs(i-y) + Math.abs(j-x) - 1;
					if(min > dir) min = dir;
				}
			}
		}
		
	}
	
	public static void bfs(int y, int x, int val) {
		
		Queue<pair> q = new LinkedList<>();
		
		q.add(new pair(y,x,0));
		visit[y][x] = true;
		copy[y][x] = val;
		
		while(!q.isEmpty()) {
			
			pair p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 0) continue;
				
				if(map[ny][nx] == 1 && !visit[ny][nx]){
					q.add(new pair(ny,nx,0));
					visit[ny][nx] = true;
					copy[ny][nx] = val;
				}
			}
			
		}
		
	}

}
