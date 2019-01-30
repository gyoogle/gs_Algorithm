package com.ssafy.algo;

import java.util.Scanner;

public class Solution_5431_민석이의과제체크하기_김규석 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		
		for (int i = 0; i < ts; i++) {
			
			//첫째 줄
			int stu = sc.nextInt(); //수강생 수
			int okNum = sc.nextInt(); //과제 제출 사람 수
			
			int[] stuNum = new int[stu]; // 수강생 수 만큼 배열 생성
			
			for (int j = 0; j < okNum; j++) { // 제출 사람 저장
				int num = sc.nextInt();
				stuNum[num-1]++;
			}
			
			System.out.print("#" + (i+1) + " ");
			
			for (int j = 0; j < stuNum.length; j++) { // 제출 안한 사람 출력
				if(stuNum[j] == 0) {
					System.out.print(j+1 + " ");
				}
			}
			System.out.println();
			
		}
	}

}
