package com.ssafy.algo;

import java.util.Scanner;

public class Solution_5431_�μ����ǰ���üũ�ϱ�_��Լ� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		
		for (int i = 0; i < ts; i++) {
			
			//ù° ��
			int stu = sc.nextInt(); //������ ��
			int okNum = sc.nextInt(); //���� ���� ��� ��
			
			int[] stuNum = new int[stu]; // ������ �� ��ŭ �迭 ����
			
			for (int j = 0; j < okNum; j++) { // ���� ��� ����
				int num = sc.nextInt();
				stuNum[num-1]++;
			}
			
			System.out.print("#" + (i+1) + " ");
			
			for (int j = 0; j < stuNum.length; j++) { // ���� ���� ��� ���
				if(stuNum[j] == 0) {
					System.out.print(j+1 + " ");
				}
			}
			System.out.println();
			
		}
	}

}
