package com.ssafy.algo;

import java.util.Arrays;

// Babygin 탐욕기법으로 풀기

public class Z06_Babygin {

	public static void main(String[] args) {
		
		/*
		int[] card = {4, 4, 4, 4, 4, 4};
		
		int[] cnt = new int[10]; // 각 숫자별 횟수 카운팅
		
		// 숫자 카드의 사용 횟수
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
		
		System.out.println(Arrays.toString(cnt));
		
		// 연속된 3개의 숫자 or 3번 이상 사용된 숫자를 찾기
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
		
		int[] cnt = new int[12]; // 각 숫자별 횟수 카운팅
		
		// 숫자 카드의 사용 횟수
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
		
		System.out.println(Arrays.toString(cnt));
		
		cnt[10] = cnt[0];
		cnt[11] = cnt[1];
		
		// 연속된 3개의 숫자 or 3번 이상 사용된 숫자를 찾기
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
