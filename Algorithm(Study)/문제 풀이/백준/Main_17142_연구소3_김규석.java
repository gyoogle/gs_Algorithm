import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17142_연구소3_김규석 {

	public static class Virus {
		int y;
		int x;
		int val;
		
		Virus(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}
	
	public static int N, M;
	public static int[][] map;
	public static int[][] copy;
	public static boolean[][] visited;
	
	public static int[] dy = {-1,1,0,0}; // 상하좌우
	public static int[] dx = {0,0,-1,1};
	public static ArrayList<Virus> list;
	
	public static int[] set;
	
	public static int result;
	public static int max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] == 2) { // 바이러스 위치
					list.add(new Virus(i,j,0));
				}
			}
		}
		
		set = new int[M];
		result = Integer.MAX_VALUE;
		
		comb(0,0);
		
		if(result != Integer.MAX_VALUE)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	
	public static void comb(int len, int k) {
		
		if(len == M) {
			copy = new int[N][N];
			
			loop : for (int i = 0; i < list.size(); i++) {
				
				for (int j = 0; j < set.length; j++) {
					if(i == set[j])
						continue loop;
				}
				
				Virus v = list.get(i);
				
				copy[v.y][v.x] = -9; // 비활성 바이러스는 -9
			}
			
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					if(map[i][j] == 1) {
						copy[i][j] = -1; // 벽은 -1로 초기화
					}
				}
			}
			
			for (int i = 0; i < set.length; i++) {
				Virus v = list.get(set[i]);
				
				copy[v.y][v.x] = -2;
			}
			
			for (int s = 0; s < set.length; s++) { // 활성화 바이러스부터 확장 시작
				
				Queue<Virus> q = new LinkedList<>();
				
				visited = new boolean[N][N];
				
				Virus v = list.get(set[s]);
				q.add(v);
				visited[v.y][v.x] = true;
				
				while(!q.isEmpty()) {
					
					Virus v1 = q.poll();
					int val = v1.val;
					
					for (int i = 0; i < 4; i++) {
						
						int ny = v1.y + dy[i];
						int nx = v1.x + dx[i];
						
						if(ny < 0 || nx < 0 || ny >= N || nx >= N || copy[ny][nx] == -1 || copy[ny][nx] == -2 || visited[ny][nx]) continue;
						
						if(copy[ny][nx] == -9) {
							q.add(new Virus(ny,nx, val+1));
							visited[ny][nx] = true;
							continue;
						}
						
						visited[ny][nx] = true;
						q.add(new Virus(ny,nx, val+1));
						
						if(copy[ny][nx] == 0)
							copy[ny][nx] = val + 1;
						else {
							if(copy[ny][nx] > val+1)
								copy[ny][nx] = val + 1;
						}
						
					}
					
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					if(copy[i][j] == 0) // 갈수 없는 곳
						return;
				}
			}
			
			
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					if(copy[i][j] < 0) continue;
					if(max < copy[i][j]) max = copy[i][j];
				}
			}
			
			/*for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					System.out.print(copy[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();*/
			
			boolean chk = false;
			loop : for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					if(copy[i][j] > 0){
						chk = true;
						break loop;
					}
				}
			}
			
			if(!chk) {
				result = 0;
			}
			
			else {
				if(result > max)
					result = max;
			}
			return;
		}
		
		if(k == list.size()) return;
		
		set[len] = k;
		comb(len+1, k+1);
		comb(len, k+1);
	}
}
