package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1228_SW문제해결기본8일차_암호문1_김규석 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) { // 테스트 케이스 반복
			
			ArrayList<String> strArr = new ArrayList<String>(); // 저장할 arraylist 생성
			
			int num = Integer.parseInt(br.readLine()); // 숫자 입력
			
			String[] str = new String[num]; // 숫자만큼 string 생성
			
			str = br.readLine().split(" ");
			
			for (int j = 0; j < str.length; j++) {
				strArr.add(str[j]);
			}
			
			
			int orderNum = Integer.parseInt(br.readLine());
			
			String[] newStr = new String[orderNum];
			
			newStr = br.readLine().split("I "); // split으로 필요한 부분만 저장
			
			for (int j = 0; j < newStr.length; j++) {
				newStr[j] = newStr[j].trim(); // 공백 제거
			}
			
			String[] chk = new String[newStr.length];
			
			for (int j = 1; j <= orderNum; j++) {
				chk = newStr[j].split(" ");
				
				int index = Integer.parseInt(chk[0]); // 첫번째 인자 값으로 인덱스 가져오기
				
				for (int k = chk.length-1; k > 1; k--) { // 해당 인덱스를 list에 추가
					strArr.add(index, chk[k]);
				}
			}
			
			
			System.out.print("#"+i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(strArr.get(j) + " ");
			}
			System.out.println();
		}
	}

}
