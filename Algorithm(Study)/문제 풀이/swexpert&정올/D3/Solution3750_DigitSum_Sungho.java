package com.sea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3750_DigitSum_Sungho {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= test_case; tc++) {
			
			String number = br.readLine(); // 처음숫자를 String 형태로 받는다
			int number_size = number.length();
			int[] arr = new int[number_size];
			for (int i = 0; i < number_size; i++) {
				arr[i] = number.charAt(i) - '0'; // number를 한글자씩 int형태로 배열에 넣는다
			}
			int sum;
			while(true) {
				number = ""; // 계산된 sum을 number에 붙이기 위해 number를 초기화 해준다
				sum = 0;
				for (int i = 0; i < number_size; i++) {
					sum += arr[i]; // sum을 구하고
				}
				if(sum < 10) { // sum이 10보다 작다면 즉, 한자리 숫자이면 끝
					break;
				}
				else if(sum >= 10) { // 아닌경우는 sum을 number에 붙여주고 sum이 한자리 숫자가 될때 까지 while전에 했던 과정을 반복한다
					number += sum;
					number_size = number.length();
					arr = new int[number_size];
					for (int i = 0; i < number_size; i++) {
						arr[i] = number.charAt(i) - '0';
					}
				}
			}
			System.out.println("#" + tc + " " +  sum);
			
		} // end of tc
	} // end of main
} // end of class
