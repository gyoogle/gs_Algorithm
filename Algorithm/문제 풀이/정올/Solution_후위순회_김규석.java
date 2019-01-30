package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_������ȸ_��Լ� {	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // ���� ����
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		char[] arr = new char[16]; // ���� 3 : 2^(3+1) = 16
		
		
		arr[1] = 'A'; // ��Ʈ ���� ��ȣ�� ����
		
		while(st.hasMoreTokens()) {
			char start = st.nextToken().charAt(0); // ������ ���� ����
			char end = st.nextToken().charAt(0); // ������ �� ����
			
			for (int i = 1; i < arr.length; i++) { // 0�� ������ �Ⱦ�, start�� ����� �迭�� ��ġ ã��
				if(start == arr[i]) {
					//�ڽ� ���� ����, ���� �ڽ��� ������ ���� ����, ������ �����ʿ� ����
					if (arr[i*2] == 0) { // �����ڽ��� ����
						arr[i*2] = end; // �����ڽĿ� ����
					} else {
						arr[i*2 + 1] = end; // �������ڽĿ� ����
					}
					break;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if ( i == 1 || i == 2 || i == 4 || i == 8 || i == 16) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		
		//System.out.println("\n������ȸ : ");
		//preOrder(arr, 1); // �迭, ��ȸ�� ������ ����(��Ʈ��Ʈ)
		//System.out.println("\n������ȸ : ");
		//inOrder(arr, 1);
		System.out.println("\n������ȸ : ");
		postOrder(arr, 1);
	}
	
	public static void postOrder(char[] arr, int index) {
		// ���� �ڽ�
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			postOrder(arr, index*2);
		}
		// ������ �ڽ�
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			postOrder(arr, index*2 + 1);
		}
		
		System.out.print(arr[index] + " "); // �θ� (��)
		
	}
	
	public static void inOrder(char[] arr, int index) {
		// ���� �ڽ�
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			inOrder(arr, index*2);
		}
		
		System.out.print(arr[index] + " "); // �θ� (��)
		
		// ������ �ڽ�
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			inOrder(arr, index*2 + 1);
		}
	}
	
	public static void preOrder(char[] arr, int index) {
		System.out.print(arr[index] + " "); // �θ� (��)
		// ���� �ڽ�
		if(index * 2 < arr.length && arr[index * 2] != 0) {
			preOrder(arr, index*2);
		}
		// ������ �ڽ�
		if(index * 2 < arr.length && arr[index * 2 + 1] != 0) {
			preOrder(arr, index*2 + 1);
		}
	}

}
