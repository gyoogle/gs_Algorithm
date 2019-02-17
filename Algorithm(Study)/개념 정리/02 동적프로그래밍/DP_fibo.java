package com.ssafy.algo;

import java.util.HashMap;

public class DP_fibo {

	static int count = 0; // �Լ� ȣ�� ��
	static int index = 30; // �Ǻ���ġ  ��
	static int result = 0; // �Ǻ���ġ ��� ��
	
	static double start, end = 0; // �ð� ����
	
	public static void main(String[] args) {
		
		//�Ϲ� �Ǻ���ġ
		start = System.currentTimeMillis();
		result = fibo(index);
		end = System.currentTimeMillis();
		
		System.out.println("[�Ϲ� �Ǻ���ġ] index:" + index + ", �����:" + result);
		System.out.println("�Լ� ȣ�� ��: " + count + ", ����ð�: " + (end-start) + "ms");
		
		System.out.println("=====================================");
		
		count = 0;
		result = 0;
		
		//DP �Ǻ���ġ
		HashMap<Integer, Integer> dp = new HashMap<>();
		
		start = System.currentTimeMillis();
		result = fibo_DP(dp, index);
		end = System.currentTimeMillis();
		
		System.out.println("[DP �Ǻ���ġ] index:" + index + ", �����:" + result);
		System.out.println("�Լ� ȣ�� ��: " + count + ", ����ð�: " + (end-start) + "ms");
		
	}
	
	public static int fibo(int index){
		count++; // �Լ� ȣ�� �� ����
		
		if(index == 0) {
			return 0;
		} else if (index <= 2){
			return 1;
		} else {
			return fibo(index-1) + fibo(index-2);
		}
	}
	
	public static int fibo_DP(HashMap<Integer, Integer> dp, int index){
		count++; // �Լ� ȣ�� �� ����
		
		if(dp.containsKey(index)){ // �������� ������ �� �� return
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
