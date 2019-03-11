package com.ssafy.algo;

import java.util.Arrays;

public class Solution_이진검색_김규석 {

	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int key = 8; // 찾으려는 데이터
		
		
		//재귀
		binarySearch(a, 0, a.length-1, key);
		
		/*
		int index;
		if ((index = Arrays.binarySearch(a, key)) >= 0) {
			System.out.println("찾음 "+index);
		} else {
			System.out.println("못찾음");
		}
		*/
		
		/* 
		int l = 0;
		int r = a.length-1;
		while(l <= r) { // 반복문
			int mid = (l + r)/2; // 중간 인덱스 
			if (key == a[mid]) {
				System.out.println(key + "찾음");
				break;
			} else if (key < a[mid]) { // 작은쪽으로 범위 재설정
				r = mid - 1;
			} else { // key > a[mid] // 큰쪽으로 범위 재설정
				l = mid + 1;
			}
		}
		if (l > r) {
			System.out.println(key+"없음");
		}
		*/
	}
	
	public static void binarySearch(int[] a, int l, int r, int key) {
		if(l > r) { // 종료파트
			System.out.println("검색 실패");
			return;
		} else {
			int mid = (l+r)/2; // 중간 인덱스
			System.out.println(mid);
			if (key == a[mid]) {
				System.out.println("찾음");
				return;
			} else if(key < a[mid]) { // 작은 쪽으로 범위 재설정
				binarySearch(a, l, mid-1, key);
			} else { // if (key > a[mid]) // 큰 쪽으로 범위 재설정
				binarySearch(a, mid+1, r, key);
			}
		}
	}
}
