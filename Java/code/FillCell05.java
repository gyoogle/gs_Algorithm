package com.fillcell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표의 상하좌우에  1을 표시하기 
 * 입력 :배열의 크기,  좌표개수  {row좌표, column좌표}*좌표개수
 *  8 4 1 1 3 1 3 3 4 2
 * 
 */
public class FillCell05 {
	static int N;//배열 크기
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//처리 코드 작성
		N = sc.nextInt();
		map = new int[N][N];
		
		int cnt = sc.nextInt();
		
		for(int i = 0; i < cnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int[] xs = {-1,1,0,0};
			int[] ys = {0,0,-1,1};
			
			
			for(int j = 0; j < xs.length; j++) {
				int nx = x + xs[j];
				int ny = y + ys[j];
				
				if(nx>=0 && nx < N && ny>=0 && ny<N)
					map[nx][ny] = 1;
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
