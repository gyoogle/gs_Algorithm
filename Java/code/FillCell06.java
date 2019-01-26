package com.fillcell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표에서부터 지정한 칸수까지 상하 좌우에 1 채우기
 *  배열의 크기, 좌표개수, 칸수  {row좌표, column좌표}*좌표개수
 *  8 4 3 1 1 3 1 3 3 4 2
 */
public class FillCell06 {
	static int N;//배열 크기
	static int[][] map;
	
	static boolean inRange(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >= 0 && ny < N)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//처리 코드 작성
		N = sc.nextInt();
		map = new int[N][N];
		
		int cnt = sc.nextInt();
		int dir = sc.nextInt();
		
		int[] xs = {-1,1,0,0};
		int[] ys = {0,0,-1,1};
		
		for (int i = 0; i < cnt; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = 0; j < xs.length; j++) {
				for(int z = 1; z <= dir; z++) {
					
					int nx = x + (xs[j]*z);
					int ny = y + (ys[j]*z);
					System.out.print(nx + ", ");
					System.out.println(ny);
					
					if(inRange(nx, ny)) {
						System.out.println("ok");
						map[nx][ny] = 1;
					}
				}
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
