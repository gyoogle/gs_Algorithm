package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_SW�����ذ�⺻9����_��Ģ������ȿ���˻�_��Լ� {
	
	
	public static boolean chk(String s) {
		
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = 10;
		
		for (int ts = 1; ts <= testcase; ts++) {
			
			int V = Integer.parseInt(br.readLine()); // ���� ����
			
			int[] arr = new int[V];
			
			int cnt = 1;
			boolean check = true;
			
			for (int i = 0; i < arr.length; i++) {
				
				if(arr.length % 2 == 0) {
					check = false;
				}
				
				String[] str = br.readLine().split(" ");
				
				if(str.length == 4) {
					if(!chk(str[1])) {
						check = false;
					}
				}
				
				else if(str.length == 2) {
					if(chk(str[1])) {
						check = false;
					}
				}
			}
			
			
			if(!check) cnt = 0;
			System.out.println("#"+ts + " " + cnt);
		}
		
	}

}
