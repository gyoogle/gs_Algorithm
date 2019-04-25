import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3085_사탕게임_김규석 {

	static int N;
	static char[][] map;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				for (int z = 0; z < 4; z++) {
					int ny = i + dy[z];
					int nx = j + dx[z];
					
					if(ny < 0 || nx < 0 || ny>=N || nx>=N) continue;
					
					char temp = map[i][j];
					map[i][j] = map[ny][nx];
					map[ny][nx] = temp;
					
					checking(i,j);
					
					temp = map[i][j];
					map[i][j] = map[ny][nx];
					map[ny][nx] = temp;
				}
				
			}
		}
		
		System.out.println(max);
		
		
	}
	
	
	public static void checking(int y, int x) {
		
		int cnt = 1;
		char now = map[y][x];
		
		//해당 위치 행 확인
		for (int i = x-1; i >= 0; i--) {
			if(map[y][i] == now)
				cnt++;
			else 
				break;
		}
		
		for (int i = x+1; i < N; i++) {
			if(map[y][i] == now)
				cnt++;
			else
				break;
		}
		
		if(max < cnt) max = cnt;
		
		cnt = 1;
		//해당 위치 열 확인
		for (int i = y-1; i >= 0; i--) {
			if(map[i][x] == now)
				cnt++;
			else 
				break;
		}
		
		for (int i = y+1; i < N; i++) {
			if(map[i][x] == now)
				cnt++;
			else
				break;
		}
		
		if(max < cnt) max = cnt;
	}

}
