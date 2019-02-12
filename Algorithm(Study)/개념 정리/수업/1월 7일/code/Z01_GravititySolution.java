package com.ssafy.algo;

public class Z01_GravititySolution {

	public static void main(String[] args) {
		int[] m = {7,4,2,0,0,6,0,7,0};
		
		int maxCnt = 0;
		for (int i = 0; i < m.length; i++) {
			int cnt = 0;
			
			for (int j = i+1; j < m.length; j++) { // �� ��ġ �����ʿ� �� ������ ���� �� ���� ī����
				if(m[i] > m[j]) cnt++;
			}
			if(maxCnt < cnt) maxCnt = cnt;
		}
		System.out.println("�ִ� ���� : " + maxCnt);
		
		/*
		int[][] room = new int[8][9]; // 8�� 9�� ����
		
		// 1���� �迭�� �о �ڽ� ä���
		for (int i = 0; i < 9; i++) { // �� (0~8����)
			for (int j = 7; m[i] > 0; j--, m[i]--) { // ��
				room[j][i] = 1;
			}
		}
		
		// 90�� ���������� ȸ��
		int[][] nroom = new int[9][8]; // 9�� 8��
		for (int i = 0; i < room.length; i++) { //8��
			for (int j = 0; j < room[i].length; j++) {
				nroom[j][7-i] = room[i][j];
			}
		}
		
		
		// ����Ʈ����
		int maxGap = 0;
		for (int i = 7; i >= 0; i--) { //�� (8���� �ȶ������Ƿ� 7�����)
			for (int j = 0; j < nroom[i].length; j++) {
				
				int gap = 0; // ���� ī����
				
				if(nroom[i][j] == 1) { //�ڽ��� �Ʒ��� ����Ʈ����
					for (int k = 0; k < 9; k++) {
						if(i+k+1 >= 9 || nroom[i+k+1][j] == 1) break; // �Ʒ� ĭ�� �ڽ��� �ƴϾ�� ��
						
						nroom[i+k][j] = 0; // �ڽ��� �Ʒ��� ������
						nroom[i+k+1][j] = 1;
						gap++;
					}
					if(maxGap <= gap) maxGap = gap;
				}
			}
		}
		
		System.out.println("�ִ� ���� : " + maxGap);
		
		
		for (int i = 0; i < room.length; i++) { //��
			for (int j = 0; j < room[i].length; j++) { //��
				System.out.print(room[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < nroom.length; i++) { //��
			for (int j = 0; j < nroom[i].length; j++) { //��
				System.out.print(nroom[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
	} // end of main
} // end of class
