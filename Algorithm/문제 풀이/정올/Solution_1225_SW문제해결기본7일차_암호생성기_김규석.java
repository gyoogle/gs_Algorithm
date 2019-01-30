package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1225_SW문제해결기본7일차_암호생성기_김규석 {

	static int[] arr = new int[10];
	
	public static void cycle(int[] a) {
		
		boolean c = true;
		
		for (int i = 1; i <= 5; i++) {
			
			if(a[0] >= 0) { // 첫번째 배열 값이 0 이상일 때
				a[0] -= i;
				if(a[0] < 0) a[0] = 0; // 만약 0보다 작아지면 0으로
				a[8] = a[0]; // rotate를 위해 8번째 배열에 0값 넣기
				
				for (int j = 0; j < 8; j++) { // rotate
					a[j] = a[j+1];
				}
				
				if(a[7] == 0) { // 만약 끝 값이 0이면 cycle 나오기
					c = false;
					break;
				}
				
			}
		}
		if(c)
			cycle(a);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			
			int ts = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			
			for (int j = 0; j < 8; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
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