package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_3459_���ڿ���_��Լ� {
	
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
		
			long num = Long.parseLong(br.readLine());
			
			while(num > 2) {
				num -= 2;
				num /= 4;
			}
			
			String str = num == 1 ? "Bob" : "Alice";
					
			System.out.println("#" + t + " " + str);
		}
	}
	
}
