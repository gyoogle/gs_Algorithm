package com.ssafy.algo;

public class Z22_MergeSort {

	public static int[] sort = new int[20];
	
	public static void merge(int[] arr, int start, int middle, int end) {
		
		int i, j, k;
		
		i = start;
		j = middle+1;
		k = start;
		
		while (i <= middle && j <= end) {
			if(arr[i] <= arr[j])
				sort[k] = arr[i++];
			else
				sort[k] = arr[j++];
			k++;
		}
		
		if(i > middle) {
			for (int t = j; t <= end; t++, k++) {
				sort[k] = arr[t];
			}
		} else {
			for (int t = i; t <= middle; t++, k++) {
				sort[k] = arr[t];
			}
		}
		
		for (int t = start; t <= end; t++) {
			arr[t] = sort[t];
		}
		
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println();
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		
		int middle; // 중간 값 선언
		
		if(start < end) {
			middle = (start+end)/2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			merge(arr, start, middle, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		mergeSort(arr, 0, arr.length-1);
		
	}

}
