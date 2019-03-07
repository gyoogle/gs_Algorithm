package com.ssafy.algo;

import java.util.HashMap;

public class DP_fibo {

	static int count = 0; // 함수 호출 수
	static int index = 30; // 피보나치  수
	static int result = 0; // 피보나치 결과 값
	
	static double start, end = 0; // 시간 측정
	
	public static void main(String[] args) {
		
		//일반 피보나치
		start = System.currentTimeMillis();
		result = fibo(index);
		end = System.currentTimeMillis();
		
		System.out.println("[일반 피보나치] index:" + index + ", 결과값:" + result);
		System.out.println("함수 호출 수: " + count + ", 수행시간: " + (end-start) + "ms");
		
		System.out.println("=====================================");
		
		count = 0;
		result = 0;
		
		//DP 피보나치
		HashMap<Integer, Integer> dp = new HashMap<>();
		
		start = System.currentTimeMillis();
		result = fibo_DP(dp, index);
		end = System.currentTimeMillis();
		
		System.out.println("[DP 피보나치] index:" + index + ", 결과값:" + result);
		System.out.println("함수 호출 수: " + count + ", 수행시간: " + (end-start) + "ms");
		
	}
	
	public static int fibo(int index){
		count++; // 함수 호출 수 증가
		
		if(index == 0) {
			return 0;
		} else if (index <= 2){
			return 1;
		} else {
			return fibo(index-1) + fibo(index-2);
		}
	}
	
	public static int fibo_DP(HashMap<Integer, Integer> dp, int index){
		count++; // 함수 호출 수 증가
		
		if(dp.containsKey(index)){ // 연산한적 있으면 그 값 return
			return dp.get(index);
		} else if (index == 0) {
			return 0;
		} else if (index <= 2) {
			return 1;
		} else {
			int val = fibo_DP(dp, index-1) + fibo_DP(dp, index-2);
			dp.put(index, val);
			
			return val;
		}
	}

}
