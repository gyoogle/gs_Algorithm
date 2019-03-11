package com.ssafy.algo;

import java.util.Arrays;

public class Solution_�����˻�_��Լ� {

	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int key = 8; // ã������ ������
		
		
		//���
		binarySearch(a, 0, a.length-1, key);
		
		/*
		int index;
		if ((index = Arrays.binarySearch(a, key)) >= 0) {
			System.out.println("ã�� "+index);
		} else {
			System.out.println("��ã��");
		}
		*/
		
		/* 
		int l = 0;
		int r = a.length-1;
		while(l <= r) { // �ݺ���
			int mid = (l + r)/2; // �߰� �ε��� 
			if (key == a[mid]) {
				System.out.println(key + "ã��");
				break;
			} else if (key < a[mid]) { // ���������� ���� �缳��
				r = mid - 1;
			} else { // key > a[mid] // ū������ ���� �缳��
				l = mid + 1;
			}
		}
		if (l > r) {
			System.out.println(key+"����");
		}
		*/
	}
	
	public static void binarySearch(int[] a, int l, int r, int key) {
		if(l > r) { // ������Ʈ
			System.out.println("�˻� ����");
			return;
		} else {
			int mid = (l+r)/2; // �߰� �ε���
			System.out.println(mid);
			if (key == a[mid]) {
				System.out.println("ã��");
				return;
			} else if(key < a[mid]) { // ���� ������ ���� �缳��
				binarySearch(a, l, mid-1, key);
			} else { // if (key > a[mid]) // ū ������ ���� �缳��
				binarySearch(a, mid+1, r, key);
			}
		}
	}
}
