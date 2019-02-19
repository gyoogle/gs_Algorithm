package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution_1213_String_김규석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			String chk = br.readLine(); // 검사할 단어
			String test = br.readLine(); // 문장
			
			int cnt = checking(chk, test);
			
			System.out.println("#"+i+" "+cnt);
		}
	}

	public static int checking(String chk, String test) {
		
		int count = 0;
		
		String[] arr = new String[test.length()-(chk.length()-1)];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = test.substring(i, i+chk.length());
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(chk)) {
				count++;
			}
		}
		
		return count;
	}
}
