package com.ssafy.algo;

import java.util.Scanner;

public class Solution_1204_SW문제해결기본1이라최빈수구하기_김규석 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int ts = s.nextInt();
		
		
		for (int i = 0; i < ts; i++) {
			int maxCnt = 0;
			int maxScore = 0;
			int[] students = new int[1000];
			int[] scoreCnt = new int[101];
			
			int tsNum = s.nextInt();
			
			for (int j = 0; j < students.length; j++) {
				int score = s.nextInt();
				scoreCnt[score]++;
			}
			
			
			for (int z = 0; z < scoreCnt.length; z++) {
				if(maxCnt <= scoreCnt[z]) maxCnt = scoreCnt[z];
			}
			
			int tmp = 0;
			
			for (int z = 0; z < scoreCnt.length; z++) {
				
				if(scoreCnt[z] == maxCnt) {
					if(tmp <= z){
						tmp = z;
						maxScore = tmp;
					}
				}
			}
			
			
			System.out.println("#"+ tsNum + " " + maxScore);
		}
	}

}
