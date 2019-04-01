package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스_김규석 {

	
	static int N,M;
	static int[][] map;
	static int sum;
	static int resultSum;
	static int oneCnt = 0;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				
				}
			}
			
			resultSum = 0;
			
			for (int yy = 0; yy < map.length; yy++) {
				
				for (int xx = 0; xx < map.length; xx++) {
					
					for (int j = 1; j <= N+1; j++) {
						sum = 0;
						checking(yy,xx,j);
						int res = sum*M - ((j*j)+(j-1)*(j-1)); // 이익 계산
						if(res >= 0) { // 이익이 마이너스가 아닐때
							if(resultSum < sum) { // 최대  sum값 저장
								resultSum = sum;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" " + resultSum);
			
		}
		
	}
	
	
	//마름모 구역 합 체크
	public static void checking(int y, int x, int k) {
		int start = x-k+1;
		int end = x+k-1;
		
		
		int first = 0;
		int fs = start;
		int fe = end;
		int firstY = y;
		
		//가운데부터 위
		while(first <= k) {
			
			for (int i = fs; i <= fe; i++) {
				if(firstY>=0 && firstY<N && i>=0 && i<N) {
					sum += map[firstY][i];
				}
				else continue;
			}
			
			fs++;
			fe--;
			first++;
			firstY--;
		}
		
		// 가운데에서 아래
		int second = 0;
		int ss = start+1;
		int se = end-1;
		int secondY = y+1;
		
		while(second <= k-1) {
			for (int i = ss; i <= se; i++) {
				if(secondY>=0 && secondY<N && i>=0 && i<N) {
					sum += map[secondY][i];
				}
				else continue;
			}
			
			ss++;
			se--;
			second++;
			secondY++;
		}
		
	}

}
