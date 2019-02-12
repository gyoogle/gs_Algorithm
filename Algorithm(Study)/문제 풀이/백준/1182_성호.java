package backjoon;

import java.util.Scanner;

public class b1182 {
	
	static int cnt = 0;
	
	public static void sum(int[] arr, int[] arr_index, int size, int N, int S, int index) {
		int sum = 0;
		/*for(int i = 0; i < size; i++) {
			System.out.print(arr_index[i]);
		}
		System.out.println();*/
		for (int i = 0; i < size; i++) {
			
			int j = arr_index[i];
			sum += arr[j];
			
		}
		if(size != 0) {
			if(sum == S) {
				
				cnt++;
			}
		}
		
		
	}
	
	public static void subset(int[] arr, int[] arr_index, int size, int N, int S, int index) {
		// 인덱스로 사용할 부분집합만 만들어줌
		if(N == index) {
			sum(arr, arr_index, size, N, S, index);
			return;
		}
		arr_index[size] = index;
		subset(arr, arr_index, size+1, N, S, index+1);
		subset(arr, arr_index, size, N, S, index+1);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//n
		int S = sc.nextInt();
		int[] arr = new int[N];
		int[] arr_index = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		subset(arr, arr_index, 0, N, S, 0);
		System.out.println(cnt);
	}

}
