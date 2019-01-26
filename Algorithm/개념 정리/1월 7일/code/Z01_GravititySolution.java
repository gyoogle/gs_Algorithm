package com.ssafy.algo;

public class Z01_GravititySolution {

	public static void main(String[] args) {
		int[] m = {7,4,2,0,0,6,0,7,0};
		
		int maxCnt = 0;
		for (int i = 0; i < m.length; i++) {
			int cnt = 0;
			
			for (int j = i+1; j < m.length; j++) { // 내 위치 오른쪽에 내 값보다 작은 값 개수 카운팅
				if(m[i] > m[j]) cnt++;
			}
			if(maxCnt < cnt) maxCnt = cnt;
		}
		System.out.println("최대 낙차 : " + maxCnt);
		
		/*
		int[][] room = new int[8][9]; // 8행 9열 공간
		
		// 1차원 배열값 읽어서 박스 채우기
		for (int i = 0; i < 9; i++) { // 열 (0~8까지)
			for (int j = 7; m[i] > 0; j--, m[i]--) { // 행
				room[j][i] = 1;
			}
		}
		
		// 90도 오른쪽으로 회전
		int[][] nroom = new int[9][8]; // 9행 8열
		for (int i = 0; i < room.length; i++) { //8행
			for (int j = 0; j < room[i].length; j++) {
				nroom[j][7-i] = room[i][j];
			}
		}
		
		
		// 떨어트리기
		int maxGap = 0;
		for (int i = 7; i >= 0; i--) { //행 (8행은 안떨어지므로 7행부터)
			for (int j = 0; j < nroom[i].length; j++) {
				
				int gap = 0; // 낙차 카운팅
				
				if(nroom[i][j] == 1) { //박스면 아래로 떨어트려라
					for (int k = 0; k < 9; k++) {
						if(i+k+1 >= 9 || nroom[i+k+1][j] == 1) break; // 아래 칸이 박스가 아니어야 함
						
						nroom[i+k][j] = 0; // 박스를 아래로 내리기
						nroom[i+k+1][j] = 1;
						gap++;
					}
					if(maxGap <= gap) maxGap = gap;
				}
			}
		}
		
		System.out.println("최대 낙차 : " + maxGap);
		
		
		for (int i = 0; i < room.length; i++) { //행
			for (int j = 0; j < room[i].length; j++) { //열
				System.out.print(room[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < nroom.length; i++) { //행
			for (int j = 0; j < nroom[i].length; j++) { //열
				System.out.print(nroom[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
	} // end of main
} // end of class
