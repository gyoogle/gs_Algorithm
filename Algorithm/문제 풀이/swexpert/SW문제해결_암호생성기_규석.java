package com.prac;

import java.util.Scanner;

public class SW문제해결_암호생성기_규석 {

	static int[] arr = new int[10];
	
	public static void cycle(int[] a) { // cycle 함수
		
		boolean c = true;
		
		for (int i = 1; i <= 5; i++) {
			
			if(a[0] >= 0) { // 첫번째 배열이 0보다 클 때만 진행
				a[0] -= i;
				if(a[0] < 0) a[0] = 0;
				a[8] = a[0];
				
				for (int j = 0; j < 8; j++) { // 배열 왼쪽 한칸 shift
					a[j] = a[j+1];
				}
				
				if(a[7] == 0) { // 암호생성 끝나면  break
					c = false;
					break;
				}
				
			}
		}
		if(c) // 안끝나면 cycle 반복
			cycle(a);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			
			int ts = sc.nextInt();
			
			for (int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}
			
			cycle(arr);
			
			System.out.print("#" + i + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}

}
