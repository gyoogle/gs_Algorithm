package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class DigitTest2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int start = 100;
		int num = s.nextInt();
		int num2;
		
		System.out.print(start + "\t" + num + " ");
		
		while(true) {
			num2 = start - num;
			System.out.print(num2 + " ");
			start = num;
			num = num2; 
			
			if(num2 < 0) break;
		}
	}

}
