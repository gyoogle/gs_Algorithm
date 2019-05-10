import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_김규석 {
	
	static class pair{
		int y;
		int x;
		
		pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] map;
	static ArrayList<pair> list;
	static boolean[][] visit;
	
	static int[] size = {0, 1, 2, 3, 4, 5}; // 색종이 크기
	static int[] count = {0, 5, 5, 5, 5, 5}; // 색종이 수
	
	static int min;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		list = new ArrayList<>();
		visit = new boolean[10][10];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new pair(i,j));
					visit[i][j] = true; // 색종이 붙일 수 있는 곳
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		dfs(0,0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void dfs(int idx, int cnt) {
		
		if(min < cnt) { // cnt가 최소보다 커지면 종료
			return;
		}
		
		if(idx == list.size()) { // 1인 곳 모두 탐색
			if(min > cnt) min = cnt;
			return;
		}
		
		pair p = list.get(idx);
		
		if(!visit[p.y][p.x]) {
			dfs(idx+1, cnt);
		}
		
		for (int s = 5; s >= 1; s--) {
			
			boolean chk = checking(idx, s);
			
			if(chk) { // 붙일 수 있음
				
				for (int i = p.y; i < p.y+s; i++) {
					for (int j = p.x; j < p.x+s; j++) {
						visit[i][j] = false;
					}
				}
				
				count[s]--; // 색종이 수 감소
				
				dfs(idx+1, cnt+1);
				
				// 백트래킹
				
				count[s]++;
				
				for (int i = p.y; i < p.y+s; i++) {
					for (int j = p.x; j < p.x+s; j++) {
						visit[i][j] = true;
					}
				}
				
			}
		}
		
	}
	
	public static boolean checking(int idx, int s) {
		pair p = list.get(idx);
		boolean c = false;
		
		if(count[s] == 0) { // 해당 사이즈 색종이 없으면 false
			return false;
		}
		
		loop : for (int i = p.y; i < p.y+s; i++) {
			for (int j = p.x; j < p.x+s; j++) {
				if( i < 0 || j < 0 || i >= 10 || j >= 10) {
					c = true;
					break loop;
				}
				
				if(!visit[i][j]) {
					c = true;
					break loop;
				}
			}
		}
		
		if(c)
			return false;
		else
			return true;
	}

}
