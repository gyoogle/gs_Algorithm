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
			
			String number = br.readLine(); // ó�����ڸ� String ���·� �޴´�
			int number_size = number.length();
			int[] arr = new int[number_size];
			for (int i = 0; i < number_size; i++) {
				arr[i] = number.charAt(i) - '0'; // number�� �ѱ��ھ� int���·� �迭�� �ִ´�
			}
			int sum;
			while(true) {
				number = ""; // ���� sum�� number�� ���̱� ���� number�� �ʱ�ȭ ���ش�
				sum = 0;
				for (int i = 0; i < number_size; i++) {
					sum += arr[i]; // sum�� ���ϰ�
				}
				if(sum < 10) { // sum�� 10���� �۴ٸ� ��, ���ڸ� �����̸� ��
					break;
				}
				else if(sum >= 10) { // �ƴѰ��� sum�� number�� �ٿ��ְ� sum�� ���ڸ� ���ڰ� �ɶ� ���� while���� �ߴ� ������ �ݺ��Ѵ�
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
