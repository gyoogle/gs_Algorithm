package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2063_중간값찾기_김규석 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int ts = s.nextInt();
		
		int[] data = new int[ts];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = s.nextInt();
		}
		
		Arrays.sort(data);
		
		System.out.print(data[(data.length/2)]);
	}

}
