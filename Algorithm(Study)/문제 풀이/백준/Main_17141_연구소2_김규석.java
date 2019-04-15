import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17141_연구소2_김규석 {
	
	static class Virus {
		int y;
		int x;
		int val;
		
		Virus(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}
	
	static int N,M;
	static int[][] map;
	static int[][] copy;
	static boolean[][] visit;
	static Virus[] set;
	static ArrayList<Virus> virus;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		set = new Virus[M];
		virus = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Virus(i,j, 0));
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		
		comb(0,0);
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
		
	}
	
	public static void sol(Virus[] set) {
		
		for (int s = 0; s < set.length; s++) {
			
			Queue<Virus> q = new LinkedList<>();
			visit = new boolean[N][N];
			
			Virus v = set[s];
			
			q.add(v);
			visit[v.y][v.x] = true;
			copy[v.y][v.x] = -2;
			
			while(!q.isEmpty()) {
				
				Virus vv = q.poll();
				int val = vv.val;
				
				for (int i = 0; i < 4; i++) {
					
					int ny = vv.y + dy[i];
					int nx = vv.x + dx[i];
					
					if(ny<0 || nx <0 || ny >= N || nx >= N || copy[ny][nx] == -1 || copy[ny][nx] == -2 || visit[ny][nx]) continue;
					
					visit[ny][nx] = true;
					q.add(new Virus(ny,nx, val+1));
					if(copy[ny][nx] == 0)
						copy[ny][nx] = val+1;
					else {
						if(copy[ny][nx] > val+1)
							copy[ny][nx] = val+1;
					}
				}
				
			}
		}
		
		
		int min = Integer.MIN_VALUE;
		
		loop : for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copy[i][j] > 0) {
					if (copy[i][j] > min) min = copy[i][j];
				}
				if(copy[i][j] == 0) { // 퍼뜨릴 수 없는 경우
					min = -1;
					break loop;
				}
			}
		}
		
		
		if(min != -1) {
			if(result > min) result = min;
		}
		
	}
	
	public static void comb(int len, int k) {
		
		if(len == M) {
			copy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1)
						copy[i][j] = -1;
				}
			}
			sol(set);
			return;
		}
		if(k == virus.size()) return;
		
		set[len] = virus.get(k);
		comb(len + 1, k + 1);
		comb(len, k + 1);
	}

}
