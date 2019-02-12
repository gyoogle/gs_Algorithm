package com.ssafy.incheon;

import java.util.Scanner;

public class Problem10819 {
	
	static int[] t = new int[27483084]; // static으로 배열 선언
	static int cnt = 0; // static으로 int형 변수 선언
	
	public static void swap(int[] arr, int a, int b){ // swap 메소드
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void perm(int[] set, int size, int n, int k){ // 순열 메소드
		
		int sum = 0;
		
		if(size == k){
			for (int i = 0; i < size-1; i++) {
				sum += Math.abs(set[i]-set[i+1]); // 절대값 합 저장
			}
			t[cnt] = sum;
			cnt++;
			return;
		}
		
		for (int i = size; i < n; i++) {
			swap(set, i, size);
			perm(set, size+1, n, k);
			swap(set, i, size);
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int[] arr = new int[count+1];
		int[] set = new int[100];
		
		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < count; i++) {
			set[i] = arr[i];
		}
		
		perm(set, 0, count, count);
		
		int max = 0; // 최대값 저장
		
		for (int i = 0; i < cnt; i++) {
			if(max <= t[i]) max = t[i];
		}
		
		System.out.println(max);
		
	}

}
