package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1228_SW�����ذ�⺻8����_��ȣ��1_��Լ� {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) { // �׽�Ʈ ���̽� �ݺ�
			
			ArrayList<String> strArr = new ArrayList<String>(); // ������ arraylist ����
			
			int num = Integer.parseInt(br.readLine()); // ���� �Է�
			
			String[] str = new String[num]; // ���ڸ�ŭ string ����
			
			str = br.readLine().split(" ");
			
			for (int j = 0; j < str.length; j++) {
				strArr.add(str[j]);
			}
			
			
			int orderNum = Integer.parseInt(br.readLine());
			
			String[] newStr = new String[orderNum];
			
			newStr = br.readLine().split("I "); // split���� �ʿ��� �κи� ����
			
			for (int j = 0; j < newStr.length; j++) {
				newStr[j] = newStr[j].trim(); // ���� ����
			}
			
			String[] chk = new String[newStr.length];
			
			for (int j = 1; j <= orderNum; j++) {
				chk = newStr[j].split(" ");
				
				int index = Integer.parseInt(chk[0]); // ù��° ���� ������ �ε��� ��������
				
				for (int k = chk.length-1; k > 1; k--) { // �ش� �ε����� list�� �߰�
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
