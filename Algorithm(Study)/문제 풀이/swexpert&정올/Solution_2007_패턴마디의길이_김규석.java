package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2007_패턴마디의길이_김규석 {

	static int c;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ts = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= ts; t++) {
			
			String str = br.readLine();
			
			c = 1;
			System.out.print("#"+t+ " ");
			check(str, c);
			
		}
	}
	
	public static void check(String str, int c) {
		
		int s = c - 0;
		
		if(str.substring(0, c).equals(str.substring(c, c+s))) {
			String str2 = str.substring(0, c);
			System.out.println(str2.length());
		}
		else
			check(str, c+1);
	}

}
