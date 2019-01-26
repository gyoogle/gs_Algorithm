package com.ssafy;

import java.util.Arrays;
import java.util.Random;

public class MyLotto {
	
	static int[] num = new int[6];
	
	static void selectLotto() {
		
		for(int i = 0; i < num.length; i++) {
			num[i] = uniqueNumber(i+1);
		}
		Arrays.sort(num);
	}
	
	private static int uniqueNumber(int index) {
		int imsi;
		boolean eq;
		Random ran = new Random();
		
		do {
			imsi = ran.nextInt(45)+1;
			eq= false;
			
			for(int j = 0; j < index; j++) {
				if(imsi == num[j]) {
					eq=true;
					break;
				}
			}
		} while (eq);
		
		return imsi;
	}
	
	static void print() {
		System.out.print("* 로또당첨번호는 => ");
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	public static void main(String[] args) {
		selectLotto();
		print();
	}
}
