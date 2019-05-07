import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17086_아기상어2_김규석 {

	static class pair {
		int y;
		int x;
		
		pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N,M;
	static int[][] map;
	static int[][] result;
	static ArrayList<pair> list;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					list.add(new pair(i,j));
				}
			}
		}
		
		result = new int[N][M];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					result[i][j] = sol(i,j);
					if(result[i][j] > max) max = result[i][j];
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static int sol(int y, int x) {
		
		int m = Integer.MAX_VALUE;
		
		for (int i = 0; i < list.size(); i++) {
			int d = dir(y,x, list.get(i).y, list.get(i).x);
			
			if(m > d) m = d;
		}
		
		return m;
		
	}

	public static int dir(int y1, int x1, int y2, int x2) {
		if(y1 == y2 && x1 != x2) {
			return Math.abs(x1-x2);
		}
		else if (x1 == x2 && y1 != y2) {
			return Math.abs(y1-y2);
		}
		else if (y1 != y2 && x1 != x2) {
			
			if(Math.abs(y1-y2) > Math.abs(x1-x2)) {
				return Math.abs(y1-y2);
			}
			else {
				return Math.abs(x1-x2);
			}
			
		}
		
		return 0;
	}
	
}
