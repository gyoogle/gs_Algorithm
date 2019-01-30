package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1225_SW�����ذ�⺻7����_��ȣ������_��Լ� {

	static int[] arr = new int[10];
	
	public static void cycle(int[] a) {
		
		boolean c = true;
		
		for (int i = 1; i <= 5; i++) {
			
			if(a[0] >= 0) { // ù��° �迭 ���� 0 �̻��� ��
				a[0] -= i;
				if(a[0] < 0) a[0] = 0; // ���� 0���� �۾����� 0����
				a[8] = a[0]; // rotate�� ���� 8��° �迭�� 0�� �ֱ�
				
				for (int j = 0; j < 8; j++) { // rotate
					a[j] = a[j+1];
				}
				
				if(a[7] == 0) { // ���� �� ���� 0�̸� cycle ������
					c = false;
					break;
				}
				
			}
		}
		if(c)
			cycle(a);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			
			int ts = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			
			for (int j = 0; j < 8; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			cycle(arr);
			
			System.out.print("#" + i + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}

}