import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {

	static int N, whiteCnt, blueCnt;
	static int[][] map = new int[129][129];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		whiteCnt = blueCnt = 0;
		
		solution(N, 0, 0);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
		
	}
	
	public static void solution(int N, int y, int x) {
		
		int color = map[y][x];
		
		for (int i = y; i < y+N; i++) {
			for (int j = x; j < x+N; j++) {
				if(map[i][j] != color) {
					
					solution(N/2, y, x);
					solution(N/2, y + N/2, x);
					solution(N/2, y, x + N/2);
					solution(N/2, y + N/2, x + N/2);
					return;
				}
			}
		}
		
		if(color == 1) blueCnt++;
		else whiteCnt++;
		
	}
}
