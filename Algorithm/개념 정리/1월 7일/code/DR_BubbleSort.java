package com.ssafy.algo;

public class DR_BubbleSort {
	
	static void BubbleSort(int a[], int n) {
		
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] data = {55, 7, 78, 12 ,42};
		
		BubbleSort(data, data.length);
	}

}
