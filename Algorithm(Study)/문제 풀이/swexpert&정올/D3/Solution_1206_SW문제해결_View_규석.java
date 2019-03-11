package com.prac;

import java.util.Scanner;

public class SW문제해결_View_규석 {

	static int[][] arr = new int[1000][255]; // 배열 생성
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) { // test case
			
			int cnt = 0; // 조망권 수 
			int build = sc.nextInt(); // 건물 수 입력
			
			arr = new int[build][255]; // 건물 수만큼 배열 재정의
			
			for (int j = 0; j < arr.length; j++) {
				int h = sc.nextInt(); // 각 높이 입력
				for (int z = 0; z < h; z++) {
					arr[j][z] = 1; // 해당 층 value 1로 변경
				}
			}
			
			for (int j = 2; j < arr.length-2; j++) {
				for (int z = 0; z < arr[j].length; z++) {
					if(arr[j][z] == 1) { //조망권 칸
						if(arr[j-2][z] == 0 && arr[j-1][z] == 0 && arr[j+1][z] == 0 && arr[j+2][z] == 0) {
							cnt++;
						}
					}
				}
			}
			
			System.out.println("#" + i + " " + cnt);
		}
	}

}
