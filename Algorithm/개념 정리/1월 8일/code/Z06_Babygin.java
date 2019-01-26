package com.ssafy.algo;

import java.util.Arrays;

// Babygin Ž�������� Ǯ��

public class Z06_Babygin {

	public static void main(String[] args) {
		
		/*
		int[] card = {4, 4, 4, 4, 4, 4};
		
		int[] cnt = new int[10]; // �� ���ں� Ƚ�� ī����
		
		// ���� ī���� ��� Ƚ��
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
		
		System.out.println(Arrays.toString(cnt));
		
		// ���ӵ� 3���� ���� or 3�� �̻� ���� ���ڸ� ã��
		for (int i = 0; i < cnt.length; i++) {
			if(i+2 < cnt.length && cnt[i] >= 1 && cnt[i+1] >= 1 && cnt[i+2] >= 1) { //run
				System.out.println("RUN");
				cnt[i]--;
				cnt[i+1]--;
				cnt[i+2]--;
				i--;
			}
			if(cnt[i] >= 3) {// triplet
				System.out.println("TRIPLET");
				cnt[i] -= 3;
				i--;
			}
		}
		*/
		
		int[] card = {0, 1, 4, 4, 4, 2};
		
		int[] cnt = new int[12]; // �� ���ں� Ƚ�� ī����
		
		// ���� ī���� ��� Ƚ��
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
		
		System.out.println(Arrays.toString(cnt));
		
		cnt[10] = cnt[0];
		cnt[11] = cnt[1];
		
		// ���ӵ� 3���� ���� or 3�� �̻� ���� ���ڸ� ã��
		int check = 0;
		for (int i = 0; i < 10; i++) {
			if(cnt[i] >= 1 && cnt[i+1] >= 1 && cnt[i+2] >= 1) { //run
				System.out.println("RUN"); check++;
				cnt[i]--;
				cnt[i+1]--;
				cnt[i+2]--;
				i--;
			}
			if(cnt[i] >= 3) {// triplet
				System.out.println("TRIPLET"); check++;
				cnt[i] -= 3;
				i--;
			}
		}
		
		if(check == 2) System.out.println("Babygin");
		else System.out.println("Not Babygin");
		
	}

}
