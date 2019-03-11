package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7208_지도칠하기_김규석 {
	
	static int N;
	static int[][] map;
	
	static int[] color;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= ts; t++) {
			
			N = Integer.parseInt(br.readLine()); // 나라 수
			map = new int[N][N];
			color = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < color.length; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(map[i][j] == 1) {
						checking(i,j);
					}
				}
			}
			
			System.out.println("#"+t+" " + cnt);
		}
	}
	
	public static void checking(int x, int y) {
		if(color[x] == color[y]) {
			cnt++;
			color[y] += 100;
		}
	}
	
}
