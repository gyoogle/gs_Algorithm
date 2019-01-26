package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	static boolean check(int n) {
		if(n == 0) 
			return false;
		else
			return true;
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count[] = new int[10];
		
		while(true) {
			int num = s.nextInt();
			if (check(num) == false) break;
			
			for(int i = 0; i < 10; i++) {
				if(num/10 == i) count[i]+=1;
			}
		}
		
		for(int j = 0; j < 10; j++) {
			if(count[j] == 0) continue;
			else System.out.println(j + " : " + count[j] + "°³");
		}
	}

}
