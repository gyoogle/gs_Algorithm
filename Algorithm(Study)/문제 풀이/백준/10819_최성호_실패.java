package backjoon;

import java.util.Scanner;

public class b10819 {
	
	static int sum = 0;
	static int max = 0;
	
	public static void swap(int[] arr, int i, int size) {
		int tmp = arr[i];
		arr[i] = arr[size];
		arr[size] = tmp;
	}
	
	public static void sum(int[] arr, int size) {
		sum = 0;
		for (int i = 0; i < arr.length-1; i++) {
			//System.out.print(arr[i] + " ");
			sum += Math.abs(arr[i] - arr[i+1]);
		}
		//System.out.println();
		if(max < sum) {
			max = sum;
		}
	}
	
	public static void perm(int[] arr, int size, int n, int r) {
		if(size == r) {
			sum(arr, size);
			return;
		}
		for (int i = size; i < n; i++) {
			swap(arr, i, size);
			perm(arr, size+1, n, r);
			swap(arr, i, size);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		perm(arr, 0, n, 2); // size , n, r
		
		System.out.print(max);
		
	}

}
