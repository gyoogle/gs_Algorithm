package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_SW�����ذ�⺻1����_Flatten_��Լ� {
	
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
		
		int[] box = new int[100]; //�ڽ� ��
		
		
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
			
			int max = 0; // �ִ� ���� ��
			int dump = sc.nextInt(); // ���� Ƚ��
			
			for (int j = 0; j < box.length; j++) {
				box[j] = sc.nextInt(); // �ڽ��� ���� �Է�
			}
			
			for (int j = 0; j < dump; j++) { // ���� ����ŭ �ݺ�
				int maxBox = 1; // �ּ� 1����
				int minBox = 100; // �ִ� 100����
				
				int maxNum = 0; // �ְ� ���� �ڽ� �ѹ�
				int minNum = 0; // �ּ� ���� �ڽ� �ѹ�
				
				for (int k = 0; k < box.length; k++) {
					if(maxBox <= box[k]) { // �ִ���� �ڽ� �ѹ� ���ϱ�
						maxBox = box[k];
						maxNum = k;
					}
					if(minBox >= box[k]) { // �ּҳ��� �ڽ� �ѹ� ���ϱ�
						minBox = box[k];
						minNum = k;
					}
				}
				
				box[maxNum]--; // �ְ� ���� �ڽ��� ���� �ϳ� ����
				box[minNum]++; // �ּ� ���� �ڽ��� ���� �ϳ� ����
				
				maxNum = 0; // �ٽ� �ʱ�ȭ
				minNum = 0; // �ٽ� �ʱ�ȭ
				
				for (int k = 0; k < box.length; k++) {
					if(maxBox <= box[k]) { // �ִ���� �ڽ� �ѹ� ���ϱ�
						maxBox = box[k];
						maxNum = k;
					}
					if(minBox >= box[k]) { // �ּҳ��� �ڽ� �ѹ� ���ϱ�
						minBox = box[k];
						minNum = k;
					}
				}
				
				max = box[maxNum] - box[minNum]; // ���� �ϳ� �ű� �� �ְ����� ������ ����
			}
			
			
			System.out.println("#" + i + " " + max);
		}
		*/
		
		
	}

}
