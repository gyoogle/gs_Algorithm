package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_SW문제해결기본1일차_Flatten_김규석 {
	
	static int max = 0;
	
	public static int flatten(int arr[], int dump, int step) {
		
		if(dump < step) {
			return max;
		} else {
			
			if(arr[0] != arr[arr.length-1]) {
				arr[arr.length-1]--;
				arr[0]++;
			}
			
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			max = arr[arr.length-1] - arr[0];
			
			return flatten(arr, dump, step+1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] box = new int[100]; //박스 수
		
		
		for (int i = 1; i <= 10; i++) {
			
			int dump = sc.nextInt();
			
			for (int j = 0; j < box.length; j++) {
				box[j] = sc.nextInt();
			}
			
			Arrays.sort(box);
			
			System.out.print("#"+i +" ");
			System.out.println(flatten(box, dump, 1));
		}
		
		/*
		for (int i = 1; i <= 10; i++) {
			
			int max = 0; // 최대 높이 차
			int dump = sc.nextInt(); // 덤프 횟수
			
			for (int j = 0; j < box.length; j++) {
				box[j] = sc.nextInt(); // 박스별 높이 입력
			}
			
			for (int j = 0; j < dump; j++) { // 덤프 수만큼 반복
				int maxBox = 1; // 최소 1부터
				int minBox = 100; // 최대 100까지
				
				int maxNum = 0; // 최고 높이 박스 넘버
				int minNum = 0; // 최소 높이 박스 넘버
				
				for (int k = 0; k < box.length; k++) {
					if(maxBox <= box[k]) { // 최대높이 박스 넘버 구하기
						maxBox = box[k];
						maxNum = k;
					}
					if(minBox >= box[k]) { // 최소높이 박스 넘버 구하기
						minBox = box[k];
						minNum = k;
					}
				}
				
				box[maxNum]--; // 최고 높이 박스의 높이 하나 감소
				box[minNum]++; // 최소 높이 박스의 높이 하나 증가
				
				maxNum = 0; // 다시 초기화
				minNum = 0; // 다시 초기화
				
				for (int k = 0; k < box.length; k++) {
					if(maxBox <= box[k]) { // 최대높이 박스 넘버 구하기
						maxBox = box[k];
						maxNum = k;
					}
					if(minBox >= box[k]) { // 최소높이 박스 넘버 구하기
						minBox = box[k];
						minNum = k;
					}
				}
				
				max = box[maxNum] - box[minNum]; // 덤프 하나 옮긴 후 최고점과 최저점 차이
			}
			
			
			System.out.println("#" + i + " " + max);
		}
		*/
		
		
	}

}
