import java.util.Scanner;

/*
 * 티떱숲은 r x c 
 * 비어있는 곳 '.', 물이 차있는 지역은 '*', 돌은 'X', 비버의 굴은 'D', 고슴도치는 'S'
 * 물 먼저 채우고, 고슴도치를 이동
 */

public class Main3055_Hyunah {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] tittub = new char[r][c];
		int[] hedge = new int[3]; // 고슴도치의 위치를 저장할 배열
		int[] water = new int[3]; // 물의 위치를 저장할 배열
		for(int i=0; i<r; i++) {
			String str = sc.next();
			for(int j=0; j<c; j++) {
				tittub[i][j] = str.charAt(j);
				if(tittub[i][j] == 'S') { // 고슴도치일 경우, 위치저장
					hedge[0] = i; hedge[1] = j; hedge[2] = 1;
				}
			}
		}
		
		System.out.println(bfs(r, c, tittub, hedge));
	}

	private static String bfs(int r, int c, char[][] tittub, int[] hedge) {
		// TODO Auto-generated method stub
		// 고슴도치의 위치를 담은 queue
		int[][] qHedge = new int[r*c+1][3];
		int fHedge = -1;
		int rHedge = -1;
		qHedge[++fHedge] = hedge;
		
		// 물의 위치를 담은 queue
		int[][] qWater = new int[r*c+1][3];
		int fWater = -1;
		int rWater = -1;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(tittub[i][j] == '*') {
					qWater[++fWater][0] = i;
					qWater[fWater][1] = j;
				}
			}
		}
		int[] water;
		
		int cnt = 0;
		while(fHedge != rHedge) {
			cnt++;
						
			// 물 뿌리기
			int tfWater = fWater;
			while (fWater != rWater) {
				water = qWater[++rWater];
				for (int i = 0; i < 4; i++) {
					int rx = water[0] + dx[i];
					int ry = water[1] + dy[i];
					if (rx >= 0 && ry >= 0 && rx < r && ry < c && tittub[rx][ry] != 'X' && tittub[rx][ry] != 'D'
							&& tittub[rx][ry] != '*') {
						tittub[rx][ry] = '*';
						qWater[++tfWater][0] = rx;
						qWater[tfWater][1] = ry;
					}
				}
			}
			fWater = tfWater;
			
			int tfHedge = fHedge;
			while (fHedge != rHedge) {
				hedge = qHedge[++rHedge];
				for (int i = 0; i < 4; i++) {
					int rx = hedge[0] + dx[i];
					int ry = hedge[1] + dy[i];
					if (rx >= 0 && ry >= 0 && rx < r && ry < c && tittub[rx][ry] != 'X' && tittub[rx][ry] != '*'
							&& tittub[rx][ry] != 'S') {
						if (tittub[rx][ry] == 'D') {
							return cnt + "";
						}
						tittub[rx][ry] = 'S';
						qHedge[++tfHedge][0] = rx;
						qHedge[tfHedge][1] = ry;
					}
				}
			}
			fHedge = tfHedge;
		}
		return "KAKTUS";
	}
	
}