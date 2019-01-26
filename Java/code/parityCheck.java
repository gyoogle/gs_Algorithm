package com.parity;

import java.util.Scanner;

public class parityCheck {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int[][] arr = new int[size+1][size+1];
		
		int[][] check = new int[size+1][size+1];
		int[][] check2 = new int[size+1][size+1];
		
		int parrity = 0;
		boolean chk = true;
		
		//배열에 값 넣기
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//row 합 계산 후 패리티 체크
		for(int i = 1; i < arr.length; i++) {
			int rowSum = 0;
			for(int j = 1; j < arr[i].length; j++) {
				rowSum += arr[i][j];
			}
			
			if(rowSum % 2 == 0) continue;
			else {
				parrity++;
				for(int j = 1; j < arr[i].length; j++) {
					check[i][j] = arr[i][j];
				}
			}
		}
		
		//column 합 계산 후 패리티 체크
		for(int j = 1; j < arr.length; j++) {
			int columnSum = 0;
			for(int i = 1; i < arr[j].length; i++) {
				columnSum += arr[i][j];
			}
			
			if(columnSum % 2 == 0) continue;
			else {
				parrity++;
				for(int i = 1; i < arr[j].length; i++) {
					check2[i][j] = arr[j][i];
				}
			}
		}
		
		if(parrity == 0) // 패리티 없으면 OK
			System.out.println("OK");
		else if (parrity >= 3) // 3이상은 Corrupt
			System.out.println("Corrupt");
		else { // 패리티 2개일 때
			for(int i = 1; i < arr.length; i++) {
				if(chk == false) break;
				for(int j = 1; j < arr[i].length; j++) {
					if(check[i][j] == 1 && check2[i][j] == 1) { // 만약 겹치는 곳이 있다면
						System.out.println("Change bit (" + i + "," + j + ")" );
						chk = false;
						break;
					}
				}
			}
			if(chk) // 겹치는 곳 없다면
				System.out.println("Corrupt");
			
		}
	}

}
