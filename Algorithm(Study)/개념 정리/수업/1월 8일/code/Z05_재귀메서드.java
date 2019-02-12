package com.ssafy.algo;

import java.util.Arrays;

public class Z05_재귀메서드 {

	public static void main(String[] args) {
		int n = 5;
		//System.out.println(f(n));
		
		// 2진수 3자리를 구성할 수 있는 모든 경우의 수 재귀함수 출력
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					//System.out.println("" + i+j+k);
				}
			}
		}
		
		//binary(0, 3, new int[3]);
		
		
		//순열만들기
		//반복문
		/*
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					for (int m = 0; m < 2; m++) {
						for (int p = 0; p < 2; p++) {
							for (int q = 0; q < 2; q++) {
								if(i==1) System.out.print(s[0]);
								if(j==1) System.out.print(s[1]);
								if(k==1) System.out.print(s[2]);
								if(m==1) System.out.print(s[3]);
								if(p==1) System.out.print(s[4]);
								if(q==1) System.out.print(s[5]);
								System.out.println();
							}
						}
					}
				}
			}
		}
		*/
		
		
		//재귀함수
		binary2(0, 6, new int[s.length]);
	}
	static int[] s = {2, 3, 5, 7, 7, 7};
	
	public static int f(int n) {
		
		if(n == 1) {
			return 1;
		}else {
			return f(n-1) * n;
		}
		
	}
	
	//매개 변수 : 현재 차수, 마지막, 몇자리인지, 세자리 저장할 배열
	public static void binary(int i, int end, int[] arr) {
		
		if( i == end ) { // 종료 조건
			System.out.println(Arrays.toString(arr));
		} else {
			arr[i] = 0;
			binary(i+1, end, arr);
			arr[i] = 1;
			binary(i+1, end, arr);
		}
		
	}
	
	public static void binary2(int i, int end, int[] arr) {
		
		if( i == end ) { // 종료 조건
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == 1) System.out.print(s[j]);
			}
			System.out.println();
		} else {
			arr[i] = 0;
			binary2(i+1, end, arr);
			arr[i] = 1;
			binary2(i+1, end, arr);
		}
		
	}

}
