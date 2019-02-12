package com.test;

import java.util.Scanner;

public class น้มุ1182 {
	
	static int cnt = 0;

	public static void subset(int[] set, int size, int n, int[] arr, int index, int s) {
		
		if(n == index) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += set[i];
			}
			
			if(size != 0) {
				if(sum == s) {
					cnt++;
				}
			}
			return;
		}
		
		set[size] = arr[index];
		subset(set, size+1, n, arr, index+1, s);
		subset(set, size, n, arr, index+1, s);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] arr = new int[N+1];
		int[] set = new int[21];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		subset(set, 0, N, arr, 0, S);
		System.out.println(cnt);
	}

}
