package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= ts; i++) {
			
			int num = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			int[] intarr = new int[arr.length];
			
			for (int j = 0; j < arr.length; j++) {
				intarr[j] = Integer.parseInt(arr[j]);
			}
			
			int max = intarr[num-1];
			long cnt = 0; 
			
			for (int j = num-1; j >= 0; j--) {
				if(max >= intarr[j]) {
					cnt += max-intarr[j];
				}
				else {
					max = intarr[j];
				}
			}
			
			
			
			System.out.println("#"+i+ " " + cnt);
		}
	}

}
